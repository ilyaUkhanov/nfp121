package com.g6.nfp121.models.error;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorResponseModel {
    private LocalDateTime timestamp;
    private ErrorModel error;
    private Integer code;
}
