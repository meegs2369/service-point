package com.movedtoatlanta.models;

import ch.qos.logback.classic.Level;

/**
 * class to be extended for {@link com.movedtoatlanta.LayoutProvider}.
 */
public abstract class CustomSLF4JLoggingEvent {
    private StackTraceElement stackTraceElement;
    private Long timestamp;
    private String formattedMessage;
    private Level level;

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

    public StackTraceElement getStackTraceElement() {
        return this.stackTraceElement;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public String getFormattedMessage() {
        return this.formattedMessage;
    }

    public Level getLevel() {
        return this.level;
    }
}