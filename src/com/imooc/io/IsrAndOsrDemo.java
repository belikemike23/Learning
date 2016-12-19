package com.imooc.io;

import java.io.*;

/**
 * Created by mike.wang on 2016/12/7.
 */
public class IsrAndOsrDemo {
    public static void main(String[] args) throws IOException{
        FileInputStream fis = new FileInputStream("e:\\test.txt");
        InputStreamReader isr = new InputStreamReader(fis,"gbk");
        FileOutputStream fos = new FileOutputStream("e:\\test2.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");
/*        int a;
        while ((a = isr.read())!= -1){
            System.out.print((char)a);
        }*/
        char[] buffer = new char[8*1024];
        int c;
        while ((c = isr.read(buffer,0,buffer.length))!=-1){
            String s = new String(buffer,0,c);
            System.out.print(s);
            osw.write(buffer,0,c);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
