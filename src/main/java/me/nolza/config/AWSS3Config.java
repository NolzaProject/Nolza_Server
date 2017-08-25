package me.nolza.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Manki Kim on 2017-08-025
 * email : aj1155@naver.com
 */
@Configuration
public class AWSS3Config {

    @Value("${iam.ak}")
    private String ak;

    @Value("${iam.sk}")
    private String sk;

    @Bean
    public AmazonS3 amazonS3(BasicAWSCredentials awsCreds) {
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.AP_NORTHEAST_2)
                .build();
        return s3Client;
    }

    @Bean
    public BasicAWSCredentials awsCreds() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials(ak, sk);
        return awsCreds;
    }
}
