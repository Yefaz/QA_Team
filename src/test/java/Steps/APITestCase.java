package Steps;

import java.util.UUID;

public class APITestCase {

    public static final String SECRET_KEY = "3Uvz513R74CHPqS3of8r3wJkzJ3rndfp4T0STnH5bGo4VjQk4e2yx9Y0BrDgF9kEYmeYtW83Cp0zrQy5BMJhVxZEqWxAFlQmgO736ujwMhoH6U36ABL7EArnpzgQTo";
    public static final String POST_URL = "https://testing-app.witwiser.io/api/v1/users";
    public static final String GET_URL = "https://testing-app.witwiser.io/api/v1/users/1ed95a53-86b4-5f69-ddf9-01f2d048822b";
    public static final String CONTENT_TYPE = "application/json";
    public static final String HOST = "testing-app.witwiser.io";
    static String random =  UUID.randomUUID().toString();
    public static final String POST_DATA = "{\n" +
            "    \"firstName\": \"asdasdaa\",\n" +
            "    \"lastName\": \"asfeaa\",\n" +
            "    \"username\": \""+ random +"\",\n"+
            "    \"email\": \""+random+"@witwiser.io\"\n" +
            "}";
    public static final String STATİC_DATA = "{\n" +
            "    \"firstName\": \"asdasdaa\",\n" +
            "    \"lastName\": \"asfeaa\",\n" +
            "    \"username\": \"aefghjgaasea.user3\",\n"+
            "    \"email\": \"eafgfghjaava.user3@witwiser.io\"\n" +
            "}";
}
