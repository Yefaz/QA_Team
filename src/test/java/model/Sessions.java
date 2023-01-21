package model;

public class Sessions {

    private String testTakerName;
    private String testTakerEmail;


    public String getTestTakerEmail() {
        return testTakerEmail;
    }

    public void setTestTakerEmail(String testTakerEmail) {
        this.testTakerEmail = testTakerEmail;
    }

    public Sessions(String testTakerName, String testTakerEmail) {
        this.testTakerName = testTakerName;
        this.testTakerEmail = testTakerEmail;
    }

    public String getTestTakerName() {
        return testTakerName;
    }

    public void setTestTakerName(String testTakerName) {
        this.testTakerName = testTakerName;
    }

    public Sessions() {
    }
}
