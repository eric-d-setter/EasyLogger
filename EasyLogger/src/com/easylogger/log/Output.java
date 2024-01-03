package com.easylogger.log;

import java.io.PrintStream;
import java.util.logging.Level;

public enum Output {
    INFO(System.out, Level.INFO),
    WARN(System.out, Level.WARNING),
    ERR(System.err, Level.SEVERE);

    public final PrintStream output;
    public final Level level;

    private Output(PrintStream output, Level level) {
        this.output = output;
        this.level = level;
    }
}
