package com.imooc.io;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mike.wang on 2016/12/13.
 */
public class FileReaderAndWriter {
    public static void main(String[] args) throws IOException{
        FileReader fileReader = new FileReader("e:\\test.txt");
        char[] buffer = new char[2000];
        int c;
        while ((c = fileReader.read(buffer,0,2000))!=-1){
            String string = new String(buffer,0,c);
            System.out.println(string);
        }
    }
}
