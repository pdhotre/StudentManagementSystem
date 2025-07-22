package com.studentapp;

import java.util.*;

import static java.lang.System.exit;

public class Main3 {
    private static List<Student> studentList;
    private static Scanner scanner;

    public static void main(String []args){
        System.out.println("***************** Student Management System *****************");
        studentList = new ArrayList<Student>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("********************** Welcome **********************");
            System.out.println("Select an Option....");
            System.out.println("1. Register a Student");
            System.out.println("2. Find Student with studentID");
            System.out.println("3. List All Student Information");
            System.out.println("4. List Student Information in Sorted Order");
            System.out.println("5. Exit");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findByStudentId(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected!!.... Enter between 1 to 5");
            }
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter Student Name: ");
        String studentName = scanner.next();
        System.out.println("Enter Student Age: ");
        int studentAge = scanner.nextInt();
        System.out.println("Enter Student Id: ");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);
        while (true) {
            System.out.println("Enter the course to be enrolled: .... Type Done to exit");
            String courseName = scanner.next();
            if(courseName.equalsIgnoreCase("Done")){
                break;
            }
            newStudent.enrollCourse(courseName);
        }
        newStudent.printStudentInfo();

    }

    private static void exit() {
        System.out.println("Done");
        System.exit(0);
    }

    private static void printAllStudentData() {
        if(studentList.size()>0) {
            System.out.println("------------------- PRINT ALL STUDENT DATA -------------------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
        }
        else{
            System.err.println("Student List is empty. No Student record found");
        }
    }

    private static void findByStudentId(Scanner scanner) {
        Student studentFound = null;
        System.out.println("Enter the student id: ");
        String studentId = scanner.next();
        try {
            studentFound = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found!!!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID "+studentId+" not found!!");
        }
        studentFound.printStudentInfo();
    }

    private static void sortByName() {
        // Lambda Expression for below method
        // Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());
        Comparator<Student> studentNameComparator = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(studentList, studentNameComparator);
        printAllStudentData();
    }

    public static Student findByStudent(String studentId){
        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found!!!"));
        } catch (RuntimeException e) {
            System.err.println("Student with ID "+studentId+" not found!!");
        }
        return result;

    }
}
