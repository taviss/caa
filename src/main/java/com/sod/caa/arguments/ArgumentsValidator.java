package com.sod.caa.arguments;

import org.apache.commons.cli.*;

public class ArgumentsValidator {
    public static CommandLine validateArguments(String args[]) {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = null;
        try {
            Options options = new Options();
            addMandatoryArguments(options);
            line = parser.parse(options, args);
        }
        catch(ParseException exp) {
            System.err.println("Error: " + exp.getMessage());
        }
        return line;
    }

    private static void addMandatoryArguments(Options options) {
        options.addOption(ArgumentsList.getDefinitionsInputPath());
        options.addOption(ArgumentsList.getDefinitionsInputType());
    }

    private static void addOptionalArguments(ArgumentsList args, Options options) {
        options.addOption(args.getHelp());
    }
}
