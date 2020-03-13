package com.practice.automation.loadproperty;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperty {
    static Properties prop;
    static FileInputStream input;
    String projectPath = System.getProperty("user.dir");

    public String getProperty(String key){
        prop = new Properties();
        try{
            input = new FileInputStream(projectPath+"\\src\\test\\java\\com\\practice\\automation\\resorces\\propertyfiles\\config.properties");
            prop.load(input);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);

    }
}
