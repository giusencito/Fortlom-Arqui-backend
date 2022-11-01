package com.example.support;
import com.example.support.interfaces.dto.Follow.FollowResource;
import com.example.support.interfaces.dto.Rate.CreateRateResource;
import com.example.support.interfaces.dto.Rate.RateResource;
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
public class supportArtistSteps {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8085";
    private CreateRateResource createRateResource= new CreateRateResource();

    @Given("that the user is in the Artists section")
    public void that_the_user_is_in_the_artists_section() {
       url=url+"/api/v1/supportservice/update/";
    }
    @When("he clicks on the follow button.")
    public void he_clicks_on_the_follow_button() {
       url=url+"1/follow/true";
    }
    @Then("he will be following the artist.")
    public void he_will_be_following_the_artist() {
      restTemplate.put(url, FollowResource.class);
    }
    @When("he selects a number in the bar")
    public void he_selects_a_number_in_the_bar() {
             url=url+"1";
             createRateResource.setReview(3.0F);
    }

    @Then("a message will appear that the artist has been rated.")
    public void a_message_will_appear_that_the_artist_has_been_rated() {
        restTemplate.put(url,createRateResource, RateResource.class);
    }
    @Given("that the user is in the Configure section")
    public void that_the_user_is_in_the_configure_section() {
        url=url+"/api/v1/supportservice/update/";

    }
    @When("he clicks on the Add button")
    public void he_clicks_on_the_add_button() {
        url=url+"1/follow/false";
    }
    @Then("he will define his art tastes by a specific tag.")
    public void he_will_define_his_art_tastes_by_a_specific_tag() {
        restTemplate.put(url, FollowResource.class);
    }













}
