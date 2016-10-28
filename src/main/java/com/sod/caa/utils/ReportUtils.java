package com.sod.caa.utils;

import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.exceptions.CAAInputException;
import com.sod.caa.reporting.SummaryReport;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class ReportUtils {
    private static JAXBContext jaxbContextReport= null;

    private static JAXBContext getReportJAXBContext() throws JAXBException {
        if (jaxbContextReport == null)
            jaxbContextReport = JAXBContext.newInstance(SummaryReport.class);
        return jaxbContextReport;
    }

    public static void marshallSummaryReport(SummaryReport summaryReport, String path) throws CAAInputException {
        try {
            JAXBContext jaxbContext = getReportJAXBContext();
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(summaryReport, new File(path + File.separator + "report.xml"));
        } catch (JAXBException e) {
            throw new CAAInputException(e);
        }
    }
}
