package kr.ac.inha.wgcloud.file.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Builder
@ToString
public class FileVo {
    private int dirId;
    private String groupId;
    private String empId;
    private String rootDirId;
    private String name;
    private String orgFileName;
    private String ext;
    private long fileSize;
    private String filePath;
    private String sharedEmpId;
    private boolean isFile;
    private int downCount;
    private boolean isDeleted;
    private String createDateTime;
    private String updateDateTime;
    private String shareDateTime;s
}
