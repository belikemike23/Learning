package com.imooc.io;

import java.io.IOException;
import java.io.SyncFailedException;

/**
 * Created by mike.wang on 2016/12/5.
 */
public class IOUtilTest2 {
    public static void main(String[] args) {
        try {
            long start = System.currentTimeMillis();
            IOUtil.printHexByByteArray("E:\\test.txt");
            //IOUtil.printHex("E:\\test.txt");
            System.out.println();
            long end = System.currentTimeMillis();
            System.out.println(end -  start);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
