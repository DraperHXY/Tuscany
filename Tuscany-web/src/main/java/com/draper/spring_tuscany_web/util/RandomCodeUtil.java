package com.draper.spring_tuscany_web.util;

import java.util.Random;

public class RandomCodeUtil {

    private static Random random = new Random();

    private final static int MAX = 9999;

    private final static int MIN = 1000;

    public static int build() {
        return random.nextInt(MAX) % (MAX - MIN + 1) + MIN;
    }

}
