package com.sod.caa;

import com.sod.caa.arguments.ArgumentsList;
import com.sod.caa.arguments.ArgumentsValidator;
import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.definitions.loaders.InstructionDefinitionsLoader;
import com.sod.caa.exceptions.CAAInputException;
import org.apache.commons.cli.CommandLine;
import org.apache.log4j.Logger;

public class CAADriver {
    private InstructionDefinitions instructionDefinitions;
    private CommandLine arguments;
    private static final Logger logger = Logger.getLogger(CAADriver.class);

    public CAADriver(String args[]) {
        this.arguments = ArgumentsValidator.validateArguments(args);
    }

    public static void main(String args[]) {
        try {
            CAADriver caaDriver = new CAADriver(args);
            logger.info("Started execution.");
            caaDriver.loadDefinitions();
        } catch (CAAInputException e) {
            logger.error(e.getMessage());
        }
    }

    private void loadDefinitions() throws CAAInputException{
        InstructionDefinitionsLoader instructionDefinitionsLoader = new InstructionDefinitionsLoader();
        instructionDefinitions = instructionDefinitionsLoader.loadDefinitions(arguments.getOptionValue(ArgumentsList.getDefinitionsInputPath().getOpt()));
    }
}
