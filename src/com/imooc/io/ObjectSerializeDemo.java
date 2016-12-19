package com.imooc.io;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

import java.io.*;

/**
 * Created by mike.wang on 2016/12/13.
 */
public class ObjectSerializeDemo {
    public static void main(String[] args) throws Exception {
        String file = "test.txt";
//        Student student = new Student("mike",28,"male");
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//        objectOutputStream.writeObject(student);
//        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
        Student student = (Student)objectInputStream.readObject();
        System.out.println(student.toString());
        objectInputStream.close();
    }
}
