package com.server.web;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Double丢失精确度问题解决
 */
@SpringBootTest
public class StringTest {
    public static void main(String[] args) throws ParseException {
//        double v = Double.parseDouble("23.7") + Double.parseDouble("0.9");
//        System.out.println(v);
        // 保留两位小数

//        double v = Double.parseDouble("30.10");
//        DecimalFormat df = new DecimalFormat("#.00");
//        String v1 = df.format(v);
//        System.out.println(v1);
//        DecimalFormat df = new DecimalFormat("#.00");

//    @Test
//    public void test() {
//        double v = Double.parseDouble("23.7");
//        double v1 = v + Double.parseDouble("0.9");
//        System.out.println(v1);
//    }
//        CourseBase courseBase = new CourseBase();
////        String companyId = courseBase.getCompanyId();
////        System.out.println(companyId);

//        StringBuilder s = new StringBuilder();
//        s.append("[n2]您本月爱看4G定向流量包201407 0元-可选包已使用0.00MB,爱玩4G定向流量包201407 0元-可选包已使用0.00MB,爱听4G定向流量包201407 0元-可选包已使用0.0MB,");
//        System.out.println(s);
//        String s = "saaaa，";
//        String str = s.substring(0, s.length() - 1);
//        System.out.println(str);
        List<Map<String,Object>> list= new ArrayList();
//        Map<String,Object> map = new HashMap<>();
//        Map<String,Object> map2 = new HashMap<>();
//        Map<String,Object> map3 = new HashMap<>();
//        Map<String,Object> map4 = new HashMap<>();
//        map.put("fileName","ID_report.month_.csv");
//        list.add(map);
//        map2.put("fileName","password_report");
//        list.add(map2);
//        map3.put("fileName","metrics_report.month_.csv");
//        list.add(map3);
//        map4.put("fileName","fault_report.month_.csv");
//        list.add(map4);
//        System.out.println(list);

        List<String> list1= new ArrayList();
        list1.add("ID_report.month_.csv");
        list1.add("password_report.csv");
        list1.add("metrics_report.month_.csv");
        list1.add("fault_report.month_.csv");
        if (CollectionUtils.isNotEmpty(list1)) {
            for (String s : list1) {
                Map<String,Object> map = new HashMap<>();
                map.put("fileName",s);
                list.add(map);
            }
        }
        System.out.println(list);
    }
}
