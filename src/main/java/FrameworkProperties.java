import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkProperties {
    private String result = "";
    private InputStream inputStream;

    public String getProperty(String key) {
        try {
            Properties properties = new Properties();
            String propFileName = "framework.properties";
            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null)
                properties.load(inputStream);
            else throw new FileNotFoundException("The property file has not found");
            String propertyValue = properties.getProperty(key);
            this.result = propertyValue;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
