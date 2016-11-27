package com.techelevator.cukes;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Component
public class ExampleSteps {

	private WebDriver webDriver;

	@Autowired
	public ExampleSteps(WebDriver webDriver) {
		this.webDriver = webDriver;
	}
	
	@Given("^I am a student$")
	public void i_am_a_student() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I need an example$")
	public void i_need_an_example() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I use this file$")
	public void i_use_this_file() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
