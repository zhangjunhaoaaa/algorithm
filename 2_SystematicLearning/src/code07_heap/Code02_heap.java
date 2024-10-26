package code07_heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//堆的应用
public class Code02_heap {

    public static void main(String[] args) {
        //小根堆
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        integers.add(6);

        System.out.println(integers.peek());//第一个数是谁。 1
        System.out.println(integers.poll());//弹出。1


        //创建小根堆的直接使用引用类型
        //自定义比较器
        //1.第一种写法
        PriorityQueue<Student> students = new PriorityQueue<>(new IdComparator() );
        //2.第二种写法
        students =new PriorityQueue<>((a,b)->a.id-b.id);
        //3.第三种写法
        students = new PriorityQueue<>((a,b)->b.id!=a.id?b.id-a.id:(a.hashCode()-b.hashCode()));
        //主要排序条件：比较 id 字段。
        //b.id != a.id 检查两个元素的 id 是否不同。
        //b.id - a.id 用于根据 id 字段进行降序排序（b.id 减 a.id，这样 id 较大的元素会排在前面）。
        //次要排序条件：如果 id 相同，则根据 hashCode 进行排序。
        //(a.hashCode() - b.hashCode()) 通过元素的 hashCode 字段进行升序排序。
        Student student0 = new Student(1, "1", 1);
        Student student1 = new Student(2, "2", 2);
        Student student2 = new Student(3, "3", 3);
        Student student3 = new Student(4, "4", 4);
        Student student4 = new Student(5, "5", 5);
        Student student5 = new Student(6, "6", 6);

         students.add(student0);
         students.add(student1);
         students.add(student2);
         students.add(student3);
         students.add(student4);
         students.add(student5);

        //根据年龄进行排序，不然没法排序
        while (!students.isEmpty()) {
            System.out.println(students.poll());
        }



        //String 是字典序
        String a ="jsdfs";
        String b ="sdfsgsg";
        System.out.println(a.compareTo(b));
        //1.长度一样，直接比较
        //2.长度不一样，先把短的补齐，然后把后面的 补 0



    }





    //比较器
    //小根堆跟大根堆就是在这里 前后的位置换一下即可
    public static class IdComparator implements Comparator<Student> {

        //如果结果为负数，则 1 排在前
        //如果结果为正数，则 2 排在前
        @Override
        public int compare(Student o1,Student o2) {
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

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }


}
