package com.fortlom.forum.cucumber;
import com.fortlom.forum.interfaces.dto.Forum.CreateForumResource;
import com.fortlom.forum.interfaces.dto.Forum.ForumResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.Page;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class fanaticForumSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private CreateForumResource createForumResource= new CreateForumResource();
    private String url = "http://localhost:8083";
    String password=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String Username=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    boolean setr;

    @Given("that the fan is in the {string} section")
    public void that_the_fan_is_in_the_section(String string) {
        url=url+"/api/v1/forumservice/";
    }
    @Given("click on the “+” fanatic button")
    public void click_on_the_fanatic_button() {
        url=url+"user/";
    }
    @When("correctly fill in the fanatic data")
    public void correctly_fill_in_the_fanatic_data() {
        createForumResource.setForumname(Username);
        createForumResource.setForumdescription(password);
    }
    @When("click on “Create” fanatic")
    public void click_on_create_fanatic() {
        url=url+"1/forums";
    }
    @Then("message will appear your forum created successfully")
    public void message_will_appear_your_forum_created_successfully() {
        restTemplate.postForObject(url,createForumResource, ForumResource.class);

    }
    @When("fill in the fanatic details")
    public void fill_in_the_fanatic_details() {
        createForumResource.setForumname(Username);
        createForumResource.setForumdescription(password);
    }
    @When("the fanatic forum name is used")
    public void the_fanatic_forum_name_is_used() {
        url=url+"1/forums";
    }

    @Then("message will not appear from your created fanatic forum.")
    public void message_will_not_appear_from_your_created_fanatic_forum() {
        restTemplate.postForObject(url,createForumResource, ForumResource.class);
    }

    @When("you have successfully created a fanatic forum")
    public void you_have_successfully_created_a_fanatic_forum() {
        setr= restTemplate.getForObject("http://localhost:8083/api/v1/forumservice/check/1",boolean.class);

    }

    @Then("your forum will appear in the list")
    public void your_forum_will_appear_in_the_list() {
        assertEquals(setr,true);

    }










}
