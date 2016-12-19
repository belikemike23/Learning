package com.imooc.io;

import java.io.IOException;

/**
 * Created by mike.wang on 2016/12/2.
 */
public class IOUtilTest {
    public static void main(String[] args) {
        try {
            IOUtil.printHex("E:\\test.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
