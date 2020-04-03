package com.movedtoatlanta;

import ch.qos.logback.classic.Level;
import ch.qos.logback.core.CoreConstants;
import com.movedtoatlanta.models.TestLoggingEvent;
import org.junit.Assert;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class LayoutProviderTest {

    @Test
    public void verifyFormatCC() {
        Level level = Level.INFO;
        StackTraceElement ste = new StackTraceElement(LayoutProviderTest.class.getSimpleName(), "processRequest",
                "InboundController", 45);
        long timestamp = Instant.now()
                .toEpochMilli();
        String formattedMessage =
                "ACCOUNT_NBR=4111111111111111&EXP_DATE=0213&CVV2=123";

        String expected = "2019-01-22T19:42:11.573|-INFO [InboundController:45] - ACCOUNT_NBR=************1111&EXP_DATE=0213&CVV2=123" + CoreConstants.LINE_SEPARATOR;

        TestLoggingEvent customLoggingEvent = new TestLoggingEvent(ste, timestamp, formattedMessage, level);
        String actual = LayoutProvider.getProvider()
                .setMask("*")
                .setPattern("\\d{13,16}")
                .setUnmaskedLength(4)
                .format(customLoggingEvent);
        try {
            LocalDateTime actualTime = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(actual.substring(0, 23))
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime();
            long time = actualTime.toInstant(ZoneOffset.UTC)
                    .atZone(ZoneId.systemDefault())
                    .minus(timestamp, ChronoUnit.MILLIS)
                    .getSecond();
            Assert.assertTrue(time < 1);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        actual = actual.substring(23)
                .trim();
        expected = expected.substring(23)
                .trim();
        Assert.assertEquals(expected, actual);
    }
}