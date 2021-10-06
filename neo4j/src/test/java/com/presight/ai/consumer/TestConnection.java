package com.presight.ai.consumer;


import org.junit.Assert;
import org.junit.Test;

import java.sql.*;

public class TestConnection {

    @Test
    public void simpleConnectionTest() throws SQLException {
        /**
         * https://www.baeldung.com/java-neo4j
         */
        try (Connection con = DriverManager.getConnection("jdbc:neo4j:bolt://localhost", "neo4j", "secret");
             Statement stmt = con.createStatement()) {
            stmt.execute("CREATE (baeldung:Company {name:\"Baeldung\"}) " +
                    "-[:owns]-> (tesla:Car {make: 'tesla', model: 'modelX'})" +
                    "RETURN baeldung, tesla");

            ResultSet rs = stmt.executeQuery("MATCH (company:Company)-[:owns]-> (car:Car)" +
                    "WHERE car.make='tesla' and car.model='modelX'" +
                    "RETURN company.name");

            while (rs.next()) {
                Assert.assertEquals(rs.getString("company.name"), "Baeldung");
            }
        }
    }
}
