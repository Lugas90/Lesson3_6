package com.example.lesson3_6;

import com.example.lesson3_6.controller.StudentController;
import com.example.lesson3_6.model.Student;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private StudentController studentController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads () throws Exception {
        Assertions.assertThat(studentController).isNotNull();
    }

    @Test
    void testAddStudent () throws Exception{
        Student student = new Student();
        student.setId(1L);
        student.setAge(20);
        student.setName("Vacok");
        Assertions
                .assertThat(this.restTemplate.postForObject
                        ("http://localhost:" + port + "/student", student, String.class))
                .isNotNull();
    }

    @Test
    void testGetStudent () throws Exception {
        Assertions
                .assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/student", String.class))
                .isNotNull();
    }
}
