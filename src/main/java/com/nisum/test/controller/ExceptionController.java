package com.nisum.test.controller;

import com.nisum.test.constant.ClientMessage;
import com.nisum.test.dto.ClientResponse;
import com.nisum.test.exception.PersonaNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ClientResponse defaultErrorHandler(HttpServletRequest request, Exception ex) {

        int status;

        if (ex instanceof PersonaNotFoundException) {
            status = HttpStatus.NOT_FOUND.value();
        } else if (ex instanceof NullPointerException || "null".equalsIgnoreCase(ex.getMessage())) {
            ex = new Exception(ClientMessage.SOMETHING_EXPECTED_ERROR_MESSAGE.getMessage());
            status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        } else {
            status = HttpStatus.BAD_REQUEST.value();
        }

        return new ClientResponse(ex.getMessage(), ex, status);
    }

}