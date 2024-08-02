package com.wayne.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@CrossOrigin
@RestControllerAdvice(annotations = RestController.class)
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleConnectException(Exception ex) {
        val apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,"服務無回應",ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(CustumerErrorException.class)
    public ResponseEntity<Object> handleFeignException(CustumerErrorException ex) {
        log.error("FeignException: ", ex);
        val apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),ex.getTrace(),ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
