package com.imooc.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by mike.wang on 2016/10/27.
 * 备选课程类
 */
public class ListTest {
//    用于存放备选课程的List
    public List coursesToSelect;

    public ListTest(){
        this.coursesToSelect = new ArrayList();
    }
/*
* 往List中添加课程
* */
    public void testAdd(){
        Course c1 = new Course("1","语文");
        coursesToSelect.add(c1);
        Course temp = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程" + temp.getId() + ":" + temp.getName());

        Course c2 = new Course("2","数学");
        coursesToSelect.add(0,c2);
        Course temp2 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程" + temp2.getId() + ":" + temp2.getName() +"在List的" +coursesToSelect.indexOf(temp2) + "位置。");

        Course c0 = new Course("1","语文");
        coursesToSelect.add(c1);
        Course temp0 = (Course) coursesToSelect.get(0);
        System.out.println("添加了课程" + temp.getId() + ":" + temp.getName());

        Course[] course ={new Course("3","英语"), new Course("4","物理")};
        coursesToSelect.addAll(Arrays.asList(course));
        Course temp3 = (Course) coursesToSelect.get(2);
        Course temp4 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程" + temp3.getId() + ":" + temp3.getName()+","+ temp4.getId() + ":" + temp4.getName());

        Course[] course2 ={new Course("5","体育"), new Course("6","化学")};
        coursesToSelect.addAll(2,Arrays.asList(course2));
        Course temp5 = (Course) coursesToSelect.get(2);
        Course temp6 = (Course) coursesToSelect.get(3);
        System.out.println("添加了两门课程" + temp5.getId() + ":" + temp5.getName()+","+ temp6.getId() + ":" + temp6.getName());
    }
    /*
    * 使用for循环输出可选课程
    * */
    public void testGet(){
        int size = coursesToSelect.size();
        System.out.println("通过for循环输出可选课程");
        for(int i = 0; i < size ;i++){
            Course course = (Course) coursesToSelect.get(i);
            System.out.println("课程" + course.getId() + course.getName());
        }
    }

    public void testIterator(){
        Iterator it = coursesToSelect.iterator();
        System.out.println("通过Iterator输出可选课程");
        while (it.hasNext()){
            Course course = (Course) it.next();
            System.out.println("课程" + course.getId() + course.getName());
        }
    }

    public void testForeach(){
        System.out.println("通过Foreach输出可选课程");
        for (Object course:coursesToSelect){
            System.out.println("课程" + ((Course)course).getId() + ((Course)course).getName());
        }
    }

    public  void testModify(){
        coursesToSelect.set(4,new Course("7","毛概"));
    }

    public  void testRemove(){
        System.out.println("即将删除4和5位置的课程");
        Course[] courses = {(Course) coursesToSelect.get(4),(Course)coursesToSelect.get(5)};
        coursesToSelect.removeAll(Arrays.asList(courses));
        testForeach();
    }
    public static void main(String args[]){
        ListTest lt = new ListTest();
        lt.testAdd();
        lt.testGet();
        lt.testIterator();
        lt.testForeach();
        lt.testModify();
        lt.testForeach();
        lt.testRemove();
    }
}
