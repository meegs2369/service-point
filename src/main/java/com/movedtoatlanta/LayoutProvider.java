package com.movedtoatlanta;

import ch.qos.logback.core.CoreConstants;
import com.movedtoatlanta.models.CustomSLF4JLoggingEvent;

import java.time.Instant;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Class used to mask sensitive data in applications that use slf4j.
 */
public class LayoutProvider {

    private static LayoutProvider provider;
    private String mask = "";
    private String pattern = "";
    private int length = 0;

    public static LayoutProvider getProvider() {
        if (provider == null) {
            provider = new LayoutProvider();
        }
        return provider;
    }


    private LayoutProvider() {
    }

    /**
     * Sets the String you wish to use as a mask.
     *
     * @param mask String
     * @return LayoutProvider
     */
    public LayoutProvider setMask(String mask) {
        this.mask = mask;
        return this;
    }

    /**
     * Sets the regex for what you are looking for.
     *
     * @param pattern String
     * @return LayoutProvider
     */
    public LayoutProvider setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    /**
     * Sets length to show of given pattern.
     *
     * @param length int
     * @return LayoutProvider
     */
    public LayoutProvider setUnmaskedLength(int length) {
        this.length = length;
        return this;
    }

    /**
     * format the lines in the log.
     *
     * @param event extension of {@link com.movedtoatlanta.models.CustomSLF4JLoggingEvent}
     * @return String
     */
    public String format(CustomSLF4JLoggingEvent event) {
        return Instant.ofEpochMilli(event.getTimestamp())
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime() + "|-" + event.getLevel() + " [" + event.getStackTraceElement()
                .getFileName() + ":"
                + event.getStackTraceElement()
                .getLineNumber() + "] - " + maskSensitiveData(event.getFormattedMessage())

                + CoreConstants.LINE_SEPARATOR;
    }

    private String maskSensitiveData(String formattedMessage) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(formattedMessage);
        return m.find() ? mask(formattedMessage, m) : formattedMessage;
    }

    private String mask(String message, Matcher matcher) {
        String data = message.substring(matcher.start(), matcher.end() - length);
        String masked = data.chars()
                .mapToObj(i -> mask)
                .collect(Collectors.joining());
        return message.replaceAll(data, masked);
    }
}



