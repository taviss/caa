package com.sod.caa.data.loaders;

import com.sod.caa.arguments.ArgumentsList;
import com.sod.caa.exceptions.CAAInputException;
import org.apache.commons.cli.CommandLine;

import java.io.File;

public class FileLoader {
    public File loadFile(CommandLine arguments) throws CAAInputException {
        File file = new File(arguments.getOptionValue(ArgumentsList.getInputPath().getOpt()));
        if(file == null) {
            throw new CAAInputException("Bad input file.");
        }
        return file;
    }
}
