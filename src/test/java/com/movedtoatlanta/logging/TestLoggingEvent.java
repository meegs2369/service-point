package com.movedtoatlanta.logging;

import ch.qos.logback.classic.Level;

public class TestLoggingEvent extends CustomSLF4JLoggingEvent {
    public TestLoggingEvent(StackTraceElement stackTraceElement, Long timestamp, String formattedMessage, Level level) {
        super(stackTraceElement, timestamp, formattedMessage, level);
    }
}
