package ca.users.model;

public class User {
    private long id;
    private String name;
    private String statement;

    public User() {

    }

    public User(long id, String name, String statement) {
        this.id = id;
        this.name = name;
        this.statement = statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatement() {
        return statement;
    }
}
