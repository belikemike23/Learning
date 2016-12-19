package com.imooc.io;

import java.io.Serializable;

/**
 * Created by mike.wang on 2016/12/13.
 */
public class Student implements Serializable{
        private String name;
        private int age;
        private String sex;

        public void setName(String name) {
            this.name = name;
        }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Student(String name, int age, String sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public void setAge(int age) {

            this.age = age;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getName() {
            return name;

        }

        public int getAge() {
            return age;
        }

        public String getSex() {
            return sex;
        }
    }
