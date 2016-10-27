package com.sod.caa.definitions.loaders;

import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.exceptions.CAAInputException;
import com.sod.caa.utils.DefinitionsUtils;

public class InstructionDefinitionsLoader {

    public InstructionDefinitions loadDefinitions(String path) throws CAAInputException {
        return DefinitionsUtils.unmarshalDefinitions(path);
    }
}
