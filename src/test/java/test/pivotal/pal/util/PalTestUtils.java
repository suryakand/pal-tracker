package test.pivotal.pal.util;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;

public class PalTestUtils {

	public static TestRestTemplate getTestRestTemplate(String port) {
		RestTemplateBuilder builder = new RestTemplateBuilder()
				.rootUri("http://localhost:" + port)
				.basicAuthorization("user", "password");

		return new TestRestTemplate(builder);		
	}
}
