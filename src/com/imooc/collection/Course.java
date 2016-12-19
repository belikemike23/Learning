package com.imooc.collection;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by mike.wang on 2016/10/27.
 * 课程类
 */
public class Course {
    private String id;
    private String name;

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

/*    public void setCourses(Set courses) {
        this.courses = courses;
    }*/

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set getCourses() {
        return courses;
    }

    private Set courses;

    public Course(){};
    public Course(String id,String name){
        setId(id);
        setName(name);
        this.courses = new HashSet();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        return getName().equals(course.getName());

    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }

/*    @Override

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null)
            return false;
        if(!(obj instanceof Course))
            return false;
        Course course = (Course)obj;
        if(this.getName()==null){
            if(course.getName()==null)
                return true;
            else
                return false;
        }else {
            if(this.getName().equals(course.getName()))
                return true;
            else
                return false;
        }
    }*/
}
