package com.movedtoatlanta;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.movedtoatlanta.models.TestObject;

public class SingletonCollectorTest {

	@Test
	public void getOne() {
		List<TestObject> mobs = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			TestObject mob = new TestObject();
			mob.setAttribute1(Long.valueOf(Integer.toString(i)));
			mob.setAttribute2(i);
			mob.setAttribute3(Integer.toString(i));
			mobs.add(mob);
		}
		TestObject mob2 = mobs.stream()
							  .filter(mockObject -> mockObject.getAttribute1() == 6L)
							  .collect(SingletonCollector.singleFromStream());
		Assert.assertTrue(mob2.getAttribute3()
							  .matches("6"));
		Assert.assertEquals(mob2.getAttribute2()
								.intValue(), 6);
		;
	}

}
