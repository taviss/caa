package com.sod.caa.definitions.loaders;

import com.sod.caa.arguments.ArgumentsList;
import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.exceptions.CAAInputException;
import com.sod.caa.utils.Constants;
import com.sod.caa.utils.DefinitionsUtils;
import org.apache.commons.cli.CommandLine;

import java.io.File;

public class InstructionDefinitionsLoader {

    public InstructionDefinitions loadDefinitions(CommandLine arguments) throws CAAInputException {
        String instrPath = arguments.getOptionValue(ArgumentsList.getDefinitionsInputPath().getOpt()) + File.separator + Constants.DEFINITIONS_XML;
        return DefinitionsUtils.unmarshalDefinitions(instrPath);
    }
}
