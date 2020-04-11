package com.movedtoatlanta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.movedtoatlanta.converters.ListToMap;
import com.movedtoatlanta.logging.models.TestObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ObjectTest {
    @Test
    public void stepwiseBreakdown() {
        TestObject mob = new TestObject();
        mob.setAttribute1(Long.valueOf(Integer.toString(1)));
        mob.setAttribute2(1);
        mob.setAttribute3(Integer.toString(1));
        try {
            String objectString = new ObjectMapper().writeValueAsString(mob);
            List<String> chars = new ArrayList<>();
            chars.add("{");
            chars.add("}");
            chars.add("\"");
            for (String s : chars) {
                objectString = objectString.replace(s, "");
            }
            objectString = objectString.replace(":", "=");
            objectString = objectString.replace(",", "&");
            System.out.println(objectString);
            List<String> elems = Arrays.asList(objectString.split("&"));
            Map<String, String> mapped = ListToMap.getConversion(elems, "=");
            Assert.assertEquals(Long.valueOf(mapped.get("attribute1")), mob.getAttribute1());
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
    }
}
