package milesahead.micro.service1;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import milesahead.api.service1.Service1;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Service1Stepfunctions {

  private Logger log = LoggerFactory.getLogger(this.getClass());

  @Autowired
  private Service1Client service1Client;

  private Service1 service1;

  @Before
  public void setup() {
    log.info("Before service1 test execution");
  }

  @When("I request service1 information")
  public void i_request_service1_information() throws Exception {
    log.info("Running: I request service1" + new Date());
    this.service1 = service1Client.getContents();
  }

  @Then("I validate service1 information")
  public void i_validate_service1_information() {
    log.info("Running: I validate service1 data at " + new Date());

    assertAll("service1",
            () -> assertEquals("Hello, Service1!", service1.getContent())
    );
  }

  @After
  public void tearDown() {
    log.info("After service1 test execution");
  }

}
