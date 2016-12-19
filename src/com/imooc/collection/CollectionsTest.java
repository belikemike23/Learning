package com.imooc.collection;

import java.util.*;

/**
 * Created by mike.wang on 2016/11/2.
 */
public class CollectionsTest {


    /*
    * 对整型list进行排序
    * */
    public void testSort1(){
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        Integer k;
        for(int i = 0;i<10;i++){
            do{
                k = random.nextInt(100);
            }while (integerList.contains(k));
            integerList.add(k);
        }
        System.out.println("这是排序之前的list");
        for (Integer integer:integerList
             ) {
            System.out.println(integer);
        }
        System.out.println("这是排序之后的list");
        Collections.sort(integerList);
        for (Integer integer:integerList
                ) {
            System.out.println(integer);
        }
    }

    /*
    * 生成一个随机的字符
    * */
    public char generageChar(){
        Character[] charArray = new Character[52];
        for(int i =65;i<91;i++){
            charArray[i-65]=(char)i;
        }
        for(int i = 97;i<123;i++){
            charArray[i-71]=(char)i;
        }
        Random random = new Random();
        int i = random.nextInt(51);
        return charArray[i];
    }

    /*
    * List<String>中包含十个字符串，每个字符串的长度为10以内的整数，字符串中的字符随机可以重复
    * */
    public void testSort2(){
        List<String> stringList = new ArrayList<>();
        Random random = new Random();
        for(int i = 0 ;i<10 ;i ++){
            int length = random.nextInt(10);
            String string = null;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0;j <length ;j++){
                stringBuilder.append(generageChar());
            }
            string = stringBuilder.toString();
            stringList.add(i,string);
        }
        System.out.println("输出所生成的字符串"+"一共有"+stringList.size()+"个字符串");
        for (String string:stringList
             ) {
            System.out.println(string);
        }
        System.out.println("输出排序后的字符串");
        Collections.sort(stringList);
        for (String string:stringList
                ) {
            System.out.println(string);
        }
    }
        /*
        * 使用Compareto和comparator接口实现排序
        * */
        public void testSort3(){
            List<Student> studentList = new ArrayList<>();
            Random random = new Random();
            studentList.add(new Student(random.nextInt(120)+"","mike"));
            studentList.add(new Student(random.nextInt(120)+"","fury"));
            studentList.add(new Student(random.nextInt(120)+"","test"));
            System.out.println("---------------排序前---------------------");
            for (Student student:studentList
                 ) {
                System.out.println("学生:"+student.getId()+":"+student.getName());
            }
            Collections.sort(studentList);
            System.out.println("---------------排序后---------------------");
            for (Student student:studentList
                    ) {
                System.out.println("学生"+student.getId()+":"+student.getName());
            }
            Collections.sort(studentList,new StudentComparator());
            System.out.println("---------------按照姓名排序后---------------------");
            for (Student student:studentList
                    ) {
                System.out.println("学生"+student.getId()+":"+student.getName());
            }
        }
    public static void main(String[] args) {
        CollectionsTest ctest = new CollectionsTest();
        //ctest.testSort1();
        //ctest.generageChar();
        //ctest.testSort2();
        ctest.testSort3();
    }
}
