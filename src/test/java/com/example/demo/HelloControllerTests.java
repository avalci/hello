package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloControllerTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Value("application-version")
	private String version;

	@Test
	void test() {
		ResponseEntity<String> entity = restTemplate.exchange("http://localhost:" + port, HttpMethod.GET, null,
				String.class);

		assertAll(() -> assertEquals(HttpStatus.OK, entity.getStatusCode()),
				() -> assertEquals("Hello - " + version, entity.getBody()));
	}

}
