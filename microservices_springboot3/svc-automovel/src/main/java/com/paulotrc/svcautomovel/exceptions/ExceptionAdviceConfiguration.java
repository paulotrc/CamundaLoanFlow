package com.paulotrc.svcautomovel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionAdviceConfiguration {

    @ResponseBody
    @ExceptionHandler(ResourceException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
    public GeneralError resourceExceptionHandler(ResourceException e) {
        GeneralError generalError = new GeneralError();
        generalError.setCode(HttpStatus.NOT_FOUND);
        generalError.setMessage(e.getMessage());
        return generalError;
    }

}