package com.suranku;

import com.suranku.users.dao.StandardResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurankuApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void pingTest() {
		String requestUri = "/api/ping";
		ResponseEntity<StandardResponse> response = restTemplate.getForEntity(requestUri, StandardResponse.class);
		Assert.assertNotNull(response);
		Assert.assertEquals(200, response.getStatusCodeValue());
		Assert.assertEquals(requestUri, response.getBody().getUri());
		Assert.assertEquals("Ping received successfully.", response.getBody().getMessage());
		Assert.assertNotNull(response.getBody().getTimestamp());
	}

}
