package com.example.visa.controller.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.visa.dto.exception.Erors;
import com.example.visa.util.HandledException;

import io.jsonwebtoken.ExpiredJwtException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(org.springframework.dao.EmptyResultDataAccessException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Erors TodoException(Exception ex, WebRequest request) {
        return new Erors(10100, "Object does not exist");
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Erors loginErors(Exception ex, WebRequest request) {
        return new Erors(10000, "Incorecct username or password");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public Erors registerFail(Exception ex, WebRequest request) {
        return new Erors(10000, "userId already taken");
    }

    @ExceptionHandler(HandledException.class)
    public Erors useFounldErors(HandledException ex, WebRequest request) {
        if (ex.getCode().equals("USERNOTFOULD")) {
            return new Erors(0001, "Uses not fould");
        }
        if (ex.getCode().equals("COINISNULL")) {
            return new Erors(0002, "CoinId is null in coinmarketcap");
        }
        if (ex.getCode().equals("notIsNullAccount")) {
            return new Erors(1030, "Already created accounts coin for this userid code");
        }
        return null;
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public Erors jwtTimeFail(ExpiredJwtException ex, WebRequest request) {
        return new Erors(12000, ex.getMessage());
    }
}
