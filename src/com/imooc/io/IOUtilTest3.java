package com.imooc.io;

import java.io.File;
import java.io.IOException;

/**
 * Created by mike.wang on 2016/12/6.
 */
public class IOUtilTest3 {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
           // IOUtil.copyFile(new File("e:\\test.pdf"),new File("e:\\test1.pdf"));//52
            //IOUtil.copyFileByBuffer(new File("e:\\test.pdf"),new File("e:\\test1.pdf"));//1830
            IOUtil.copyFileByByte(new File("e:\\test.pdf"),new File("e:\\test1.pdf"));//3137
            long end = System.currentTimeMillis();
            System.out.println(end-start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

