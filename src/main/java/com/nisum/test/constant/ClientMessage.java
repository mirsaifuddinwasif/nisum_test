package com.nisum.test.constant;

import lombok.Getter;

@Getter
public enum ClientMessage {
    SOMETHING_EXPECTED_ERROR_MESSAGE("Something Unexpected Happened");

    private String message;

    ClientMessage(String message) {
        this.message = message;
    }
}