package com.sod.caa.reporting;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.Map;

@XmlRootElement
public class SummaryReport {
    private Date runDate;
    private Map<String, Integer> instructionsCount;

    public Date getRunDate() {
        return runDate;
    }

    @XmlElement
    public void setRunDate(Date runDate) {
        this.runDate = runDate;
    }

    public Map<String, Integer> getInstructionsCount() {
        return instructionsCount;
    }

    @XmlElement
    public void setInstructionsCount(Map<String, Integer> instructionsCount) {
        this.instructionsCount = instructionsCount;
    }
}
