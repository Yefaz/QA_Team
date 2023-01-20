package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cases extends ApiTestCase {
    String postdata = "{\n" +
            "    \"firstName\": \"asdasdaa\",\n" +
            "    \"lastName\": \"asfeaa\",\n" +
            "    \"username\": \"aeffffkkgaasea.user3\",\n" +
            "    \"email\": \"eafg44ffkkaava.user3@witwiser.io\"\n" +
            "}";

    @Given("Connect the post url")
    public void connect_the_post_url() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata);

    }

    @And("Get the post")
    public void get_the_post() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata).
                when().post("https://testing-app.witwiser.io/api/v1/users").then().statusCode(200);

        //topMethod();
    }

    @Given("Connedsfct the post url")
    public void connedsfct_the_post_url() {
        Assert.assertEquals(1, 1);
        System.out.println("sdşajhglasjgdhpafdsng ouh asdhpg hads fgl hapsdlkfg");// Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("Get thesdf post")
    public void get_thesdf_post() {
        System.out.println("sdşajhglasjgdhpafdsng ouh asdhpg hads fgl hapsdlkfg");// Write code here that turns the phrase above into concrete actions

        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
