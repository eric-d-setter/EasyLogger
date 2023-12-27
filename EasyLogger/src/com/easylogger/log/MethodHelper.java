package com.easylogger.log;

public class MethodHelper {
    public static final int CLIENT_CODE_STACK_INDEX;

    static {
        // Finds out the index of "this code" in the returned stack trace - funny, but it differs in JDK 1.5 and 1.6
        int i = 0;
        for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
            i++;
            if (ste.getClassName().equals(MethodHelper.class.getName())) {
                break;
            }
        }
        CLIENT_CODE_STACK_INDEX = i;
    }

    public static String methodName() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "()";
    }

    public static String higherMethodName() {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[CLIENT_CODE_STACK_INDEX + 1];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "()";
    }

    public static String dynamicHigherMethodName(int depth) {
        int dynamicDepth = CLIENT_CODE_STACK_INDEX + 1 + depth;
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[dynamicDepth];
        return stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "()";
    }
}