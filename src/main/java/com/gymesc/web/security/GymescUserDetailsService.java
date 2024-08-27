package com.gymesc.web.security;

import com.gymesc.core.user.auth.GymescUserDetails;
import com.gymesc.core.user.auth.UserBearerToken;
import com.gymesc.core.user.repository.dto.UserDTO;
import com.gymesc.core.user.service.UserService;
import com.gymesc.infrastructure.jwt.JWTCore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class GymescUserDetailsService implements UserDetailsService {

    Logger logger = Logger.getLogger(GymescUserDetailsService.class.getName());

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String authentication) throws UsernameNotFoundException {

        try {
            if (authentication.startsWith(JWTCore.USER_BEARER_IDENTIFICATION)) {
                return this.loadUserByUserBearerToken(authentication);
            }
        } catch (Exception e) {
            logger.info("Falha na autenticação JWT - " + e.getMessage());
            throw new UsernameNotFoundException("Bearer inválido: " + authentication);
        }

        throw new UsernameNotFoundException("Bearer Token JWT não localizado");
    }

    private UserDetails loadUserByUserBearerToken(String authentication) {
        String jwt = authentication.substring(JWTCore.USER_BEARER_IDENTIFICATION.length());
        UserBearerToken userBearerToken = JWTCore.parseJWTToUserBearerToken(jwt, true);

        if (userBearerToken == null) {
            logger.info("Bearer Token JWT inválido");
            throw new UsernameNotFoundException("Token inválido: " + authentication);
        }

        UserDTO userDTO = userService.findActiveUserById(userBearerToken.getId());
        if (userDTO == null || !userDTO.getActive()) {
            logger.info("Login de usuário inexistente: " + userBearerToken.getId());
            throw new UsernameNotFoundException("Usuário inválido: " + authentication);
        }

        return new GymescUserDetails(userBearerToken.getId(), userBearerToken.getEmail(), true, null);
    }

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }
}