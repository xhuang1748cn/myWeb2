package cn.srn.web2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by Winter on 2016/4/18.
 */
public class PropFileReader {

    private static Logger logger = LoggerFactory.getLogger(PropFileReader.class);
    private Properties pps;

    public PropFileReader(InputStream file) {
        pps = new Properties();
        try {
            pps.load(new InputStreamReader(file, "UTF-8"));
        } catch (Exception e) {
            logger.error("read file(" + file.toString() + ") fail!", e);
        }
    }

    public String getStringProperty(String name, String defaultValue) {
        try {
            return pps.getProperty(name, defaultValue);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public int getIntegerProperty(String name, int defaultValue) {
        try {
            return Integer.parseInt(pps.getProperty(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public long getLongProperty(String name, long defaultValue) {
        try {
            return Integer.parseInt(pps.getProperty(name));
        } catch (Exception e) {
            return defaultValue;
        }
    }
}
