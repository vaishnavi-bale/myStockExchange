package com.cts.project.userservice;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
@SpringBootTest(classes=UserServiceApplication.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class UserControllerIntegrationTest {

	@LocalServerPort
	private int port;
	HttpHeaders headers=new HttpHeaders();
	TestRestTemplate restTemplate=new TestRestTemplate();
	
	@Test
	public void test() throws Exception{
		String url="http://localhost:"+port+"/user";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null, headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String expected="{\"id\":70,\"fullName\":\"B vaishnavi\",\"email\":\"vaishnavi@gmail.com\"";
		System.out.println("Test::Response body:::: "+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
	@Test
	public void test1() throws Exception{
		String url="http://localhost:"+port+"/user/70";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity=new HttpEntity<String>(null, headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		String expected="{\"id\":70,\"fullName\":\"B vaishnavi\",\"email\":\"vaishnavi@gmail.com\"";
		System.out.println("Test::Response body:::: "+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
	@Test
	public void testAdd() throws Exception{
		String url="http://localhost:"+port+"/user";
		System.out.println("Port::"+url);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		User user=new User(25, "Syed", "syed@gmail.com", 42534354, "syed", "syed", null);
		HttpEntity<User> entity=new HttpEntity<User>(user, headers);
		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
		String expected="{\"id\":25,\"fullName\":\"Syed\",\"email\":\"syed@gmail.com\"";
		System.out.println("Test::Response body:::: "+response.getBody());
		assertTrue(response.getBody().contains(expected));
	}
//	@Test
//	public void testDelete() throws Exception{
//		String url="http://localhost:"+port+"/user/139";
//		System.out.println("Port::"+url);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//		HttpEntity<String> entity=new HttpEntity<String>(null, headers);
//		ResponseEntity<String> response=restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
//		String expected="{\"id\":139,\"fullName\":\"Syed\",\"email\":\"syed@gmail.com\"";
//		System.out.println("Test::Response body:::: "+response.getBody());
//		assertTrue(response.getBody().contains(expected));
//	}s

}
