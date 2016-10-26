package com.sod.caa.definitions;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "instructions")
@XmlAccessorType(XmlAccessType.FIELD)
public class InstructionDefinitions {
    @XmlAttribute(name = "type")
    private int type;
    @XmlAttribute(name = "operands")
    private int noOfOperands;
    @XmlValue
    private String instructionString;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNoOfOperands() {
        return noOfOperands;
    }

    public void setNoOfOperands(int noOfOperands) {
        this.noOfOperands = noOfOperands;
    }

    public String getInstructionString() {
        return instructionString;
    }

    public void setInstructionString(String instructionString) {
        this.instructionString = instructionString;
    }
}
