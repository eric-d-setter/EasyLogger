package com.easylogger.log;

import java.io.PrintStream;

public class CustomLevel {
    private final PrintStream output;
    private final String logDescriptor;

    public CustomLevel(final PrintStream output, final String logDescriptor) {
        this.output = output;
        this.logDescriptor = logDescriptor;
    }

    PrintStream getOutput() {
        return output;
    }

    String getLogDescriptor() {
        return logDescriptor;
    }
}
