package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.common.ApiErrorCode;
import kr.ac.inha.wgcloud.common.ApiException;
import kr.ac.inha.wgcloud.file.repository.FileRepository;
import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    private static final String SAVE_PATH = "files/";

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    private String getCurPath(String rootId, String fileName) throws Exception {
        if (rootId == null || rootId.equals("")) {
            return "/" + fileName;
        } else {
            FileVo file = getFileById(rootId);
            if (file.getFilePath().equals("/")) {
                return "/" + fileName;
            }
            return file.getFilePath() + "/" + fileName;
        }
    }

    @Override
    public void save(String empId, String rootId, MultipartFile multi) throws Exception {
        save(empId, rootId,null, multi);
    }

    private File getSavePath() {
        File dir = new File(SAVE_PATH);
        if (!dir.exists()) {
            dir.mkdir();
        }
        return dir;
    }

    @Override
    public void save(String empId, String rootId, String groupId, MultipartFile multipartFile) throws Exception {
        String fileName = UUID.randomUUID().toString();
        File dir = getSavePath();
        File f = new File(dir.getAbsolutePath() + "/" + fileName);
        String orgFileName = multipartFile.getOriginalFilename();
        String name = orgFileName.substring(0, orgFileName.lastIndexOf("."));
        String ext = orgFileName.substring(orgFileName.lastIndexOf(".") + 1);
        try {
            multipartFile.transferTo(f);
            fileRepository.insertFile(
                FileVo
                    .builder()
                    .groupId(groupId)
                    .empId(empId)
                    .rootDirId(rootId)
                    .name(fileName) // 스토리지 저장 시 파일 구분용
                    .orgFileName(name) // 확장자 제거한 이름
                    .ext(ext)
                    .fileSize(multipartFile.getSize())
                    .filePath(f.getAbsolutePath())
                    .sharedEmpId(null)
                    .isFile(true)
                    .downCount(0)
                    .build()
            );
        } catch (Exception ex) {
            f.delete();
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public void mkdir(String empId, String rootId, String groupId, String name) throws Exception {
        String path = getCurPath(rootId, name);
        FileVo f = FileVo
            .builder()
            .groupId(groupId)
            .empId(empId)
            .rootDirId(rootId)
            .name(name) // 스토리지 저장 시 파일 구분용
            .orgFileName(name)
            .ext(null)
            .fileSize(0)
            .filePath(path)
            .sharedEmpId(null)
            .isFile(false)
            .downCount(0)
            .build();
        fileRepository.insertFile(f);
    }

    @Override
    public void mkdir(String empId, String rootId, String name) throws Exception {
        mkdir(empId, rootId, null, name);
    }

    @Override
    public void rename(String empId, String dirId, String newName) throws Exception {
        FileVo file = getFileById(dirId);
        if (file.getEmpId().equals(empId)) {
            fileRepository.updateName(dirId, newName);
        } else {
            throw new Exception("본인 소유의 파일이 아닙니다!");
        }
    }

    @Override
    public void remove(String empId, String dirId) throws Exception {
        FileVo file = getFileById(dirId);
        if (file.getEmpId().equals(empId)) {
            fileRepository.deleteFile(dirId);
        } else {
            throw new Exception("본인 소유의 파일이 아닙니다!");
        }
    }

    @Override
    public FileVo getFileById(String dirId) throws Exception {
        return fileRepository.selectFileById(dirId);
    }

    @Override
    public List<FileVo> getFileList(String dirId, String empId) throws Exception {
        return fileRepository.selectFileList(dirId, empId);
    }

    @Override
    public List<FileVo> getRootFileList(String empId) throws Exception {
        return fileRepository.selectRootFileList(empId);
    }

    @Override
    public List<FileVo> getShareFileList(String empId) throws Exception {
        return fileRepository.selectShareFileList(empId);
    }

    @Override
    public List<FileVo> getFolderContent(String dirId) throws Exception {
        return fileRepository.selectFolderContent(dirId);
    }

    @Override
    public void download(String dirId, HttpServletResponse res) throws Exception {
        FileVo file = fileRepository.selectFileById(dirId);
        if (!file.isFile() || file.isDeleted()) {
            throw new Exception("다운로드가 불가능 합니다.");
        }
        String fileName = URLEncoder.encode(file.getOrgFileName(), "UTF-8");
        res.setContentType("application/octet-stream");
        res.setHeader("Content-Transfer-Encoding", "binary;");
        res.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
        res.setHeader("X-Filename", fileName);
        OutputStream os = res.getOutputStream();
        int read;
        byte[] buf = new byte[1024];
        try (InputStream is = new FileInputStream(file.getFilePath())) {
            while ((read = is.read(buf)) != -1) {
                os.write(buf, 0, read);
            }
        }
        os.close();
    }

    @Override
    public void updateShareStatus(String empId, String targetEmpId, String dirId) throws Exception {
        FileVo fileVo = fileRepository.selectFileById(dirId);
        if (!fileVo.getEmpId().equals(empId)) {
            throw new ApiException(ApiErrorCode.SHARE_NOT_ALLOWED);
        } else if (empId.equals(targetEmpId)) {
            throw new ApiException(ApiErrorCode.CANNOT_SHARE_TO_ME);
        }
        fileRepository.updateShareStatus(targetEmpId, dirId);
    }

}
