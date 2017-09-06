package me.nolza.service.Impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import me.nolza.service.custom.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by Manki Kim on 2017-08-25.
 */
@Service
public class DefaultS3Service implements S3Service {

    @Autowired
    private AmazonS3 amazonS3;

    @Value("${aws.bucket}")
    private String bucket;

    private static final String ROOT = "https://s3.ap-northeast-2.amazonaws.com/nexters-nolza/";

    @Override
    public void createFolder(String root,String folderName) {
        // 메타 폴더 생성
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(0);

        // 데이터가 없는 빈 객체 생성
        InputStream emptyContent = new ByteArrayInputStream(new byte[0]);

        // 빈 폴더 생성 /
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucket+"/"+root,
                folderName+"/", emptyContent, metadata)
                .withCannedAcl(CannedAccessControlList.PublicRead);
        // send Request
        this.amazonS3.putObject(putObjectRequest);
    }

    @Override
    public void createObject(MultipartFile multipartFile, String folderName) {
        ObjectMetadata om = new ObjectMetadata();
        om.setContentEncoding("UTF-8");
        om.setContentLength(multipartFile.getSize());
        om.setContentType(multipartFile.getContentType());
        StringBuilder sb = new StringBuilder();
        sb.append(folderName + "/").append(multipartFile.getOriginalFilename());
        try {
            this.amazonS3.putObject(new PutObjectRequest(bucket,sb.toString(),
                    multipartFile.getInputStream(),om).withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

//    @Override
//    public void createObjects(String location, MultipartFile[] files) {
//        Arrays.stream(files).forEach(file -> {
//            createObject(file);
//        });
//    }

    //TODO Object 없을 시 error처리
    @Override
    public String findObject(String folderName, String fileName) {
        S3Object s3 = this.amazonS3.getObject(bucket, folderName + "/" + fileName);
        return ROOT + s3.getKey();
    }

    @Override
    public void deleteObject(String key) {
        this.amazonS3.deleteObject(new DeleteObjectRequest(bucket, key));
    }

    @Override
    public void deleteFolder(String folderName) {
        StringBuilder sb = new StringBuilder();
        sb.append("mission/").append(folderName).append("/");
        if (this.amazonS3.doesBucketExist(bucket)) {
            ObjectListing objects = this.amazonS3.listObjects(bucket,sb.toString());
            for (S3ObjectSummary objectSummary : objects.getObjectSummaries()) {
                this.amazonS3.deleteObject(bucket, objectSummary.getKey());
            }
        }
    }


    private File multipartToFile(MultipartFile multipart) {
        File convFile = new File(multipart.getOriginalFilename());
        try {
            multipart.transferTo(convFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }

    private void objectToPublic(String keyName) {
        StringBuilder sb = new StringBuilder();
        sb.append("mission/").append(keyName).append("/");
        this.amazonS3.setObjectAcl(bucket,sb.toString(),CannedAccessControlList.AuthenticatedRead);
    }
}
