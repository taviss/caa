package com.sod.caa.data;

import com.sod.caa.definitions.InstructionType;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    private int type;
    private List<String> operands;
    private String instructionString;

    public Instruction(int type) {
        this.type = type;
        this.operands = new ArrayList<String>();
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getOperands() {
        return operands;
    }

    public void setOperands(List<String> operands) {
        this.operands = operands;
    }

    public String getInstructionString() {
        return instructionString;
    }

    public void setInstructionString(String instructionString) {
        this.instructionString = instructionString;
    }
}
