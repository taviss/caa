package com.sod.caa.data;

import com.sod.caa.definitions.InstructionType;

import java.util.ArrayList;
import java.util.List;

public class Instruction {
    private InstructionType type;
    private List<String> operands;

    public Instruction(InstructionType type) {
        this.type = type;
        this.operands = new ArrayList<String>();
    }

    public InstructionType getType() {
        return type;
    }

    public void setType(InstructionType type) {
        this.type = type;
    }

    public List<String> getOperands() {
        return operands;
    }

    public void setOperands(List<String> operands) {
        this.operands = operands;
    }
}
