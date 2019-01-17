package com.movedtoatlanta;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MapToStringTest {

	@Test
	public void joinPairs() {
		Map<String, String> teams = new HashMap<>();
		teams.put("Murray", "June");
		teams.put("Jenny", "Erica");
		String teamString = MapToString.convert(teams, "+", null);
		Assert.assertTrue(teamString.matches("Murray\\+June Jenny\\+Erica"));
	}

	@Test
	public void joinPairsKeyValQuery() {
		Map<String, String> teams = new HashMap<>();
		teams.put("FirstName", "June");
		teams.put("LastName", "Cleaver");
		String teamString = MapToString.convert(teams, "=", "&");
		Assert.assertTrue(teamString.matches("FirstName=June&LastName=Cleaver"));
	}
}
