package com.gymesc.core.user.service;


import com.gymesc.core.user.auth.UserJWTResponse;
import com.gymesc.core.user.repository.dto.UserDTO;
import com.gymesc.core.user.enumeration.TrainingLevelEnum;
import com.gymesc.infrastructure.exception.BusinessException;

public interface UserService {

    UserJWTResponse doLogin(String email, String password) throws BusinessException;

    void createUser(String email, String password, String firstName, String lastName, Double weight, Integer height, TrainingLevelEnum trainingLevelEnum) throws BusinessException;

    UserDTO findActiveUserById(Long id);
}
