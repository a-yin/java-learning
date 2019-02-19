package com.lingb.mystudy.algorithm.comparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * Created by lingb on 2018-12-10
 */
public class MyComparator {

    static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.getId() - o1.getId();
        }


    }

    static class IdAscendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId() - o2.getId();
        }
    }

    public static void printStudent(Student stu) {
        System.out.println(stu.toString());
        System.out.println("================================");
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println(student.toString());
            System.out.println("================================");
        }
    }


    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>(new IdAscendingComparator());
        pq.add(new Student(1, "aa", 4));
        pq.add(new Student(2, "bb", 5));
        pq.add(new Student(3, "cc", 6));

        printStudent(pq.poll());
        printStudent(pq.poll());
        printStudent(pq.poll());


        System.out.println();

        Student[] students = new Student[] {
                new Student(1, "aa", 4),
                new Student(2, "bb", 5),
                new Student(3, "cc", 6)
        };

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);


        System.out.println();

        TreeSet<Student> ts = new TreeSet<>(new IdDescendingComparator());
        ts.add(new Student(1, "aa", 4));
        ts.add(new Student(2, "bb", 5));
        ts.add(new Student(3, "cc", 6));

        printStudent(ts.pollFirst());
        printStudent(ts.pollLast());

    }


}
