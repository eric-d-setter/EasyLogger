package com.easylogger.log;

import java.io.PrintStream;
import java.util.logging.Level;

public enum Output {
    INFO(System.out, Level.INFO, "INFO  "),
    WARN(System.out, Level.WARNING, "WARN  "),
    ERR(System.err, Level.SEVERE, "ERROR ");

    public final PrintStream output;
    public final Level level;
    public final String logOut;

    private Output(PrintStream output, Level level, String logOut) {
        this.output = output;
        this.level = level;
        this.logOut = logOut;
    }
}
