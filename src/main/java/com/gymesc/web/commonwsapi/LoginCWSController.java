package com.gymesc.web.commonwsapi;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gymesc.core.user.auth.UserJWTResponse;
import com.gymesc.core.user.enumeration.TrainingLevelEnum;
import com.gymesc.core.user.service.UserService;
import com.gymesc.core.user.service.UserServiceImpl;
import com.gymesc.infrastructure.exception.BusinessException;

import jakarta.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/commons-wsapi/user")
public class LoginCWSController {

    private static final Logger logger = Logger.getLogger(LoginCWSController.class);

    UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<UserJWTResponse> login(HttpServletRequest request,
                                 @RequestParam(value = "email") String email,
                                 @RequestParam(value = "password") String password) throws BusinessException {

        UserJWTResponse userJWTResponse = this.userService.doLogin(email, password);

        return new ResponseEntity<>(userJWTResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/create-user")
    public ResponseEntity<Void> createUser(HttpServletRequest request,
                               @RequestParam(value = "email") String email,
                               @RequestParam(value = "password") String password,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "lastname") String lastname,
                               @RequestParam(value = "weight") Double weight,
                               @RequestParam(value = "height") Integer height,
                               @RequestParam(value = "trainingLevel") TrainingLevelEnum trainingLevelEnum) throws BusinessException {

        this.userService.createUser(email, password, name, lastname, weight, height, trainingLevelEnum);

        return ResponseEntity.ok().build();
    }

    @Autowired
    private void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}