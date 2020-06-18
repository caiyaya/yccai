package com.server.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 */
public class DateUtils {

    /**
     * 获取传入日期所在月的第一天
     *
     * @param date
     * @return
     */
    public static Date getFirstDayDateOfMonth(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int first = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, first);
        return cal.getTime();
    }

    /**
     * 获取传入日期所在月的最后一天
     *
     * @param date
     * @return
     */
    public static Date getLastDayDateOfMonth(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return cal.getTime();
    }

    /**
     * 判断档期日期是否属于月末n天
     *
     * @param days 传入的最后多少天参数
     * @return false不属于
     * @return true属于
     */
    public static boolean getLastDays(int days) {
        boolean flag = false;
        String s = "";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String strDate = df.format(date);
        Calendar calendar = Calendar.getInstance();
        for (int i = 1; i <= days; i++) {
            //取当前月的下一个月
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DATE, 1);
            //取当前月的下一个月往前推i天
            calendar.add(Calendar.DATE, -i);
            Date theDate = calendar.getTime();
            s = df.format(theDate);
            System.out.println(s);
            //strDate为当前日期
            if (strDate.equals(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

}
