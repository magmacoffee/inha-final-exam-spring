package kr.ac.inha.wgcloud.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ApiErrorCode implements ErrorCode {

    EMP_NOT_EXISTS(HttpStatus.FORBIDDEN, "존재하지 않는 임직원입니다."),
    CANNOT_SHARE_TO_ME(HttpStatus.BAD_REQUEST, "본인에게는 공유가 불가능합니다."),
    SHARE_NOT_ALLOWED(HttpStatus.BAD_REQUEST, "공유할 수 없는 파일 혹은 폴더입니다."),
    CANNOT_ADD_ME(HttpStatus.BAD_REQUEST, "본인은 추가할 수 없습니다."),
    GROUP_NAME_DUPLICATE(HttpStatus.BAD_REQUEST, "중복된 이름의 그룹이 존재합니다.");
    private final HttpStatus httpStatus;
    private final String message;

}
