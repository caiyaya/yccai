package com.server.web;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileIOTest {


    @Test
    public void test() throws Exception {
        String encoding = "utf-8";
        String filePath = "E:/test.txt";
        File file = new File(filePath);
        if (file.isFile() && file.exists()) { //判断文件是否存在
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file), encoding);//考虑到编码格式
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                System.out.println(lineTxt);
            }
            read.close();
        } else {
            System.out.println("找不到指定的文件");
        }
    }


    /**
     * 逐行读取txt文件并写入到list实体类中
     */
    @Test
    public void readTxt() throws IOException {
        String paths = "E:/test.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(paths), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        int count = 0;
        List<TxtObject> list = new ArrayList<TxtObject>();
        while ((line = br.readLine()) != null) {
            TxtObject txt = new TxtObject();
            String[] arr = line.split("\\|");
            if (arr.length > 0) {
                txt.setName(arr[0]);
                txt.setAge(arr[1]);
                txt.setExt1(arr[2]);
                list.add(txt);
            }
            count++;
        }
        System.out.println(list);
        System.out.println("读取总条数：" + count + "||读取的list的长度" + list.size());
        isr.close();
    }

    @Data
    public static class TxtObject {
        String name;
        String age;
        String ext1;
    }
}