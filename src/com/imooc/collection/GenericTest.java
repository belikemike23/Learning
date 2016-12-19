package com.imooc.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mike.wang on 2016/10/28.
 * 尝试用泛型类存储待选课程
 */
public class GenericTest {
    public List<Course> courses;

    public GenericTest(){
        this.courses = new ArrayList<>();
    }

    public void testAdd(){
        Course course1 = new Course("1","工程制图");
        courses.add(course1);
        Course course2 = new Course("2","大学物理");
        courses.add(course2);
    }

    /*
    * 泛型集合可以添加泛型子类型的实例
    * */
    public void testChildAdd(){
        ChildCourse cc = new ChildCourse();
        courses.add(cc);
        cc.setId("3");
        cc.setName("我是子类型的对象实例");
        System.out.println();
    }

    /*
    * 泛型不能使用基本类型
    * */
    public void testBasicType(){
        List<Integer> list= new ArrayList<>();
        list.add(1);
        System.out.println("泛型中基本类型必须使用包装类:"+list.get(0));
    }

    public void testForeach(){
        for(Course course:courses){
            System.out.println("添加了课程"+ course.getId() +":" +course.getName());
        }
    }

    public static void main(String args[]){
        GenericTest gt = new GenericTest();
        gt.testAdd();
        gt.testForeach();
        gt.testChildAdd();
        gt.testForeach();
        gt.testBasicType();
    }
}
