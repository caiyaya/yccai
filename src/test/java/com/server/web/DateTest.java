package com.server.web;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DateTest {

    @Test
    public void test() {
        boolean lastDays = getLastDays(3);
        System.out.println(lastDays);
    }
    @Test
    public void test1() throws ParseException {
        String s = "2020-11";
        SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
        Date parse = df.parse(s);
        String format = df.format(parse);
        System.out.println(format);
    }


    private static boolean getLastDays(int days) {
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
