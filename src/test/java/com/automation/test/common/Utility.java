package com.automation.test.common;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public static List<String> retrieveRegistrationNumbers(String filePath) {
        List<String> regNumbers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                regNumbers.addAll(getRegNumber(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return regNumbers;
    }

    public static List<String> getRegNumber(String text) {
        List<String> registrationNumbers = new ArrayList<>();
        String regex = "[A-Z]{2}\\d{2}\\s?[A-Z]{3}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            registrationNumbers.add(matcher.group());
        }
        return registrationNumbers;
    }
    public static Map<String, String[]> readOutputFile(String filePath) {
        Map<String, String[]> expectedCarDetails = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String registrationNumber = parts[1].trim();
                String makeModel = parts[0].trim();
                String variantReg = parts[1].trim();
                String yearBody = parts[2].trim();
                String[] detailsArray = {makeModel, variantReg, yearBody};
                expectedCarDetails.put(registrationNumber, detailsArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expectedCarDetails;
    }
}
