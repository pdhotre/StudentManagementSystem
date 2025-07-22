package com.studentapp;

public class Main {
    public static void main(String []args){
        System.out.println("***************** Student Management System *****************");
        System.out.println("********************** Welcome **********************");

        Student s1 = new Student("Kajal Shinde", 26, "S-11");

        s1.enrollCourse("Java");
        s1.enrollCourse("DevOps");
        s1.enrollCourse("DSA");
        s1.enrollCourse("C#");

        s1.printStudentInfo();
//        System.out.println(s1);

        Student s2 = new Student("Sanjay", 22, "S-12");
        s2.enrollCourse("Java");
        s2.printStudentInfo();

        Student s4 = new Student("Tom", 25, "S-10");
        s4.enrollCourse("DevOps");
        s4.printStudentInfo();



    }
}
