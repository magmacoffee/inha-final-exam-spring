package kr.ac.inha.wgcloud.common;

import org.springframework.http.HttpStatus;

public interface ErrorCode {
    String getMessage();
    HttpStatus getHttpStatus();
}
