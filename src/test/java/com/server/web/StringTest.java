package com.server.web;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@SpringBootTest
public class StringTest {
    public static void main(String[] args) {
//        double v = Double.parseDouble("23.7") + Double.parseDouble("0.9");
//        System.out.println(v);
//        DecimalFormat df = new DecimalFormat("#.00");
//        String v1 = df.format(v);
//        System.out.println(v1);
//
//        BigDecimal a1 = new BigDecimal("23.7");
//        BigDecimal a2 = new BigDecimal("0.9");
//        Double i = a1.add(a2).doubleValue();
//        System.out.println(i);
        String s = "";
        if(StringUtils.isEmpty(s)){
            System.out.println("111111111");
        }
    }

    @Test
    public void test() {
        double v = Double.parseDouble("23.7");
        double v1 = v + Double.parseDouble("0.9");
        System.out.println(v1);
    }

}
