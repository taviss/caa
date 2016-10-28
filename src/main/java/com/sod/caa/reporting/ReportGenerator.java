package com.sod.caa.reporting;

import com.sod.caa.data.Instruction;
import com.sod.caa.definitions.InstructionDefinitionEntry;
import com.sod.caa.definitions.InstructionDefinitions;
import org.apache.log4j.Logger;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    private Date runDate;
    private Map<String, Integer> instructionsCount;
    private Logger logger = Logger.getLogger(ReportGenerator.class);

    public ReportGenerator() {
        instructionsCount = new HashMap<>();
    }

    public void generateReport(InstructionDefinitions instructionDefinitions, List<Instruction> instructions) {
        populateCountMap(instructions);
        logger.info("Report for given input file:");
        for(String instructionName : instructionsCount.keySet()) {
            logger.info("* " + instructionName + ", Type=" + getInstructionType(instructionDefinitions, instructionName) + ", Count=" + instructionsCount.get(instructionName));
        }
    }

    public int getInstructionType(InstructionDefinitions instructionDefinitions, String instructionName) {
        for(InstructionDefinitionEntry definitionEntry : instructionDefinitions.getDefinitionEntryList()) {
            if(definitionEntry.getInstructionString().equalsIgnoreCase(instructionName)) {
                return definitionEntry.getType();
            }
        }
        return 0;
    }

    public void populateCountMap(List<Instruction> instructions) {
        for(Instruction instruction : instructions) {
            Integer value = instructionsCount.get(instruction.getInstructionString().toLowerCase());
            if(value == null) value = 0;
            instructionsCount.put(instruction.getInstructionString().toLowerCase(), value+1);
        }
    }

    public Date getRunDate() {
        return runDate;
    }

    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }
}
