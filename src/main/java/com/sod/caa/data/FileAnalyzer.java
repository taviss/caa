package com.sod.caa.data;

import com.sod.caa.definitions.InstructionDefinitionEntry;
import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.definitions.InstructionType;
import com.sod.caa.exceptions.CAAInputException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {
    private InstructionDefinitions instructionDefinitions;

    public List<Instruction> analyzeFile(File file) throws CAAInputException {
        List<Instruction> instructions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                instructions.add(analyzeLine(line));
            }
            return instructions;
        } catch (IOException e) {
            throw new CAAInputException(e);
        }
    }

    public Instruction analyzeLine(String line) {
        for(InstructionDefinitionEntry definitionEntry : instructionDefinitions.getDefinitionEntryList()) {
            if(line.toLowerCase().contains(definitionEntry.getInstructionString().toLowerCase()) && !line.startsWith(";")) {
                Instruction instruction = new Instruction(definitionEntry.getType());
                instruction.setInstructionString(definitionEntry.getInstructionString());
                if(definitionEntry.getNoOfOperands() > 0) {
                    List<String> operands = new ArrayList<>();
                    String operandsRegEx = "";
                    for (int i = 0; i < definitionEntry.getNoOfOperands(); i++) {
                        if (i == 0) operandsRegEx = definitionEntry.getInstructionString().toLowerCase() + "\\s+(\\S+)";
                        else operandsRegEx += ",(\\S+)";
                    }
                    Pattern pattern = Pattern.compile(operandsRegEx);
                    Matcher matcher = pattern.matcher(line);
                    if(matcher.find()) {
                        for(int i = 1; i <= definitionEntry.getNoOfOperands(); i++) {
                            operands.add(matcher.group(i));
                        }
                    } else {
                        return null;
                    }
                    instruction.setOperands(operands);
                }
                return instruction;
            }
        }
        return null;
    }

    public void setInstructionDefinitions(InstructionDefinitions instructionDefinitions) {
        this.instructionDefinitions = instructionDefinitions;
    }
}
