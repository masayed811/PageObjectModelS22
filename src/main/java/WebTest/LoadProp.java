package WebTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProp {


    static Properties prop;
    static FileInputStream input;
    static String fileName = "TestDataConfig.properties";
    static String fileLocatio = "src/test/Resources/TestData/";

    public String getProperty(String key) {
        prop = new Properties();
        try {
            input = new FileInputStream( fileLocatio + fileName );
            prop.load( input );
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty( key );

    }


}
