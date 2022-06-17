package kr.ac.inha.wgcloud.file.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileVo {
    private String dirId;
    private String groupId;
    private String empId;
    private String rootDirId;
    private String name;
    private String ext;
    private double fileSize;
    private String filePath;
    private String sharedEmpId;
    private boolean isFile;
    private int downCount;
    private boolean isDeleted;
    private String createDateTime;
    private String updateDateTime;
}
