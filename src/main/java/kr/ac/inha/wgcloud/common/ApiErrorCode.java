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
    GROUP_NAME_DUPLICATE(HttpStatus.BAD_REQUEST, "중복된 이름의 그룹이 존재합니다."),
    ID_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 아이디 입니다."),
    NICK_EXISTS(HttpStatus.BAD_REQUEST, "이미 존재하는 닉네임 입니다."),
    PWD_CHECK_DIFFERENT(HttpStatus.BAD_REQUEST, "패스워드와 패스워드 확인이 일치하지 않습니다."),
    HAS_EMPTY_DATA(HttpStatus.BAD_REQUEST, "빈 칸이 존재합니다! 모든 항목을 채워주세요."),
    FILE_SAVE_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "파일 저장에 실패하였습니다. 관리자에게 문의하여 주세요."),
    NOT_MY_FILE(HttpStatus.NOT_ACCEPTABLE, "본인 소유의 파일이 아닙니다!"),
    CANNOT_DOWNLOAD(HttpStatus.BAD_REQUEST, "다운로드가 불가능합니다."),
    DOWNLOAD_FAILED(HttpStatus.INTERNAL_SERVER_ERROR, "다운로드를 요청하는 중 문제가 발생하였습니다.");

    private final HttpStatus httpStatus;
    private final String message;

}
