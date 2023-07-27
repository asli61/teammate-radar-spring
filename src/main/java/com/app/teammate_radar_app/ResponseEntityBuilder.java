package com.app.teammate_radar_app;

import  org.springframework.http.ResponseEntity;

public class ResponseEntityBuilder {
    public static ResponseEntity<Object> build(LoginRegisterErrorHandler loginregistererrorhandler) {
        return new ResponseEntity<>(loginregistererrorhandler, loginregistererrorhandler.getStatus());
    }
}