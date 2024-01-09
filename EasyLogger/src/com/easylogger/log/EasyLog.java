package com.easylogger.log;

import java.time.Instant;

public class EasyLog {

    private static final String EMPTY = "";

    /**
     * Logs the current method and the prior calling method.
     * @param logMessage User customizable message
     */
    public static void logBreadcrumbs(String logMessage) {
        logBreadcrumbs(Output.INFO, 1, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param logMessage User customizable message
     */
    public static void logBreadcrumbs(int depth, String logMessage) {
        logBreadcrumbs(Output.INFO, depth, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logBreadcrumbs(int depth, String prefix, String logMessage) {
        logBreadcrumbs(Output.INFO, depth, prefix, logMessage);
    }

    /**
     * Logs the current method and the prior calling method.
     * @param logMessage User customizable message
     */
    public static void logErrorBreadcrumbs(String logMessage) {
        logBreadcrumbs(Output.ERR, 1, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param logMessage User customizable message
     */
    public static void logErrorBreadcrumbs(int depth, String logMessage) {
        logBreadcrumbs(Output.ERR, depth, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logErrorBreadcrumbs(int depth, String prefix, String logMessage) {
        logBreadcrumbs(Output.ERR, depth, prefix, logMessage);
    }

    /**
     * Logs the current method and the prior calling method.
     * @param logMessage User customizable message
     */
    public static void logWarnBreadcrumbs(String logMessage) {
        logBreadcrumbs(Output.WARN, 1, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param logMessage User customizable message
     */
    public static void logWarnBreadcrumbs(int depth, String logMessage) {
        logBreadcrumbs(Output.WARN, depth, EMPTY, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param depth The number of extra method names the user wishes to see
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logWarnBreadcrumbs(int depth, String prefix, String logMessage) {
        logBreadcrumbs(Output.WARN, depth, prefix, logMessage);
    }

    /**
     * Logs the current method and every calling method based on user input.
     * @param output Type of log: Info, Warning, or Error
     * @param depth The number of extra method names the user wishes to see
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    private static void logBreadcrumbs(Output output, int depth, String prefix, String logMessage) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= depth; i++) {
            builder.append("@" + MethodHelper.dynamicHigherMethodName(i + 1) + " "); // Increasing the depth because processing is in another method
        }
        log(output, builder.toString(), prefix, logMessage);
    }

    /**
     * Logs the current method (System.out) as well as the log message.
     * @param logMessage User customizable message
     */
    public static void logWithLocation(String logMessage) {
        log(Output.INFO, "@" + MethodHelper.higherMethodName(), EMPTY, logMessage);
    }

    /**
     * Logs the current method (System.out) as well as the log message.
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logWithLocation(String prefix, String logMessage) {
        log(Output.INFO, "@" + MethodHelper.higherMethodName(), prefix, logMessage);
    }

    /**
     * Logs the current method (System.err) as well as the log message.
     * @param logMessage User customizable message
     */
    public static void logErrorWithLocation(String logMessage) {
        log(Output.ERR, "@" + MethodHelper.higherMethodName(), EMPTY, logMessage);
    }

    /**
     * Logs the current method (System.err) as well as the log message.
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logErrorWithLocation(String prefix, String logMessage) {
        log(Output.ERR, "@" + MethodHelper.higherMethodName(), prefix, logMessage);
    }

    /**
     * Logs the current method (System.err) as well as the log message.
     * @param logMessage User customizable message
     */
    public static void logWarnWithLocation(String logMessage) {
        log(Output.WARN, "@" + MethodHelper.higherMethodName(), EMPTY, logMessage);
    }

    /**
     * Logs the current method (System.err) as well as the log message.
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logWarnWithLocation(String prefix, String logMessage) {
        log(Output.WARN, "@" + MethodHelper.higherMethodName(), prefix, logMessage);
    }

    /**
     * Logs the user's message (System.out)
     * @param logMessage User customizable message
     */
    public static void log(String logMessage) {
        log(Output.INFO, EMPTY, EMPTY, logMessage);
    }

    /**
     * Logs the user's message (System.out)
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void log(String prefix, String logMessage) {
        log(Output.INFO, EMPTY, prefix, logMessage);
    }

    /**
     * Logs the user's message (System.err)
     * @param logMessage User customizable message
     */
    public static void logError(String logMessage) {
        log(Output.ERR, EMPTY, EMPTY, logMessage);
    }

    /**
     * Logs the user's message (System.err)
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logError(String prefix, String logMessage) {
        log(Output.ERR, EMPTY, prefix, logMessage);
    }

    /**
     * Logs the user's message (System.err)
     * @param logMessage User customizable message
     */
    public static void logWarn(String logMessage) {
        log(Output.WARN, EMPTY, EMPTY, logMessage);
    }

    /**
     * Logs the user's message (System.err)
     * @param prefix Tag for the log, useful for filtering
     * @param logMessage User customizable message
     */
    public static void logWarn(String prefix, String logMessage) {
        log(Output.WARN, EMPTY, prefix, logMessage);
    }

    private static void log(Output output, String location, String prefix, String message) {
        StringBuilder builder = new StringBuilder();
        builder.append(Instant.now()).append(" ").append(output.logOut).append("|");
        if (Helper.notNullOrEmpty(location)) builder.append(" location:").append(location.trim()).append(" |");
        if (Helper.notNullOrEmpty(prefix))   builder.append(" [").append(prefix).append("]");
        builder.append(" ").append(message);
        output.output.println(builder);
    }
}
