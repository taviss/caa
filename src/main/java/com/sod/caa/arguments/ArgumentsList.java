package com.sod.caa.arguments;


import org.apache.commons.cli.Option;

public class ArgumentsList {
    private final Option help = Option.builder().argName("help").desc("Help message.").build();
    private final Option definitionsInputPath = Option.builder().argName("definitionsInputPath").desc("Path to the definitions xml.").hasArg().required().build();
    private final Option definitionsInputType = Option.builder().argName("definitionsInputType").desc("Type of definitions input").hasArg().required().build();

    public Option getDefinitionsInputPath() {
        return definitionsInputPath;
    }

    public Option getDefinitionsInputType() {
        return definitionsInputType;
    }

    public Option getHelp() {
        return help;
    }
}
