package io.github.pactstart.ifabu.utils;

import java.util.Random;

public class AppUtils {

    private static final String RANDOM_STR = "abcdefghigklmnopqrstuvwxyz0123456789";

    public static String generateRandomStr(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(RANDOM_STR.length());
            char c = RANDOM_STR.charAt(index);
            sb.append(c);
        }
        return sb.toString();
    }
}
