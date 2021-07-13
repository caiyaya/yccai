//package com.server.web.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @author huangh
// * @description:
// * @date 2021/7/6
// */
//public class java8 {
//    //strem对list进行排序，reversed从大到小排序
////    List<CounterpartEnterprisePO> riskLabelSuitPOList = this.listByIds(reqVO.getId()).stream().sorted(Comparator.comparing(CounterpartEnterprisePO::getLastUpdateDate).reversed()).collect(Collectors.toList());
//    List<User> list = new ArrayList<>();
//    User user1 = new User("zhangsan", "beijing", 30);
//    User user2 = new User("zhangsan", "beijing", 40);
//    User user3 = new User("lisi", "shanghai", 35);
//    User user4 = new User("lisi", "shanghai", 28);
//    User user5 = new User("lisim", "shanghai", 32);
//        list.add(user1); list.add(user2);list.add(user3); list.add(user4);list.add(user5);
//        System.out.println("原始数据："+list);
//    //判断姓名是否有重复,练习使用java8的stream方法
//    //方法1. distinct, 直接比较大小，只知道是否有重复
//    List<String> collect1 = list.stream().map(User::getName).distinct().collect(Collectors.toList());
//        System.out.println(collect1.size()!=list.size()?"方法1-姓名有重复":"无重复");
//    //方法2.用户姓名计数
//    Map<Object, Long> collect2 = list.stream().collect(
//            Collectors.groupingBy(User::getName, Collectors.counting()));
//        System.out.println("姓名重复计数情况："+collect2);
//    //筛出有重复的姓名
//    List<Object> collect3 = collect2.keySet().stream().
//            filter(key -> collect2.get(key) > 1).collect(Collectors.toList());
//    //可以知道有哪些姓名有重复
//        System.out.println("方法2-重复的姓名 ： "+collect3);
//    //方法3，对重复的姓名保留计数
//    List<Map<String, Long>> collect4 = collect2.keySet().stream().
//            filter(key -> collect2.get(key) > 1).map(key -> {
//        Map<String, Long> map = new HashMap<>();
//        map.put((String) key, collect2.get(key));
//        return map;
//    }).collect(Collectors.toList());
//        System.out.println("方法3-重复的姓名及计数："+collect4);
//}
//
//class User {
//    private String name;
//    private String address;
//    private String age;
//}