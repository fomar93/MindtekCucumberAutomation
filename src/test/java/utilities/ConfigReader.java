package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {

        FileInputStream input = null;
        properties = new Properties();
        String path = "/Users/fatima/IdeaProjects/MindtekCucumberAutomation/src/test/resources/configurations/Configuration.properties";
        try {
             input = new FileInputStream(path);
            properties.load(input);
        } catch (FileNotFoundException e) {
            System.out.println("Path for Properties file is invalid");
        } catch (IOException e) {
            System.out.println("Properties file could not load ");

        }finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String Key){
        return properties.getProperty(Key); // BlazedemoURL-Key---return https://blazedemo.com/index.php

    }
}