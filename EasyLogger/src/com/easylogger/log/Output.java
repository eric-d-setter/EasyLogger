package com.easylogger.log;

import java.io.PrintStream;

public enum Output {
    OUT(System.out),
    ERR(System.err);

    public final PrintStream output;

    private Output(PrintStream output) {
        this.output = output;
    }
}
