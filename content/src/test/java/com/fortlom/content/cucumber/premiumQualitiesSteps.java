package com.fortlom.content.cucumber;
import com.fortlom.content.domain.ContentAgrregate.entity.Event;
import com.fortlom.content.interfaces.dto.event.CreateEventResource;
import com.fortlom.content.interfaces.dto.event.EventResource;
import com.fortlom.content.interfaces.dto.publication.CreatePublicationResource;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
import lombok.extern.log4j.Log4j2;
import org.junit.runner.RunWith;
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
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class premiumQualitiesSteps {
    private RestTemplate restTemplate = new RestTemplate();

    CreateEventResource eventResource= new CreateEventResource();
    String name=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    //http://localhost:8082/api/v1/contentservice/artist/{{artistId}}/events
    private String url = "http://localhost:8082";
    @Given("that the artist is in the {string} section,")
    public void that_the_artist_is_in_the_section(String string) {
        url=url+"/api/v1/contentservice/";
    }
    @When("you click on “Post Event”")
    public void you_click_on_post_event() {
        url=url+"artist/";
    }
    @When("fill in the data correctly")
    public void fill_in_the_data_correctly() {
        eventResource.setDescription("descript");
        eventResource.setName(name);
        Date date = new Date();
        eventResource.setReleasedDate(date);
        eventResource.setTicketLink("https://www.facebook.com/");
    }
    @When("click on “Create and Post”")
    public void click_on_create_and_post() {
       url=url+"1/events";
    }
    @Then("an event will be successfully created.")
    public void an_event_will_be_successfully_created() {
        restTemplate.postForObject(url,eventResource, EventResource.class);
    }
    @When("do not fill in the form data")
    public void do_not_fill_in_the_form_data() {
        eventResource.setDescription("descript");
        eventResource.setName(name);
        Date date = new Date();
        eventResource.setReleasedDate(date);
        eventResource.setTicketLink("https://www.facebook.com/");
    }

    @Then("event will not be created")
    public void event_will_not_be_created() {
        restTemplate.postForObject(url,eventResource, EventResource.class);
    }
}
