package org.logcod.lojajogos.config.util;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class DataSourceUtil {

    public static Date formatDataUtil() {
        Date databd = new Date(Calendar.getInstance().getTimeInMillis());
        return databd;
    }

    public static Calendar formatDataUtilCalendar(Date dateBD) {
        GregorianCalendar gc = new GregorianCalendar();
        if (Objects.nonNull(dateBD)) {
            gc.setTime(dateBD);
        } else {
            gc.setTime(new java.util.Date());
        }
        return gc;
    }

    public static String formatarDataViewCalendar(Calendar calendar) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        gregorianCalendar.setTime(calendar.getTime());
        String dataFormatView = format.format(gregorianCalendar.getTime());
        return dataFormatView;
    }

    public static String formatDataUtilView(Date dataBD) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dataView = format.format(dataBD);
        return dataView;
    }

    public static Integer configDataIntegerValue(String value) {
        try {

            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static double convertType(String value) {
        try {

            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
