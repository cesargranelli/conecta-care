package com.sevenine.conecta.exception;

import lombok.Data;

@Data
public class ErrorDetail {

    private String title;
    private int status;
    private String detail;
    private long timeStamp;
    private String developerMessage;

}