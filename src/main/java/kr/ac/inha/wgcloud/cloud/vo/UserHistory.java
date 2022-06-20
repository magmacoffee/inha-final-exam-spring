package kr.ac.inha.wgcloud.cloud.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserHistory {
    private String historyId;
    private String empId;
    private String dirId;
    private boolean isFile;
    private String summary;
    private String description;
    private String createDateTime;
    private String updateDateTime;
}
