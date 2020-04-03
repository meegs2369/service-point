package com.movedtoatlanta;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListToMapTest {

    @Test
    public void splittingPairs() {
        List<String> elements = new ArrayList<>();
        elements.add("Murray&June");
        elements.add("Jenny&Erica");
        Map<String, String> teams = ListToMap.getConversion(elements, "&");
        String teamMate = teams.get("Murray");
        Assert.assertTrue(teamMate.matches("June"));
        teamMate = teams.get("Jenny");
        Assert.assertTrue(teamMate.matches("Erica"));
    }
}
