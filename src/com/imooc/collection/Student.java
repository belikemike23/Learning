package com.imooc.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by mike.wang on 2016/10/27.
 * 学生类
 */
public class Student implements Comparable<Student>{
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        return getName().equals(student.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

    @Override
    public int compareTo(Student student){
        return this.getId().compareTo(student.getId());
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Course> courses;
    public Student(String id,String name){
        setId(id);
        setName(name);
        this.courses = new HashSet<>();
    }
}
