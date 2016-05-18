package cn.srn.web2;

/**
 * Created by Winter on 2016/4/14.
 */
public class ConvertUtil {

    public static long strToLong(String value) {
        return strToLong(value, 10, 0);
    }

    public static long strToLong(String value, int radix) {
        return strToLong(value, radix, 0);
    }

    public static long strToLong(String value, long defaultValue) {
        return strToLong(value, 10, defaultValue);
    }

    public static long strToLong(String value, int radix, long defaultValue) {
        try {
            return Long.parseLong(value, radix);
        } catch (Exception e) {
            return defaultValue;
        }

    }

    public static int strToInteger(String value) {
        return strToInteger(value, 10, 0);
    }

    public static int strToInteger(String value, int defaultValue) {
        return strToInteger(value, 10, defaultValue);
    }

    public static int strToInteger(String value, int radix, int defaultValue) {
        try {
            return Integer.parseInt(value, radix);
        } catch (Exception e) {
            return defaultValue;
        }

    }
}
