package com.fortlom.answer.cucumber;
import com.fortlom.answer.interfaces.dto.ForumComment.CreateForumCommentResource;
import com.fortlom.answer.interfaces.dto.ForumComment.ForumCommentResource;
import com.fortlom.answer.interfaces.dto.PublicationComment.PublicationCommentResource;
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

public class artistCommentSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private CreateForumCommentResource createForumCommentResource= new CreateForumCommentResource();
    private CreatePublicationCommentResource createPublicationCommentResource= new CreatePublicationCommentResource();
    private String url = "";
    @Given("that the artist is in the Posts section")
    public void that_the_artist_is_in_the_posts_section() {
       url=url+"http://localhost:8084/api/v1/answerservice";


    }
    @Given("hit the see Posts button")
    public void hit_the_see_posts_button() {

        url=url+"/user/1/publications/";

    }
    @When("choose a publication")
    public void choose_a_publication() {
       url=url+"2";
    }
    @When("write what you want")
    public void write_what_you_want() {
       createPublicationCommentResource.setCommentdescription("newest");
    }
    @When("hit the Post Comment button")
    public void hit_the_post_comment_button() {
        url=url+"/publicationcomments";
    }
    @Then("your comment will be created successfully")
    public void your_comment_will_be_created_successfully() {

       restTemplate.postForObject(url,createPublicationCommentResource,PublicationCommentResource.class);
    }
    @Given("that the artist is in the Forum section")
    public void that_the_artist_is_in_the_forum_section() {
        url=url+"http://localhost:8084/api/v1/answerservice";
    }
    @Given("choose a forum of your liking")
    public void choose_a_forum_of_your_liking() {
        url=url+"/user/1/forums/";
    }
    @When("write what you want in the chosen forum")
    public void write_what_you_want_in_the_chosen_forum() {
       createForumCommentResource.setCommentdescription("newest");
    }
    @When("hit the OK button")
    public void hit_the_ok_button() {
        url=url+"1";
    }
    @Then("will output a message that the comment was successfully created.")
    public void will_output_a_message_that_the_comment_was_successfully_created() {
        url=url+"/forumcomments";
        restTemplate.postForObject(url,createForumCommentResource,ForumCommentResource.class);
    }
    @When("hit the See button")
    public void hit_the_see_button() {
       url= "http://localhost:8084/api/v1/answerservice/publicationcomments";
    }

    @Then("you can view the comments of the publication")
    public void you_can_view_the_comments_of_the_publication() {
        url= "http://localhost:8084/api/v1/answerservice/publicationcomments";
    }
}
