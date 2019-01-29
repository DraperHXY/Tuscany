package com.draper.spring_tuscany_web.util;

public class RandomServiceUtil {

    public static Object getService(Object... services){
        int length = services.length;
        int i = (int) (Math.random() * 1000 % length);
        return services[i];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int t = (int) (Math.random() * 100 % 2);
            System.out.println(t + "");
        }
    }

}
