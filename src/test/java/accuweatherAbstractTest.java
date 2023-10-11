import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class accuweatherAbstractTest {
    static Properties properties = new Properties();
    private static InputStream configfile;
    private static String apiKey = properties.getProperty("apiKey");
    private static String baseUrl = properties.getProperty("baseUrl");

    @BeforeAll
    static void initTest() throws IOException {
        configfile = new FileInputStream("src/main/resources/accuweather.properties");
        properties.load(configfile);
        apiKey = properties.getProperty("apiKey");
        baseUrl = properties.getProperty("baseUrl");
    }

    public static String getApiKey() {
        return apiKey;
    }
    public static String getBaseUrl() {
        return baseUrl;
    }
}
