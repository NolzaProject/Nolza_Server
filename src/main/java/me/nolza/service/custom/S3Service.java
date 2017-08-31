package me.nolza.service.custom;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by Manki Kim on 2017-08-25.
 */
public interface S3Service {
    public void createFolder(String root, String folderName);
    public String findObject(String fileName);
    public void deleteFolder(String folderName);
    public void createObject(MultipartFile multipartFile);
    public void createObjects(String location, MultipartFile[] files);
    public void deleteObject(String key);
}
