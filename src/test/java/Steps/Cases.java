package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Cases {
    String postdata = "{\n" +
            "    \"firstName\": \"asdasdaa\",\n" +
            "    \"lastName\": \"asfeaa\",\n" +
            "    \"username\": \"aeffffkkgaasea.user3\",\n" +
            "    \"email\": \"eafg44ffkkaava.user3@witwiser.io\"\n" +
            "}";

    @Given("user is created")
    public void connect_the_post_url() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata).
        when().post("https://testing-app.witwiser.io/api/v1/users").then().statusCode(200);

    }

    @Given("Failed creat")
    public void failed_creat() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata).
                when().post("https://testing-app.witwiser.io/api/v1/users").
                then().statusCode(500).body("errorMessage",Matchers.equalTo("Username and E-mail are already used."));
    }

    @Given("listing of users")
    public void listing_of_users() {
        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .when()
                .get("https://testing-app.witwiser.io/api/v1/users/1ed95a53-86b4-5f69-ddf9-01f2d048822b")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Given("session assignment")
    public void session_assignment() {
        String postdata = "{\r\n    \"candidates\": [\r\n        \"id:1ed876d4-a065-f779-d201-0300980c71a6\"\r\n    ]," +
                "\r\n    \"interviewer\": null," +
                "\r\n    \"periodStartDate\": \"2023-01-17T12:00:00Z\"," +
                "\r\n    \"periodEndDate\": \"2023-01-22T22:00:00Z\"," +
                "\r\n    \"interviewStartDate\": null," +
                "\r\n    \"examType\": \"TEST\"," +
                "\r\n    \"sessionTemplateId\": \"1ed8b70a-fb1b-35d9-d204-090228958efe\"," +
                "\r\n    \"informCandidate\": false,\r\n    \"assignmentType\": \"USER\"," +
                "\r\n    \"groupId\": null\r\n}";


        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata)
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


        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata)
                .when()
                .post("https://testing-app.witwiser.io/api/v1/sessions")
                .then().statusCode(404).body("errorMessage",Matchers.equalTo("error.sessionTemplate.notFound"));

    }

}
