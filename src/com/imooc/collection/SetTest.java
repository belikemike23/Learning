package com.imooc.collection;

import java.util.*;

/**
 * Created by mike.wang on 2016/10/28.
 */
public class SetTest {
    public List<Course> coursesToSelect;

    private Scanner console;

    public Student student;
    public SetTest(){
        this.coursesToSelect = new ArrayList<>();
        this.console =new Scanner(System.in);
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

    public void testForeach() {
        System.out.println("通过Foreach输出可选课程");
        for (Course course : coursesToSelect) {
            System.out.println("课程" + (course).getId() + (course).getName());
        }
    }

    /*
    * 创建一个学生选课类
    * */
    public void creatStudentandSelectCourse(){
        student = new Student("1","Mike");
        System.out.println("欢迎"+student.getName()+ "选课。");
        Scanner consle = new Scanner(System.in);

        for(int i  = 0;i<3;i++){
            System.out.println("请输入课程id");
            String courseId = consle.next();
            for(Course course :coursesToSelect){
                if(courseId .equals(course.getId())){
                    student.courses.add(course);
                }
            }
        }
        System.out.println(student.getName()+"选择了");
        for (Course course:student.courses
             ) {
            System.out.println(course.getName());
        }
    }
    /*
    * 测试list的contains方法
    * */
    public void testListContains(){
        Course course = coursesToSelect.get(0);
        System.out.println("选出课程："+ course.getName());
        System.out.println("备选课程中是否包含所选课程"+course.getName() + coursesToSelect.contains(course));
        Course course1 = new Course(course.getId(),course.getName());
        System.out.println("新选出课程："+ course1.getName());
        System.out.println("备选课程中是否包含所选课程"+course1.getName() + coursesToSelect.contains(course1));
        Course course2 = new Course();
        System.out.println("请输入课程名称");
        course2.setName(console.next());
        System.out.println("重新选出课程："+ course2.getName());
        System.out.println("备选课程中是否包含所选课程"+course2.getName() + coursesToSelect.contains(course2));
        //通过indexOf方法取得元素的索引位置
        if(coursesToSelect.contains(course2)){
            System.out.println("课程:"+ course2.getName()+ "的索引位置为："+ coursesToSelect.indexOf(course2));
        }
    }

    /*
        * 测试Set的contains方法
     * */
    public  void testSetContains(){
        System.out.println("请输入已选课程名称");
        Course course = new Course();
        course.setName(console.next());
        System.out.println("新创建课程："+ course.getName());
        System.out.println("备选课程中是否包含所选课程"+course.getName() +","+student.courses.contains(course));
    }
    public static void main(String[] args) {
        SetTest st = new SetTest();
        st.testAdd();
        st.testForeach();
        st.testListContains();
        //st.creatStudentandSelectCourse();
        //st.testSetContains();
    }

}
