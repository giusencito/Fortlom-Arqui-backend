package com.fortlom.content.cucumber;
import com.fortlom.content.interfaces.dto.publication.CreatePublicationResource;
import com.fortlom.content.interfaces.dto.publication.PublicationResource;
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
public class artistPublicationSteps {
    private RestTemplate restTemplate = new RestTemplate();
    String email=UUID.randomUUID().toString().replace("-", "").substring(0,20)+"@gmail.com";
    String password=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String Username=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String name=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    String lastname=UUID.randomUUID().toString().replace("-", "").substring(0,20);
    CreatePublicationResource createPublicationResource= new CreatePublicationResource();
    //http://localhost:8082/api/v1/contentservice/artists/{{artistId}}/type/{{type}}/publications
    private String url = "http://localhost:8082";

    @Given("that the user is on your main page")
    public void that_the_user_is_on_your_main_page() {
        url=url+"/api/v1/contentservice/";
    }
    @When("you click on the “Publications” section")
    public void you_click_on_the_publications_section() {
       url=url+"artists/";
    }
    @When("fill everything correctly")
    public void fill_everything_correctly() {
      createPublicationResource.setDescription("description");
    }
    @When("click the {string} button")
    public void click_the_button(String string) {
        url=url+"1/type/false/publications";
    }
    @Then("the publication will be successfully created.")
    public void the_publication_will_be_successfully_created() {
       restTemplate.postForObject(url,createPublicationResource, PublicationResource.class);
    }
    @When("do not fill out the entire form")
    public void do_not_fill_out_the_entire_form() {
        createPublicationResource.setDescription("description");
    }

    @Then("the post will not be created.")
    public void the_post_will_not_be_created() {
        restTemplate.postForObject(url,createPublicationResource, PublicationResource.class);
    }


}
