package com.sod.caa.reporting;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.HashMap;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SummaryReport {
    private Date runDate;
    private HashMap<String, Integer> instructionsCount;

    public Date getRunDate() {
        return runDate;
    }


    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public HashMap<String, Integer> getInstructionsCount() {
        return instructionsCount;
    }


    public void setInstructionsCount(HashMap<String, Integer> instructionsCount) {
        this.instructionsCount = instructionsCount;
    }
}
