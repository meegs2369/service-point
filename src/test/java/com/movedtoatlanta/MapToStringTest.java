package com.movedtoatlanta;

import com.movedtoatlanta.converters.MapToString;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapToStringTest {

    @Test
    public void joinPairs() {
        Map<String, String> teams = new HashMap<>();
        teams.put("Murray", "June");
        teams.put("Jenny", "Erica");
        String teamString = MapToString.buildSet(teams, "+", null);
        Assert.assertTrue(teamString.matches("Murray\\+June Jenny\\+Erica"));
    }

    @Test
    public void joinPairsKeyValQuery() {
        Map<String, String> teams = new HashMap<>();
        teams.put("FirstName", "June");
        teams.put("LastName", "Cleaver");
        String teamString = MapToString.buildSet(teams, "=", "&");
        Assert.assertTrue(teamString.matches("FirstName=June&LastName=Cleaver"));
    }

    @Test
    public void joinPairsBlankDelimiter() {
        Map<String, String> teams = new HashMap<>();
        teams.put("Murray", "June");
        teams.put("Jenny", "Erica");
        String teamString = MapToString.buildSet(teams, "+", "");
        Assert.assertTrue(teamString.matches("Murray\\+June Jenny\\+Erica"));
    }
}
