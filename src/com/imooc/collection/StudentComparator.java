package com.imooc.collection;

import java.util.Comparator;

/**
 * Created by mike.wang on 2016/11/5.
 */
public class StudentComparator implements Comparator<Student> {
        @Override
    public int compare(Student object1,Student object2){
            return object1.getName().compareTo(object2.getName());
        }
}
