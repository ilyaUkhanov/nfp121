package com.g6.nfp121.models.error;

import lombok.Data;

@Data
public class ErrorFieldModel {
    private String slug;
    private String field;
    private String error;
}
