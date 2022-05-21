package com.project.example.service;

import com.project.example.exception.FinancingTypeInvalid;
import com.project.example.exception.InternalError;
import com.project.example.exception.MonthNumberInvalid;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FinancingService {
    String finDataPath = String.valueOf(ResourceUtils.getFile("src/main/resources/FinancingData.json").toPath());
    String clientDataPath = String.valueOf(ResourceUtils.getFile("src/main/resources/ClientData.json").toPath());

    public FinancingService() throws FileNotFoundException {
    }

    public double calculate(String finType, int monthNum, double carValue) {
        float finFactor = 0;
        JSONParser jsonParser = new JSONParser();

        finType = finType.toLowerCase();
        if (finType.equals("internal")) {
            if (monthNum % 12 != 0 || 12 > monthNum || 60 < monthNum) throw new MonthNumberInvalid();
        } else if (finType.equals("external")) {
            if (monthNum % 12 != 0 || 12 > monthNum || 48 < monthNum) throw new MonthNumberInvalid();
        }

        try (FileReader reader = new FileReader(finDataPath)) {
            //Read JSON file
            Object data = jsonParser.parse(reader);

            JSONObject financingTypes = (JSONObject) data;

            try {
                finFactor = Float.parseFloat((String) financingTypes.get(finType));
            } catch (Exception e) {
                throw new FinancingTypeInvalid();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return carValue * finFactor / monthNum;
    }

    public String saveInfo(String name, String contact, double financingValue) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(clientDataPath)) {
            //Read JSON file
            Object data = jsonParser.parse(reader);

            JSONArray clientData = (JSONArray) data;
            JSONObject newEntry = new JSONObject();

            newEntry.put("Name", name);
            newEntry.put("Contact", contact);
            newEntry.put("Financing Value", financingValue);
            clientData.add(newEntry);

            try (FileWriter writer = new FileWriter(clientDataPath)) {
                writer.write(clientData.toJSONString());
                writer.flush();

            } catch (Exception e) {
                System.out.println(e);
                throw new InternalError();
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return "Successfully saved info.";
    }
}
