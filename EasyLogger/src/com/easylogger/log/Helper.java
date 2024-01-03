package com.easylogger.log;

public class Helper {
    static boolean isNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    static boolean notNullOrEmpty(String string) {
        return !isNullOrEmpty(string);
    }
}
