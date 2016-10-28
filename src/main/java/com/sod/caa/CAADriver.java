package com.sod.caa;

import com.sod.caa.arguments.ArgumentsList;
import com.sod.caa.arguments.ArgumentsValidator;
import com.sod.caa.data.FileAnalyzer;
import com.sod.caa.data.Instruction;
import com.sod.caa.data.loaders.FileLoader;
import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.definitions.loaders.InstructionDefinitionsLoader;
import com.sod.caa.exceptions.CAAInputException;
import com.sod.caa.reporting.ReportGenerator;
import org.apache.commons.cli.CommandLine;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.Date;
import java.util.List;

public class CAADriver {
    private static final Logger logger = Logger.getLogger(CAADriver.class);

    private InstructionDefinitions instructionDefinitions;
    private CommandLine arguments;
    private File inputFile;
    private FileAnalyzer fileAnalyzer;
    private List<Instruction> instructions;
    private ReportGenerator reportGenerator;

    public CAADriver(String args[]) throws CAAInputException {
        this.arguments = ArgumentsValidator.validateArguments(args);
        this.fileAnalyzer = new FileAnalyzer();
        this.reportGenerator = new ReportGenerator();
    }

    public static void main(String args[]) {
        logger.info("Started execution.");
        try {
            CAADriver caaDriver = new CAADriver(args);
            caaDriver.loadDefinitions();
            caaDriver.loadInputFile();
            caaDriver.analyzeInput();
            caaDriver.generateReport();
            logger.info("Execution ended successfully.");
        } catch (CAAInputException e) {
            logger.error(e.getMessage());
        }
    }

    private void loadDefinitions() throws CAAInputException{
        InstructionDefinitionsLoader instructionDefinitionsLoader = new InstructionDefinitionsLoader();
        instructionDefinitions = instructionDefinitionsLoader.loadDefinitions(arguments);
    }

    private void loadInputFile() throws CAAInputException {
        FileLoader fileLoader = new FileLoader();
        inputFile = fileLoader.loadFile(arguments);
    }

    private void analyzeInput() throws CAAInputException {
        fileAnalyzer.setInstructionDefinitions(instructionDefinitions);
        instructions = fileAnalyzer.analyzeFile(inputFile);
    }

    private void generateReport() {
        reportGenerator.setRunDate(new Date());
        reportGenerator.generateReport(instructionDefinitions, instructions);
    }
}
