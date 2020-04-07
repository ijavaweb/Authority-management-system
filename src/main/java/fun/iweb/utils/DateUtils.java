package fun.iweb.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String DateToString(Date date,String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        String s = sdf.format(date);
        return s;
    }
    public static Date StringToDate(String string,String patten) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        Date date = sdf.parse(string);
        return date;
    }
}
