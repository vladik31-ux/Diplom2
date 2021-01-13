package com.example.diplom.Tests;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import com.example.diplom.Entity.Test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AssetTests {

    Context context;
    public AssetTests(Context context){
        this.context = context;
    }

    public ArrayList<Test> getAllTestByType(String type){
        ArrayList<Test> tests = new ArrayList<>();
        try {
            String file = getStringFromAssetFile(context, "tests");
            JSONArray testsJson = getTestsByType(file, type);
            for (int i = 0; i < testsJson.length(); i++) {
                Test test = new Test();
                test.setId(testsJson.getJSONObject(i).getInt("id"));
                test.setDescription(testsJson.getJSONObject(i).getString("description"));
                test.setName(testsJson.getJSONObject(i).getString("name"));
                test.setDuration(testsJson.getJSONObject(i).getString("duration"));
                test.setQuestions_count(testsJson.getJSONObject(i).getString("questions_count"));
                tests.add(test);
            }
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage() , Toast.LENGTH_SHORT).show();
        }
      return tests;
    }

    private JSONArray getTestsByType(String json, String type){
        JSONArray TestsByType;
        try{
            JSONObject obj = new JSONObject(json);
            TestsByType = obj.getJSONArray(type);
            return TestsByType;
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
            return null;
        }
    }


    public static String getStringFromAssetFile(Context context, String name)
    {
        AssetManager am = context.getAssets();
        String s  = "";
        try {
            InputStream is = am.open(name);
            s = convertStreamToString(is);
            is.close();
        }
        catch (Exception ex){
            Toast.makeText(context, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return s;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
