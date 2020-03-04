package com.cts.project.userservice;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(classes=UserServiceApplicationTests.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
	
	@LocalServerPort
	private int port;
	HttpHeaders headers=new HttpHeaders();

}
