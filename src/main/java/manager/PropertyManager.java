package manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Properties;

public class PropertyManager {

    private static Properties properties;
    private static PropertyManager propertyManager = new PropertyManager();

    static{
        properties = new Properties();
        try {
            properties.load(new
                    FileReader("src/test/config/application.properties"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load Properties file .");
        }
    }

    private PropertyManager() {

    }
    public static PropertyManager getInstance()
    {
        return propertyManager;
    }

        public Object getProperty(String propertyName)
        {
            if(Objects.isNull(propertyName) || propertyName.isEmpty() || propertyName.isBlank())
            {
                throw new RuntimeException("Property name cannot be null or empty...Please pass a valid property name.");
            }
            try {
                return properties.get(propertyName);
            }catch (Exception e)
            {
                throw new RuntimeException("Invalid Property Name "+propertyName);
            }
        }

}
