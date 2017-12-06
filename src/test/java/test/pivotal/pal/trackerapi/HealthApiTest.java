package test.pivotal.pal.trackerapi;

import static com.jayway.jsonpath.JsonPath.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.jayway.jsonpath.DocumentContext;

import io.pivotal.pal.tracker.PalTrackerApplication;
import test.pivotal.pal.util.PalTestUtils;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PalTrackerApplication.class, webEnvironment = RANDOM_PORT)
public class HealthApiTest {

	@LocalServerPort
	private String port;
	private TestRestTemplate restTemplate;

	@Before
	public void setUp() throws Exception {
		restTemplate = PalTestUtils.getTestRestTemplate(port);
	}

    @Test
    public void healthTest() {
        ResponseEntity<String> response = this.restTemplate.getForEntity("/health", String.class);


        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext healthJson = parse(response.getBody());

        assertThat(healthJson.read("$.status", String.class)).isEqualTo("UP");
        assertThat(healthJson.read("$.db.status", String.class)).isEqualTo("UP");
        assertThat(healthJson.read("$.diskSpace.status", String.class)).isEqualTo("UP");
    }
}
