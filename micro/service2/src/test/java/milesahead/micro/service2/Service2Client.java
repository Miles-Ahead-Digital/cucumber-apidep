package milesahead.micro.service2;

import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class Service2Client {

    private final String SERVER_URL = "http://localhost";
    private final String THINGS_ENDPOINT = "/service2";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();


    private String thingsEndpoint() {
        return SERVER_URL + ":" + port + THINGS_ENDPOINT;
    }

    public Service2 getContents() {
        return restTemplate.getForEntity(thingsEndpoint(), Service2.class).getBody();
    }

}
