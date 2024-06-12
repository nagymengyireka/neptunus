package com.codecool.neptunus.model;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StudentIdGenerator {

    private static final Random RANDOM = new Random();
    private static final int CODE_LENGTH = 6;
    private static final int CHAR_ASCII_LOWER_LIMIT = 65;
    private static final int CHAR_ASCII_UPPER_LIMIT = 90;

    public String generateId() {
        StringBuilder studentCode = new StringBuilder();
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (RANDOM.nextBoolean()){
                studentCode.append((char) RANDOM.nextInt(CHAR_ASCII_LOWER_LIMIT, CHAR_ASCII_UPPER_LIMIT));
            } else {
                studentCode.append(RANDOM.nextInt(1, 10));
            }
        }
        return studentCode.toString();
    }
}
