package com.topcit.aims.aims;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootTest
class AimsApplicationTests {


    @Test
	void contextLoads() {
    }
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "mypass123";
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Raw: " + rawPassword);
        System.out.println("encodedPassword: " + encodedPassword);
    }
}
