package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController ()
 */
@RestController
public class HelloController {

	@Value("${application-version}")
	private String version;

	@GetMapping
	public ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello - " + version, HttpStatus.OK);
	}
}
