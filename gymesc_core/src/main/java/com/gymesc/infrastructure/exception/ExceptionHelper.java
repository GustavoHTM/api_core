package com.gymesc.infrastructure.exception;

public class ExceptionHelper {

    public static BusinessException userNotFound() {
        return new BusinessException("exception.message.user.not.found");
    }

    public static BusinessException invalidPassword() {
        return new BusinessException("exception.message.invalid.password");
    }

    public static BusinessException invalidEmail() {
        return new BusinessException("exception.message.invalid.email");
    }

    public static BusinessException emailAlreadyExist() {
        return new BusinessException("exception.message.email.already.exists");
    }
}
