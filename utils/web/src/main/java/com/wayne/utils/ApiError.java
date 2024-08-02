package com.wayne.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ApiError {
    /**
     * HTTP 狀態碼
     */
    HttpStatus status;

    /**
     * 錯誤時間
     */
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    LocalDateTime timestamp;

    /**
     * 錯誤訊息
     */
    String message;

    /**
     * debug 訊息
     */
    String debugMessage;

    /**
     * trace 訊息
     */
    String trace;

    public ApiError(HttpStatus status, String message, Throwable ex) {
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    public ApiError(HttpStatus status, String message,String trace, Throwable ex) {
        this.status = status;
        this.message = message;
        this.trace = trace;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
