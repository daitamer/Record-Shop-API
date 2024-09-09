//package com.daitamer.Record.Shop.API.exception;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice
//public class GlobalExceptionHandler {
//    @ExceptionHandler ({RuntimeException.class})
//    public ResponseEntity<ErrorResponse> handleRuntimeException (RuntimeException ex){
//        ErrorResponse errorResponse = ErrorResponse.builder().exception(ex).build();
//        return ResponseEntity
//                .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                .body(errorResponse);
//    }
//
//}
