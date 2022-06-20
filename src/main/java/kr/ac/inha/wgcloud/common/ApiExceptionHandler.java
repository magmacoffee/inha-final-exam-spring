package kr.ac.inha.wgcloud.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private ErrorResponse getErrorResponse(ErrorCode errorCode) {
        return ErrorResponse.builder()
                .code(errorCode.getHttpStatus().toString())
                .message(errorCode.getMessage())
                .build();
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException ex) {
        return ResponseEntity
                .status(ex.getErrorCode().getHttpStatus())
                .body(getErrorResponse(ex.getErrorCode()));
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<?> handleInternalException(Exception ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(getErrorResponse(ApiErrorCode.INTERNAL_SERVER_ERROR));
    }

}
