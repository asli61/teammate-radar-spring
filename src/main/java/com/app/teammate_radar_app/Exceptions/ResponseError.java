package com.app.teammate_radar_app.Exceptions;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseError {
    private String message;
    private List<?> details;
}

