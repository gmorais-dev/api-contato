package com.project_Test.Exceptions.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorMessage {

    private Integer status;
    private Instant timestamp;

    private String error;

    private String messagem;

    private String path;
}
