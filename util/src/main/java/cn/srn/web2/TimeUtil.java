package cn.srn.web2;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Winter on 2016/4/27.
 */
public class TimeUtil {

    public static SimpleDateFormat timeFileName = new SimpleDateFormat("yyyyMMddHHmmss");

    public static int getYear() {
        Calendar now = Calendar.getInstance();
        return getYear(now);
    }

    public static int getYear(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }

    public static int getMonth() {
        Calendar now = Calendar.getInstance();
        return getMonth(now);
    }

    public static int getMonth(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDayOfMonth() {
        Calendar now = Calendar.getInstance();
        return getDayOfMonth(now);
    }

    public static int getDayOfMonth(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static String getTimeFileNameString(Calendar calendar) {
        return timeFileName.format(calendar.getTime());
    }

    public static String getTimeFileNameString(Date date) {
        return timeFileName.format(date);
    }
}
