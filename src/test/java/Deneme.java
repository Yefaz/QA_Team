import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import model.Result;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;


import static io.restassured.RestAssured.*;

public class Deneme extends APITestCase {

    public static final String BASE_URL = "https://testing-app.witwiser.io";
    @Test
    public void Deneme() {

        /*given()
                .when()
                .get("http://usersdemo.herokuapp.com/api/users?page=2")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .assertThat().body("total_pages",equalTo(4))
                .assertThat().body("per_page",equalTo(3))
                .log().all();

    }*/
        baseURI = "https://dummy.restapiexample.com/api/v1/employees";
        RequestSpecification httpRequest = given();
        Response response = httpRequest.get("");


        JsonPath jsonPathEvaluator = response.jsonPath();

        List<Integer> alljson = jsonPathEvaluator.getList("data");
        System.out.println(alljson);
        for (int i = 0; i < alljson.size(); i++) {
            System.out.println(alljson.get(i));
        }
    }

    @Test
    public void Creat() {
        String random =  UUID.randomUUID().toString();

        String postdata = "{\n" +
                "    \"firstName\": \"asdasdaa\",\n" +
                "    \"lastName\": \"asfeaa\",\n" +
                "    \"username\": \""+ random +"\",\n"+
                "    \"email\": \""+random+"@witwiser.io\"\n" +
                "}";

        given().header("secret_key",SECRET_KEY)
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
                .body(postdata)
                .when()
                .post(BASE_URL+"/api/v1/users")
                .then().statusCode(200)
        ;

    }

    @Test
    public void Getall() {

        given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .when()
                .get("https://testing-app.witwiser.io/api/v1/users/1ed95a53-86b4-5f69-ddf9-01f2d048822b")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test

    public void Creat_Session() {
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

    @Test

    public void Control_Session() throws JsonProcessingException {
        String postdata = "{\r\n    \"testTakerEmail\": \"Test3@test.com\"\r\n}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String postdatasf = given().header("secret_key", "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo")
                .header("Content-Type", "application/json")
                .header("host", "testing-app.witwiser.io")
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

        System.out.println(users.getSessions().size());


    }

}