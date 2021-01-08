//package com.server.web;
//
////import ch.ethz.ssh2.*;
//import ch.ethz.ssh2.Connection;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Vector;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class FtpTest {
//    @Test
//    public void test() {
//        //创建远程连接，默认连接端口为22，如果不使用默认，可以使用方法
//        //new Connection(ip, port)创建对象
//        String ip = "10.0.8.1";
//        String usr = "root";
//        String pwd = "root";
//        //int port=22;
//        Connection conn = null;
//        String date = "";
//        //所要查询的目录
//        String path = "";
//        ArrayList<String> filesNameList = new ArrayList<String>();
//        try {
//            //连接远程服务器
//            // 连接部署服务器
//            conn = new Connection(ip);
//            conn.connect();
//            //使用用户名和密码登录
//            boolean b = conn.authenticateWithPassword(usr, pwd);
//            if (!b) {
//                throw new IOException("Authentication failed.");
//            } else {
//                SFTPv3Client sft = new SFTPv3Client(conn);
//                Vector<?> v = sft.ls(path);
//                for (int i = 0; i < v.size(); i++) {
//                    SFTPv3DirectoryEntry s = new SFTPv3DirectoryEntry();
//                    s = (SFTPv3DirectoryEntry) v.get(i);
//                    //文件名
//                    String filename = s.filename;
//                    filesNameList.add(filename);
//                }
//            }
//            conn.close();
//        } catch (IOException e) {
//            System.err.printf("用户%s密码%s登录服务器%s失败！", usr, pwd, ip);
//            e.printStackTrace();
//        }
//
//        return filesNameList;
//
//    }
//}
