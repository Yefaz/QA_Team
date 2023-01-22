package Steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import model.Result;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class Cases extends APITestCase
{
    String random =  UUID.randomUUID().toString();


    @Given("user is created")
    public void connect_the_post_url() {
        given().header("secret_key",SECRET_KEY)
                .header("Content-Type", CONTENT_TYPE)
                .header("host", HOST)
                .body(POST_DATA)
                .when()
                .post(POST_URL)
                .then().statusCode(200);

    }

    @Given("Failed creat")
    public void failed_creat() {
        given().header("secret_key",SECRET_KEY)
                .header("Content-Type", CONTENT_TYPE)
                .header("host", HOST)
                .body(STATİC_DATA).
                when().post(POST_URL).
                then().statusCode(500).body("errorMessage",Matchers.equalTo("Username and E-mail are already used."));
    }

    @Given("listing of users")
    public void listing_of_users() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .when()
                .get(GET_URL)
                .then()
                .statusCode(200)
                .log().all();
    }
    @Given("session assignment")
    public void session_assignment() {



        given().header("secret_key", SECRET_KEY)
                .header("Content-Type", CONTENT_TYPE)

                .header("host", HOST)
                .body(SECİON_DATA)
                .when()
                .post("https://testing-app.witwiser.io/api/v1/sessions")
                .then().statusCode(200);
    }
    @Given("Failed session")
    public void failed_session() {
        String postdata = "{\r\n    \"candidates\": [\r\n        \"id:1ed876d4-a065-f779-d201-0300980c71a6\"\r\n    ]," +
                "\r\n    \"interviewer\": null," +
                "\r\n    \"periodStartDate\": \"2023-01-17T12:00:00Z\"," +
                "\r\n    \"periodEndDate\": \"2023-01-22T22:00:00Z\"," +
                "\r\n    \"interviewStartDate\": null," +
                "\r\n    \"examType\": \"TEST\"," +
                "\r\n    \"sessionTemplateId\": \"1ed8b70a-fb1b-35d8-d204-090228958efe\"," +
                "\r\n    \"informCandidate\": false,\r\n    \"assignmentType\": \"USER\"," +
                "\r\n    \"groupId\": null\r\n}";


        given().header("secret_key", SECRET_KEY)
                .header("Content-Type", CONTENT_TYPE)
                .header("host", HOST)
                .body(postdata)
                .when()
                .post("https://testing-app.witwiser.io/api/v1/sessions")
                .then().statusCode(404).body("errorMessage",Matchers.equalTo("error.sessionTemplate.notFound"));

    }
    @Given("It is seen that the created session is listed.")
    public void it_is_seen_that_the_created_session_is_listed() throws JsonProcessingException {

            String postdata = "{\r\n    \"testTakerEmail\": \"Test3@test.com\"\r\n}";
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            String postdatasf = given().header("secret_key", SECRET_KEY)
                    .header("Content-Type", CONTENT_TYPE)
                    .header("host", HOST)
                    .body(postdata)
                    .when()
                    .post("https://testing-app.witwiser.io/api/v1/sessions/getTestTakerSessions")
                    .thenReturn().asString();


            Result users = objectMapper.reader()
                    .forType(Result.class).readValue(postdatasf);

            boolean result = users.getSessions().stream().anyMatch(session -> session.getTestTakerEmail().equals("Test3@test.com"));
            if(result){
                System.out.println("session bulundu.");
            } else {
                System.out.println("sesion bulunamadı");
            }
    }
    @Given("Total number of sessions listed")
    public void total_number_of_sessions_listed() {
        String postdata = "{\r\n    \"testTakerEmail\": \"Test3@test.com\"\r\n}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String postdatasf = given().header("secret_key", SECRET_KEY)
                .header("Content-Type", CONTENT_TYPE)
                .header("host", HOST)
                .body(postdata)
                .when()
                .post("https://testing-app.witwiser.io/api/v1/sessions/getTestTakerSessions")
                .thenReturn().asString();


        Result users = null;
        try {
            users = objectMapper.reader()
                    .forType(Result.class).readValue(postdatasf);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


            System.out.println(users.getSessions().size());


    }

}
