package com.sod.caa.definitions;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "instructions")
public class InstructionDefinitions {
    private List<InstructionDefinitionEntry> definitionEntryList;

    public List<InstructionDefinitionEntry> getDefinitionEntryList() {
        return definitionEntryList;
    }

    @XmlElement(name = "instruction")
    public void setDefinitionEntryList(List<InstructionDefinitionEntry> definitionEntryList) {
        this.definitionEntryList = definitionEntryList;
    }
}
