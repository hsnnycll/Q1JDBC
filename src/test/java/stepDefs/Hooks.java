package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utilities.DBUtils;

import java.sql.SQLException;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("Setting up the test from the Hooks class!");
    }

    @Before("@db")
    public void setUpDBConnection(){
        System.out.println("Setting up the DB Connection!");
        DBUtils.createConnection();
    }

    @After("@db")
    public void tearDownDBConnection(){
        System.out.println("Closing the DB Connection!");
        try {
            DBUtils.destroy();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
