package com.houarizegai.xmlvsjson.engine.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.houarizegai.xmlvsjson.engine.model.Employee;
import com.houarizegai.xmlvsjson.global.Utils;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    public static List<Employee> parseJSON(String file) {
        List<Employee> employees = null;

        String json = Utils.readStringFromFile(file);
        try {
            JSONArray features = new JSONArray(json);
            employees = new Gson().fromJson(String.valueOf(features), new TypeToken<ArrayList<Employee>>(){}.getType());

        } catch (JSONException e) {
            System.out.println("ParsingError: Problem parsing JSON data, " + e);
        }

        return employees;
    }
}
