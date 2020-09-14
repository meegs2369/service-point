package com.movedtoatlanta.logging;

import ch.qos.logback.classic.Level;

/**
 * Class to be extended for {@link LayoutProvider} when using SLF4J.
 */
public abstract class CustomSLF4JLoggingEvent implements CustomLoggingEvent {
    private final StackTraceElement stackTraceElement;
    private final Long timestamp;
    private final String formattedMessage;
    private final Level level;

    /**
     * @param stackTraceElement StackTraceElement
     * @param timestamp         Long
     * @param formattedMessage  String
     * @param level             {@link ch.qos.logback.classic.Level}
     */
    public CustomSLF4JLoggingEvent(StackTraceElement stackTraceElement, Long timestamp, String formattedMessage, Level level) {
        this.stackTraceElement = stackTraceElement;
        this.timestamp = timestamp;
        this.formattedMessage = formattedMessage;
        this.level = level;
    }

    @Override
    public StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }

    @Override
    public Long getTimestamp() {
        return this.timestamp;
    }

    @Override
    public String getFormattedMessage() {
        return this.formattedMessage;
    }

    @Override
    public Level getLevel() {
        return this.level;
    }
}