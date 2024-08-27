package com.gymesc.core.user.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gymesc.core.user.auth.UserBearerToken;
import com.gymesc.core.user.auth.UserJWTResponse;
import com.gymesc.core.user.enumeration.TrainingLevelEnum;
import com.gymesc.core.user.repository.User;
import com.gymesc.core.user.repository.UserRepository;
import com.gymesc.core.user.repository.dto.UserDTO;
import com.gymesc.infrastructure.Utils;
import com.gymesc.infrastructure.exception.BusinessException;
import com.gymesc.infrastructure.exception.ExceptionHelper;
import com.gymesc.infrastructure.jwt.JWTCore;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserJWTResponse doLogin(String email, String password) throws BusinessException {
        User user = this.userRepository.findByEmail(email);

        if (user == null) {
            throw ExceptionHelper.userNotFound();
        }

        if (!user.getPassword().equals(Utils.encodePassword(password))) {
            throw ExceptionHelper.invalidPassword();
        }

        UserBearerToken userBearerToken = new UserBearerToken(user.getId(), user.getEmail(), user.getFirstName());

        String jwt = JWTCore.USER_BEARER_IDENTIFICATION + JWTCore.parseUserBearerTokenToJWT(userBearerToken);
        UserDTO userDTO = new UserDTO().parse(user);

        return new UserJWTResponse(jwt, userDTO);
    }

    @Override
    public void createUser(String email, String password, String firstName, String lastName, Double weight, Integer height, TrainingLevelEnum trainingLevelEnum) throws BusinessException {
        User user = this.userRepository.findByEmail(email);

        if (user != null) {
            throw ExceptionHelper.emailAlreadyExist();
        }

        if (!Utils.isValidEmail(email)) {
            throw ExceptionHelper.invalidEmail();
        }

        String passwordProblem = Utils.validatePassword(password);
        if (StringUtils.isNotBlank(passwordProblem)) {
            throw new BusinessException(passwordProblem);
        }

        user = new User();
        user.setActive(true);
        user.setEmail(email);
        user.setPassword(Utils.encodePassword(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setWeight(weight);
        user.setHeight(height);
        user.setTrainingLevelEnum(trainingLevelEnum);

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public UserDTO findActiveUserById(Long id) {
        return this.userRepository.findById(id).map(user -> new UserDTO().parse(user)).orElse(null);
    }

    @Autowired
    private void setUserBO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
