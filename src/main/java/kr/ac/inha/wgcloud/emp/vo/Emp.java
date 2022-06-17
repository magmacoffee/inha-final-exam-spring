package kr.ac.inha.wgcloud.emp.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Emp {
    private int empId;
    private String id;
    private String password;
    private String passwordCheck;
    private String nickname;
    private String email;
    private String phone;
    private boolean gender;
    private String createDateTime;
    private String updateDateTime;
}
