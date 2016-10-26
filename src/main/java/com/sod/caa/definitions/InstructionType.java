package com.sod.caa.definitions;

public enum InstructionType {
    INSTR_MUL("MUL"),
    INSTR_MOV("MOV")
    ;

    private final String instructionType;

    private InstructionType(final String instructionType) {
        this.instructionType = instructionType;
    }

    @Override
    public String toString() {
        return instructionType;
    }
}
