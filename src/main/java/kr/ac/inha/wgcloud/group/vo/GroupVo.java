package kr.ac.inha.wgcloud.group.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class GroupVo {
    private String groupId;
    private String empId;
    private String name;
    private boolean isDeleted;
    private boolean isPrivate;
    private String createDateTime;
    private String updateDateTime;
}
