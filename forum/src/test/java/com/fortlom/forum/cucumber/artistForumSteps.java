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
public class artistForumSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private CreateForumResource createForumResource= new CreateForumResource();
    private String url = "http://localhost:8083";
    String password=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String Username=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    boolean setr;
    @Given("that the artist is in the {string} section")
    public void that_the_artist_is_in_the_section(String string) {url=url+"/api/v1/forumservice/";}
    @Given("click on the “+” button")
    public void click_on_the_button() {url=url+"user/";}
    @When("correctly fill in the data")
    public void correctly_fill_in_the_data() {
        createForumResource.setForumname(Username);
        createForumResource.setForumdescription(password);
    }
    @When("click on “Create”")
    public void click_on_create() {url=url+"1/forums";}
    @Then("message of your forum created successfully will appear.")
    public void message_of_your_forum_created_successfully_will_appear() {
      restTemplate.postForObject(url,createForumResource, ForumResource.class);
    }
    @When("fill in the details")
    public void fill_in_the_details() {
        createForumResource.setForumname(Username);
        createForumResource.setForumdescription(password);
    }
    @When("the forum name is used")
    public void the_forum_name_is_used() {}
    @Then("message will not appear from your created forum.")
    public void message_will_not_appear_from_your_created_forum() {
        restTemplate.postForObject(url,createForumResource, ForumResource.class);}

    @When("you have successfully created a forum")
    public void you_have_successfully_created_a_forum() {
        setr= restTemplate.getForObject("http://localhost:8083/api/v1/forumservice/check/1",boolean.class);}

    @Then("your forum will appear in the list.")
    public void your_forum_will_appear_in_the_list() {assertEquals(setr,true);}

}
