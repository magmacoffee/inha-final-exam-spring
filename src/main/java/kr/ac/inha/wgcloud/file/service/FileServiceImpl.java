package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.file.repository.FileRepository;
import kr.ac.inha.wgcloud.file.vo.FileVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public void save(String empId, String rootId, MultipartFile multi) throws Exception {
        save(empId, rootId,null, multi);
    }

    @Override
    public void save(String empId, String rootId, String groupId, MultipartFile multipartFile) throws Exception {
        String fileName = UUID.randomUUID().toString();
        File f = new File(fileName);
        String orgFileName = multipartFile.getOriginalFilename();
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
                    .orgFileName(orgFileName)
                    .ext(ext)
                    .fileSize(multipartFile.getSize())
                    .filePath(f.getPath())
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
        FileVo f = FileVo
            .builder()
            .groupId(groupId)
            .empId(empId)
            .rootDirId(rootId)
            .name(name) // 스토리지 저장 시 파일 구분용
            .orgFileName(name)
            .ext(null)
            .fileSize(0)
            .filePath(null)
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
    public void rename(String dirId, String newName) throws Exception {
        fileRepository.updateName(dirId, newName);
    }

    @Override
    public List<FileVo> getFileList(int empId) throws Exception {
        return fileRepository.selectFileList(empId);
    }

}
