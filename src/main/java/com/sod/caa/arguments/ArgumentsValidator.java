package com.sod.caa.arguments;

import com.sod.caa.exceptions.CAAInputException;
import org.apache.commons.cli.*;

public class ArgumentsValidator {
    public static CommandLine validateArguments(String args[]) throws CAAInputException {
        CommandLineParser parser = new DefaultParser();
        CommandLine line = null;
        try {
            Options options = new Options();
            addMandatoryArguments(options);
            line = parser.parse(options, args);
        }
        catch(ParseException e) {
            throw new CAAInputException(e);
        }
        return line;
    }

    private static void addMandatoryArguments(Options options) {
        options.addOption(ArgumentsList.getDefinitionsInputPath());
        options.addOption(ArgumentsList.getDefinitionsInputType());
        options.addOption(ArgumentsList.getInputPath());
        options.addOption(ArgumentsList.getReportPath());
    }

    private static void addOptionalArguments(ArgumentsList args, Options options) {
        options.addOption(args.getHelp());
    }
}
