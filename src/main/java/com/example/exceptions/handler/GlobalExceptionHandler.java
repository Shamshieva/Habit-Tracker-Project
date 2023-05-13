package com.example.exceptions.handler;

import com.example.dto.response.ExceptionResponse;
import com.example.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionResponse handlerNotFound(NotFoundException e) {
        return new ExceptionResponse(HttpStatus.NOT_FOUND,
                e.getMessage(), NotFoundException.class.getSimpleName());
    }

    @ExceptionHandler(AlreadyExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ExceptionResponse handlerAlreadyExist(AlreadyExistException e) {
        return new ExceptionResponse(HttpStatus.CONFLICT,
                e.getMessage(),
                AlreadyExistException.class.getSimpleName());
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionResponse handlerBadRequest(BadRequestException e) {
        return new ExceptionResponse(HttpStatus.BAD_REQUEST,
                e.getMessage(),
                BadRequestException.class.getSimpleName());
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handlerForbidden(ForbiddenException e) {
        return new ExceptionResponse(HttpStatus.FORBIDDEN,
                e.getMessage(),
                ForbiddenException.class.getSimpleName());
    }

    @ExceptionHandler(BadCredentialException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handlerBadCredential(BadCredentialException e) {
        return new ExceptionResponse(
                HttpStatus.FORBIDDEN,
                e.getMessage(),
                BadRequestException.class.getSimpleName());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ExceptionResponse handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        String error = bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining("; "));
        return new ExceptionResponse(
                HttpStatus.BAD_REQUEST,
                e.getClass().getSimpleName(),
                error
        );
    }
}
