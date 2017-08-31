package me.nolza.service;

import lombok.extern.slf4j.Slf4j;
import me.nolza.service.custom.S3Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Manki Kim on 2017-08-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class S3ServiceTest {

    @Autowired
    private S3Service s3Service;

    @Test
    public void createObjectTest() {
        /*
        File file = new File("C:\\Users\\USER\\Pictures\\fb.png");
        s3Service.createObject(file);
        assertThat(s3Service.findObject("fb.png"), is(notNullValue()));
        */
    }
}
