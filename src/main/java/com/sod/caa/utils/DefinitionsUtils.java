package com.sod.caa.utils;

import com.sod.caa.definitions.InstructionDefinitions;
import com.sod.caa.exceptions.CAAInputException;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DefinitionsUtils {
    private static JAXBContext jaxbContextDef = null;

    private static JAXBContext getDefJAXBContext() throws JAXBException {
        if (jaxbContextDef == null)
            jaxbContextDef = JAXBContext.newInstance(InstructionDefinitions.class);
        return jaxbContextDef;
    }

    public static InstructionDefinitions unmarshalDefinitions(String path) throws CAAInputException {
        InstructionDefinitions instructionDefinitions = null;
        try {
            File file = new File(path);
            JAXBContext jaxbContext = getDefJAXBContext();
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        /*SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(new StreamSource(
                DefinitionsUtils.class.getClassLoader().getResourceAsStream(Constants.DEF_XSD)));
        */
            //unmarshaller.setSchema(schema);
            instructionDefinitions = (InstructionDefinitions) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new CAAInputException(e.getMessage());
        }
        return instructionDefinitions;
    }
}
