package org.interview.task.okta.utils;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DataProviders {

    @DataProvider(name = "fileDataProvider")
    public Object[][] fileDataProvider() throws IOException {
        Properties properties = new Properties();
        FileInputStream in = new FileInputStream("src/main/resources/data.txt");
        properties.load(in);
        in.close();

        return new Object[][]{
                {
                        properties.getProperty("firstName"),
                        properties.getProperty("lastName"),
                        properties.getProperty("workEmail"),
                        properties.getProperty("phoneNumber"),
                        properties.getProperty("country"),
                        properties.getProperty("province")
                }
        };
    }
}

