package com.diegodev.delist.controllers;

import com.diegodev.delist.services.exceptions.GameExceptionNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

@ControllerAdvice
public class ExceptionHendller {


    @ExceptionHandler({GameExceptionNotFound.class})
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ProblemDetail resourceNotFound(final Throwable throwable){

        var message = throwable.getMessage();
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);

        problemDetail.setTitle("Não encontrado!");
        problemDetail.setType(URI.create("http://www.diegodev.com/devdocs/errors/not_found"));

        return problemDetail;
    }
}
