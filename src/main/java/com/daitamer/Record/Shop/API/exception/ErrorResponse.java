//package com.daitamer.Record.Shop.API.exception;
//
//import com.fasterxml.jackson.annotation.JsonProperty;
//import lombok.Builder;
//
//public class ErrorResponse {
//
//    @JsonProperty(value = "name")
//    private final String errorName;
//
//    @JsonProperty(value = "message")
//    private final String errorMessage;
//
//    @Builder
//    public ErrorResponse(Exception exception) {
//        this.errorName = exception.getClass().getSimpleName();
//        this.errorMessage = exception.getMessage();
//    }
//}
