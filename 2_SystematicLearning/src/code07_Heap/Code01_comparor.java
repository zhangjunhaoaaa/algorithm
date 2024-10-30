package code07_Heap;

import java.util.Arrays;
import java.util.Comparator;


//比较器
//1.比较器的实质就是重载比较运算符
//2.比较器可以很好的应用在特殊标准的排序上
//3.比较器可以很好的应用在特殊标准排序的结构上
//4.写代码变得异常容易，还用于范性编程
public class Code01_comparor {


    public static void main(String[] args) {

        Student student0 = new Student(1, "1", 1);
        Student student1 = new Student(2, "2", 2);
        Student student2 = new Student(3, "3", 3);
        Student student3 = new Student(4, "4", 4);
        Student student4 = new Student(5, "5", 5);
        Student student5 = new Student(6, "6", 6);

        Student [] students = {student0,student1,student2, student3,student4,student5};

        //根据年龄进行排序，不然没法排序
        Arrays.sort(students,new IdComparator());



    }





    //比较器
    //自己规定了如何比大小
    public static class IdComparator implements Comparator<Student> {

        //如果结果为负数，则 1 排在前
        //如果结果为正数，则 2 排在前
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.id > o2.id) {
                return 1;
            }else if (o1.id < o2.id) {
                return -1;
            }else {
                return 0;
            }

        }
    }


    public static class Student {
        int id;
        String name;
        int age;
        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
    }



}