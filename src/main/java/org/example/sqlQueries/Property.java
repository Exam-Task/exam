package org.example.sqlQueries;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Property {

    public static void createProperty() {

        try (OutputStream output = new FileOutputStream("src/main/resources/config.properties")) {
            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("db.url", "jdbc:postgresql://localhost:5432/questions");
            prop.setProperty("db.user", "postgres");
            prop.setProperty("db.password", "postgres");

            // save properties to project root folder
            prop.store(output, null);

        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static List<String> getProperty() {
        List<String> configs = new ArrayList<>();
        try (InputStream input = new FileInputStream("src/main/resources/config.properties")) {

            Properties prop = new Properties();
            // load a properties file
            prop.load(input);

            // get the property value and print it out
            configs.add(prop.getProperty("db.url"));
            configs.add(prop.getProperty("db.user"));
            configs.add(prop.getProperty("db.password"));

            return configs;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}


