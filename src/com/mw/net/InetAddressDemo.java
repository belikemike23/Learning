package com.mw.net;

import java.lang.reflect.Array;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by mike.wang on 2016/12/15.
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println("计算机名是： "+inetAddress.getHostName());
        System.out.println("计算机地址是： "+inetAddress.getHostAddress());
        byte[] bytes = inetAddress.getAddress();
        System.out.println("字节数组形式的IP是： " + Arrays.toString(bytes));
        System.out.println((byte)1920);
        InetAddress inetAddress1 = InetAddress.getByName("MIKE-WANG");
        System.out.println("计算机名是： "+inetAddress1.getHostName());
        System.out.println("计算机地址是： "+inetAddress1.getHostAddress());
    }
}
