package kr.ac.inha.wgcloud.file.service;

import kr.ac.inha.wgcloud.file.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private FileRepository fileRepository;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    @Override
    public String save(String rootId, MultipartFile file) throws Exception {
        String fileName = UUID.randomUUID().toString();
        return fileName;
    }

}
