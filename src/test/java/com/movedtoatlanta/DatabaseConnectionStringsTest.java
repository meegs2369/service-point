package com.movedtoatlanta;

import com.movedtoatlanta.connectors.data.DatabaseConnectionStrings;
import org.junit.Assert;
import org.junit.Test;

public class DatabaseConnectionStringsTest {
    @Test
    public void getPGString() {
        String expected = "jdbc:postgresql://localhost:5432/customers";
        String connectionString = DatabaseConnectionStrings.getPGString("localhost", "customers", "5432");
        Assert.assertEquals(expected, connectionString);
    }

    @Test
    public void getPortedMSString() {
        String expected = "jdbc:sqlserver://localhost:1433;databaseName=customers";
        String connectionString = DatabaseConnectionStrings.getMSString("localhost", "customers", "1433");
        Assert.assertEquals(expected, connectionString);
    }

    @Test
    public void getNamedMSString() {
        String expected = "jdbc:sqlserver://localhost;databaseName=customers";
        String connectionString = DatabaseConnectionStrings.getMSString("localhost", "customers", "");
        Assert.assertEquals(expected, connectionString);
    }

    @Test
    public void getNamedMSStringNullPort() {
        String expected = "jdbc:sqlserver://localhost;databaseName=customers";
        String connectionString = DatabaseConnectionStrings.getMSString("localhost", "customers", null);
        Assert.assertEquals(expected, connectionString);
    }
}
