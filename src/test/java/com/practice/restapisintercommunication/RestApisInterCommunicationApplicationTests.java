package com.practice.restapisintercommunication;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
//@AutoConfigureMockMvc
public class RestApisInterCommunicationApplicationTests {

	//@Autowired
	//private MockMvc mockMvc;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;
	HttpHeaders httpHeaders = new HttpHeaders();

	@Before
	@Test
	public void setUp(){
		//System.out.println("MockMvc:::::"+mockMvc);
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void getHome(){
		HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
		ResponseEntity<String> response = testRestTemplate.exchange(createUriWithPort("/all/home/getHome"),
				HttpMethod.GET, entity, String.class);
		System.out.println("response.getHeaders()::::"+response.getHeaders());
		System.out.println("response.getBody():::::::"+response.getBody().toString());
		Assert.assertEquals("Got home safely!!!", response.getBody().toString());
	}

	@Test
	@Sql("/test.sql")
	public void getEmployee() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<String>(null, httpHeaders);
		ResponseEntity<String> response = testRestTemplate.exchange(createUriWithPort("/all/employee/getEmployee/2"),
				HttpMethod.GET, entity, String.class);

		String expected = "{'empId':2, 'empFirstName':'Allen','empLastName':'Williams','salary':4532.86}";
		System.out.println("response.getHeaders()::::"+response.getHeaders());
		System.out.println("expected:::::::::::::::::"+expected);
		System.out.println("response.getBody():::::::"+response.getBody().toString());
		JSONAssert.assertEquals(expected, response.getBody(), false);//JSONCompareMode.LENIENT
		//Assert.assertEquals("Got home safely!!!", response.getBody().toString());
	}

	private String createUriWithPort(String uri) {
		return "http://localhost:"+port+uri;
	}


}
