package milesahead.micro.service2;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Service2Stepfunctions {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Service2Client service2Client;

  private Service2 service2;

  @Before
  public void setup() {
    log.info("Before service2 test execution");
  }

  @When("I request service2 information")
  public void i_request_service2_information() throws Exception {
    log.info("Running: I request service2" + new Date());
    this.service2 = service2Client.getContents();
  }

  @Then("I validate service2 information")
  public void i_validate_service2_information() {
    log.info("Running: I validate service2 data at " + new Date());

    assertAll("service2",
            () -> assertEquals("Hello, Service2!", service2.getContent())
    );
  }

  @After
  public void tearDown() {
    log.info("After service2 test execution");
  }

}
