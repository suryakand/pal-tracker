package test.pivotal.pal.tracker;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.Test;

import io.pivotal.pal.tracker.EnvController;

public class EnvControllerTest {
    @Test
    public void getEnv() throws Exception {
        EnvController controller = new EnvController( "8675", "12G", "34", "123.sesame.street");

        Map<String, String> env = controller.getEnv();

        assertThat(env.get("PORT")).isEqualTo("8675");
        assertThat(env.get("MEMORY_LIMIT")).isEqualTo("12G");
        assertThat(env.get("CF_INSTANCE_INDEX")).isEqualTo("34");
        assertThat(env.get("CF_INSTANCE_ADDR")).isEqualTo("123.sesame.street");
    }

}
