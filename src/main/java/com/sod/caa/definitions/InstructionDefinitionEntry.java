package com.sod.caa.definitions;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "instruction")
public class InstructionDefinitionEntry {

    private int type;

    private int noOfOperands;

    private String instructionString;

    public int getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(int type) {
        this.type = type;
    }

    public int getNoOfOperands() {
        return noOfOperands;
    }

    @XmlAttribute(name = "operands")
    public void setNoOfOperands(int noOfOperands) {
        this.noOfOperands = noOfOperands;
    }

    public String getInstructionString() {
        return instructionString;
    }

    @XmlValue
    public void setInstructionString(String instructionString) {
        this.instructionString = instructionString;
    }
}
