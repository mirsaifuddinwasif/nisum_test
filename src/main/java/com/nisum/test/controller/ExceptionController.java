package com.nisum.test.controller;

import com.nisum.test.constant.ClientMessage;
import com.nisum.test.dto.ClientResponse;
import com.nisum.test.exception.PersonaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {PersonaNotFoundException.class, EmptyResultDataAccessException.class})
    public ClientResponse handlePersonaNotFoundException(HttpServletRequest request, Exception ex) {
        log.error("Data Not Found");
        log.error("Exception occurred: ", ex);
        return new ClientResponse(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NullPointerException.class)
    public ClientResponse handleNullPointerException(HttpServletRequest request, NullPointerException ex) {
        log.error("Internal Server Error");
        log.error("Exception occurred: ", ex);
        return new ClientResponse(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    public ClientResponse handleException(HttpServletRequest request, Exception ex) {
        log.error(ClientMessage.SOMETHING_EXPECTED_ERROR_MESSAGE.getMessage());
        log.error("Exception occurred: ", ex);
        return new ClientResponse(ex, HttpStatus.BAD_REQUEST);
    }
}