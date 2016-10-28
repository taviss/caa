package com.sod.caa.arguments;


import org.apache.commons.cli.Option;

public class ArgumentsList {
    private static final Option help = Option.builder("help").argName("help").desc("Help message.").optionalArg(true).build();
    private static final Option definitionsInputPath = Option.builder("defInputPath").argName("definitionsInputPath").desc("Path to the definitions xml").hasArg().required().build();
    private static final Option definitionsInputType = Option.builder("defInputType").argName("definitionsInputType").desc("Type of definitions input").hasArg().required().build();
    private static final Option inputPath = Option.builder("inputFile").argName("inputFile").desc("Path to the file to be analyzed").hasArg().required().build();
    private static final Option reportPath = Option.builder("reportPath").argName("reportPath").desc("Path to the report output directory").hasArg().required().build();

    public static Option getDefinitionsInputPath() {
        return definitionsInputPath;
    }

    public static Option getDefinitionsInputType() {
        return definitionsInputType;
    }

    public static Option getHelp() {
        return help;
    }

    public static Option getInputPath() { return inputPath; }

    public static Option getReportPath() { return reportPath; }
}
