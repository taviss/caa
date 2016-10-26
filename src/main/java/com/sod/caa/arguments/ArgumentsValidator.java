package com.sod.caa.arguments;

import org.apache.commons.cli.*;

public class ArgumentsValidator {
    public static void validateArguments(String args[]) {
        CommandLineParser parser = new DefaultParser();
        ArgumentsList argumentsList = new ArgumentsList();
        try {
            Options options = new Options();
            addMandatoryArguments(argumentsList, options);
            CommandLine line = parser.parse(options, args);
        }
        catch(ParseException exp) {
            System.err.println("Parsing failed.  Reason: " + exp.getMessage());
        }
    }

    private static void addMandatoryArguments(ArgumentsList args, Options options) {
        options.addOption(args.getDefinitionsInputPath());
        options.addOption(args.getDefinitionsInputType());
    }

    private static void addOptionalArguments(ArgumentsList args, Options options) {
        options.addOption(args.getHelp());
    }
}
