package milesahead.micro.service2;

import io.cucumber.junit.platform.engine.Cucumber;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = Service2Application.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

@Cucumber
public class CucumberService2Test {

}
