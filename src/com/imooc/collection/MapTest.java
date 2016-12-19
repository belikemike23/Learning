package com.imooc.collection;

import java.security.KeyStore;
import java.util.*;

/**
 * Created by mike.wang on 2016/10/28.
 */
public class MapTest {
    public Map<String,Student >students ;

    public MapTest(){
        this.students = new HashMap<>();
    }

    public void testPut(){

        Scanner console = new Scanner(System.in);
        int i =0;
        while (i<3){
            System.out.println("请输入学生id");
            String stuId = console.next();
            if(students.get(stuId)==null){
                System.out.println("请输入学生名字");
                String stuName = console.next();
                students.put(stuId,new Student(stuId,stuName));
                System.out.println("成功添加学生：" + students.get(stuId).getName());
                i++;
            }
            else {
                System.out.println("学生id已存在，请重新输入");
                continue;
            }
        }
    }

    public void testKeySet(){
        //使用set，存储map中所有key的值
        Set<String> keyset= students.keySet();
        System.out.println("总共有" + keyset.size() + "名学生");
        for (String string: keyset
             ) {
            Student st =  students.get(string);
            if(st!=null){
            System.out.println("学生" +st.getId()+":"+ st.getName());
        }
        }

    }

    public  void testRemove(){
        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("我被调用了一次");
            System.out.println("请输入需要删除的学生id");
            String stuId = console.next();
            if(students.get(stuId)==null){
                System.out.println("请输入正确的学生id");
                continue;
            }
            students.remove(stuId);
            System.out.println("已删除id为" + stuId +"的学生");
            testEntrySet();
            break;
        }
    }

    /*
    * 通过entryset方法来便利Map
    * */
    public void testEntrySet(){
        Set<Map.Entry<String,Student>> entrySet = students.entrySet();
        for (Map.Entry<String,Student> entry : entrySet
             ) {
            System.out.println("取得键为" + entry.getKey());
            System.out.println("取得值为" + entry.getValue().getName());
        }
    }

    public void testContainsKeyorValue(){
        System.out.println("请输入学生id");
        Scanner console = new Scanner(System.in);
        String stuId= console.next();
        System.out.println("您输入的学生id为：" +stuId +  "在学生映射表中是否存在："+students.containsKey(stuId) );
        System.out.println("请输入学生姓名");
        String stuName= console.next();
        Student student = new Student(null,stuName);
        System.out.println("您输入的学生姓名为：" +stuName +  "在学生映射表中是否存在："+students.containsValue(student) );
    }

    public  void testModity(){
        Scanner console = new Scanner(System.in);
        while(true){
            System.out.println("我被调用了一次");
            System.out.println("请输入需要修改的学生id");
            String stuId = console.next();
            if(students.get(stuId)==null){
                System.out.println("请输入正确的学生id");
                continue;
            }
            System.out.println("请输入要修改的名字");
            String name = console.next();
            Student newStudent = new Student(stuId,name);
            students.put(stuId,newStudent);
            System.out.println("已修改id为" + stuId +"的学生");
            testEntrySet();
            break;
        }
    }

    public static void main(String[] args) {
        MapTest mt = new MapTest();
        mt.testPut();
        mt.testKeySet();
        // mt.testRemove();
        //mt.testModity();
        mt.testContainsKeyorValue();
    }
}
