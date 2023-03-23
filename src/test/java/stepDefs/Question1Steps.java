package stepDefs;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class Question1Steps {

    @Given("Verify {int} {string} {string} {string} {string} {string} query should match with the result")
    public void verify_query_should_match_with_the_result(int id, String firstName, String lastName, String city, String country, String totalSpent) {
        String query = "SELECT c.customer_id, c.first_name, c.last_name, ci.city, co.country, SUM(p.amount) AS total_spent\n" +
                "FROM payment p\n" +
                "JOIN customer c ON p.customer_id = c.customer_id\n" +
                "JOIN address a ON c.address_id = a.address_id\n" +
                "JOIN city ci ON a.city_id = ci.city_id\n" +
                "JOIN country co ON ci.country_id = co.country_id\n" +
                "GROUP BY c.customer_id, c.first_name, c.last_name, ci.city, co.country\n" +
                "ORDER BY total_spent DESC\n" +
                "LIMIT 1;";
        List<Map<String, Object>> queryResult = DBUtils.getQueryResultMap(query);
        int expId = (int) queryResult.get(0).get("customer_id");
        String expFirstName = queryResult.get(0).get("first_name").toString();
        String expLastName = queryResult.get(0).get("last_name").toString();
        String expCity = queryResult.get(0).get("city").toString();
        String expCountry = queryResult.get(0).get("country").toString();
        String expTotalSpent = queryResult.get(0).get("total_spent").toString();
        Assert.assertEquals(expId, id);
        Assert.assertEquals(expFirstName, firstName);
        Assert.assertEquals(expLastName, lastName);
        Assert.assertEquals(expCity, city);
        Assert.assertEquals(expCountry, country);
        Assert.assertEquals(expTotalSpent, totalSpent);

    }
}
