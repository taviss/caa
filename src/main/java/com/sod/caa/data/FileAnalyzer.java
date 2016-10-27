package com.sod.caa.data;

import com.sod.caa.exceptions.CAAInputException;

import java.io.*;

public class FileAnalyzer {
    public void analyzeFile(File file) throws CAAInputException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

            }
        } catch (IOException e) {
            throw new CAAInputException(e);
        }
    }
}
