package com.example.mybackendspringboot.util;

import lombok.Value;

@Value
public class ErrorResponse {

    String message;
    long timestamp;
}
