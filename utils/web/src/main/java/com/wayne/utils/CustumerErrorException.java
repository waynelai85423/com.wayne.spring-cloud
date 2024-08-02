package com.wayne.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import feign.Response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonFormat.Shape.STRING;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustumerErrorException extends RuntimeException {
    /**
     * HTTP 狀態碼
     */
    String status;

    /**
     * 錯誤時間
     */
    @JsonFormat(shape = STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    OffsetDateTime timestamp;

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

    /**
     * 路徑
     */
    String path;

    public CustumerErrorException(String message){super(message);}

    public static class OffsetDateTimeDeserializer extends JsonDeserializer<OffsetDateTime> {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;

        @Override
        public OffsetDateTime deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException, JsonProcessingException {
            String date = p.getText();
            return OffsetDateTime.parse(date, FORMATTER);
        }
    }

    public static CustumerErrorException buildCustumerErrorException(Response response) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(response.body().asInputStream(), StandardCharsets.UTF_8))) {
            String responseBody = reader.lines().collect(Collectors.joining());
            ObjectMapper objectMapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer());
            objectMapper.registerModule(module);
            CustumerErrorException exception = objectMapper.readValue(responseBody, CustumerErrorException.class);
            return exception;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CustumerErrorException("INTERNAL_SERVER_ERROR");
    }

}