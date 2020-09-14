package com.movedtoatlanta.converters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @since service-point
 * @since 2020-September-09
 */

public interface StreamReader {
    default String getResponse(InputStream inputStream) throws IOException {
        InputStreamReader inputStreamReader  = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        BufferedReader bufferedReader  = new BufferedReader(inputStreamReader);
        StringBuilder sb = new StringBuilder();
        String input;
        while((input = bufferedReader.readLine())!=null){
            sb.append(input);
        }
        return sb.toString();
    }
}
