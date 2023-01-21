package model;

import java.util.List;

public class Result {

    private List<Sessions> sessions;

    public Result(List<Sessions> sessions) {
        this.sessions = sessions;
    }

    public Result() {
    }

    public List<Sessions> getSessions() {
        return sessions;
    }

    public void setSessions(List<Sessions> sessions) {
        this.sessions = sessions;
    }
}
