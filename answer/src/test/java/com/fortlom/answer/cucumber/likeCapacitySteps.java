package com.fortlom.answer.cucumber;
import com.fortlom.answer.interfaces.dto.ForumComment.CreateForumCommentResource;
import com.fortlom.answer.interfaces.dto.Opinion.OpinionResource;
import com.fortlom.answer.interfaces.dto.PublicationComment.CreatePublicationCommentResource;
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
public class likeCapacitySteps {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8084/api/v1/answerservice";

    @Given("that the user is in the Publication section")
    public void that_the_user_is_in_the_publication_section() {
        url=url+"/update";
    }
    @Given("he clicks on the See Posts button")
    public void he_clicks_on_the_see_posts_button() {
           url=url+"/";
    }
    @When("he sees a post he likes")
    public void he_sees_a_post_he_likes() {
       url=url+"2/";
    }
    @When("click on the Like button")
    public void click_on_the_like_button() {
      url=url+"agree/true";
    }
    @Then("he will already be indicating that he likes that post.")
    public void he_will_already_be_indicating_that_he_likes_that_post() {
        System.out.println(url);
        //http://localhost:8084/api/v1/answerservice/update/2/agree/true
       restTemplate.put(url, OpinionResource.class);
    }
    @Given("clicks on the See Posts button")
    public void clicks_on_the_see_posts_button() {
        url=url+"/";
    }

    @When("he sees a post that is not to his liking")
    public void he_sees_a_post_that_is_not_to_his_liking() {
        url=url+"2/";
    }

    @When("click on the Dislike button")
    public void click_on_the_dislike_button() {
        url=url+"agree/false";
    }

    @Then("you are already indicating that you do not like that post.")
    public void you_are_already_indicating_that_you_do_not_like_that_post() {
        restTemplate.put(url, OpinionResource.class);
    }
    @Given("that the user is in the Event section")
    public void that_the_user_is_in_the_event_section() {
        url=url+"/update";
    }
    @Given("he clicks on the Show All Events button")
    public void he_clicks_on_the_show_all_events_button() {
        url=url+"/";
    }
    @When("he sees an event he likes")
    public void he_sees_an_event_he_likes() {
        url=url+"2/";
    }
    @When("click on the thumbs up button")
    public void click_on_the_thumbs_up_button() {
        url=url+"agree/true";
    }
    @Then("he will already be indicating that he likes that event.")
    public void he_will_already_be_indicating_that_he_likes_that_event() {

        restTemplate.put(url, OpinionResource.class);
    }
    @Given("clicks on the Show All Events button")
    public void clicks_on_the_show_all_events_button() {
        url=url+"/";
    }

    @When("he sees an event that he does not like.")
    public void he_sees_an_event_that_he_does_not_like() {
        url=url+"2/";
    }

    @When("click on the Thumbs Down button.")
    public void click_on_the_thumbs_down_button() {
        url=url+"agree/false";
    }

    @Then("you will already be indicating that you do not like that event.")
    public void you_will_already_be_indicating_that_you_do_not_like_that_event() {
        restTemplate.put(url, OpinionResource.class);
    }

}
