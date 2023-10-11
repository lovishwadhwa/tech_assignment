package com.lovishwadhwa.assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AssignmentApplicationTests {

	@Autowired
	private TestRestTemplate client;

	@Test
	void contextLoads() {
		var response = client.postForEntity("/execute/1",null, void.class);

		assertEquals(response.getStatusCode(), HttpStatus.OK);

	}

}
