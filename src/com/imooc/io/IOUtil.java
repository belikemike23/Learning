package com.imooc.io;

import java.io.*;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by mike.wang on 2016/12/2.
 */
public class IOUtil {
    /*
    * 读取指定文件内容，按照16进制输出到控制台
    * @param FileName
    * */
    public static void printHex(String fileName) throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        int i = 1;
        int b;
        while ((b=in.read())!=-1){
            if(b<0xf){
                out.print("0");
            }
            out.print(Integer.toHexString(b)+" ");
            if(i++%10==0){
                out.println();
            }
        }
        in.close();
    }

    public static void printHexByByteArray(String fileName) throws IOException{
        FileInputStream in = new FileInputStream(fileName);
        byte[] buf = new byte[10*1024];
        int bytes;
        int j = 1;
        while ((bytes= in.read(buf,0,buf.length))!=-1){
        for(int i=0;i<bytes;i++){
            out.print(Integer.toHexString(buf[i]&0xff)+" ");
            if(j++%10==0){
                out.println();
            }
        }
    }
        in.close();
    }

    public static void  copyFile(File srcFile,File desFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件"+srcFile+"不存在" );
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException("文件"+srcFile+"不是文件" );
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(desFile);
        byte[] buf = new  byte[10*1024];
        int bytes;
        while ((bytes = in.read(buf,0,buf.length))!= -1 ){
            out.write(buf,0,bytes);
            out.flush();
        }
        in.close();
        out.close();
    }

    public static void copyFileByByte(File srcFile,File desFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件"+srcFile+"不存在" );
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException("文件"+srcFile+"不是文件" );
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(desFile);
        int bytes;
        while ((bytes = in.read())!= -1 ){
            out.write(bytes);
            out.flush();
        }
        in.close();
        out.close();
    }

    public static void copyFileByBuffer(File srcFile,File desFile) throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件"+srcFile+"不存在" );
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException("文件"+srcFile+"不是文件" );
        }
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(desFile));
        int bytes;
        while ((bytes = bis.read())!= -1 ){
            bos.write(bytes);
            bos.flush();
        }
        bis.close();
        bos.close();
    }
}
