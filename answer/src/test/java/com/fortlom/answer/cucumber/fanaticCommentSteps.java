package com.fortlom.answer.cucumber;

import com.fortlom.answer.interfaces.dto.ForumComment.CreateForumCommentResource;
import com.fortlom.answer.interfaces.dto.ForumComment.ForumCommentResource;
import com.fortlom.answer.interfaces.dto.PublicationComment.CreatePublicationCommentResource;
import com.fortlom.answer.interfaces.dto.PublicationComment.PublicationCommentResource;
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
public class fanaticCommentSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private CreateForumCommentResource createForumCommentResource= new CreateForumCommentResource();
    private CreatePublicationCommentResource createPublicationCommentResource= new CreatePublicationCommentResource();
    private String url = "http://localhost:8084";
    @Given("that the fan is in the Publication section.")
    public void that_the_fan_is_in_the_publication_section() {
        url=url+"/api/v1/answerservice";
    }
    @Given("click on the see Posts button")
    public void click_on_the_see_posts_button() {
        url=url+"/user/1/publications/";
    }

    @When("he chooses a publication of his choice")
    public void he_chooses_a_publication_of_his_choice() {
        url=url+"2";
    }

    @When("type what he wants")
    public void type_what_he_wants() {
        createPublicationCommentResource.setCommentdescription("newest");
    }

    @When("click on the Post Comment button")
    public void click_on_the_post_comment_button() {
        url=url+"/publicationcomments";
    }
    @Then("your fanatic comment will be created successfully")
    public void your_fanatic_comment_will_be_created_successfully() {
        restTemplate.postForObject(url,createPublicationCommentResource, PublicationCommentResource.class);
    }
    @Given("that the fan is in the section Fanatic Forum")
    public void that_the_fan_is_in_the_section_fanatic_forum() {
        url=url+"/api/v1/answerservice";
    }
    @Given("choose the forum of your choice")
    public void choose_the_forum_of_your_choice() {
        url=url+"/user/1/forums/";
    }
    @When("write what he wants in the chosen forum")
    public void write_what_he_wants_in_the_chosen_forum() {
        createForumCommentResource.setCommentdescription("newest");
    }
    @When("click on the OK button")
    public void click_on_the_ok_button() {
        url=url+"1";
    }
    @Then("a message will be displayed that the comment was successfully created.")
    public void a_message_will_be_displayed_that_the_comment_was_successfully_created() {
        url=url+"/forumcomments";
        restTemplate.postForObject(url,createForumCommentResource, ForumCommentResource.class);
    }
    @When("he chooses a publication")
    public void he_chooses_a_publication() {
        url= "http://localhost:8084/api/v1/answerservice/publicationcomments";
    }
    @When("click on the See button")
    public void click_on_the_see_button() {
        url= "http://localhost:8084/api/v1/answerservice/publicationcomments";
    }
    @Then("it will be possible to see the comments of the publication.")
    public void it_will_be_possible_to_see_the_comments_of_the_publication() {
        url= "http://localhost:8084/api/v1/answerservice/publicationcomments";
    }



}
