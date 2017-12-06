package test.pivotal.pal.trackerapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import io.pivotal.pal.tracker.PalTrackerApplication;
import test.pivotal.pal.util.PalTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public class WelcomeApiTest {

	@LocalServerPort
	private String port;
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		restTemplate = PalTestUtils.getTestRestTemplate(port);
	}

	@Test
	public void exampleTest() {
		String body = this.restTemplate.getForObject("/", String.class);
		assertThat(body).isEqualTo("Hello from test");
	}
}
