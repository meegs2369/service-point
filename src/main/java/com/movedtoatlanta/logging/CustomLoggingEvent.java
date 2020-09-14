package com.movedtoatlanta.logging;

import ch.qos.logback.classic.Level;

/**
 * CustomLoggingEvent for LayoutProvider.
 */
public interface CustomLoggingEvent {
    /**
     * @return StackTraceElement
     */
    StackTraceElement getStackTraceElement();

    /**
     * @return Long
     */
    Long getTimestamp();

    /**
     * @return String
     */
    String getFormattedMessage();

    /**
     * @return {@link ch.qos.logback.classic.Level}
     */
    Level getLevel();
}
