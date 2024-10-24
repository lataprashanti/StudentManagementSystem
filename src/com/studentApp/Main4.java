package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main4 {
private static List<Student> studentList;
private static Scanner sc1;
	
	public static void main(String[] args) {
		System.out.println(" *** Student Managemnet System ***");
		studentList=new ArrayList<Student>();
		sc1 = new Scanner(System.in);
		
		// ----------------
		while(true) {
		System.out.println("Select An Option");
		System.out.println("1. Register a student");
		System.out.println("2. Find student with Student ID");
		System.out.println("3. List all student info");
		System.out.println("4. List student info in sorted order");
		System.out.println("5. Exit");
		
		int option = sc1.nextInt();
		
		switch(option) {
		case 1:
		    enrollStudent(sc1);
		break;
		
		case 2:
			findStudentByid(sc1);
			break;
			
		case 3:
			printAllStudentsData();
			break;
			
		case 4:
			sortByName();
			break;
			
		case 5:
			exit();
			break;
			
		default : System.err.println("Invalid option selected, enter between 1 to 5");
			
		}
		}
		
	}
		
	private static void exit() {
		System.out.println("Exit from the application");
		System.exit(0);
		
	}

	private static void printAllStudentsData() {
		if(studentList.size()>0) {
		System.out.println("---- Print all students data ---");
		for(Student student: studentList) {
			student.printStudentInfo();
		}
		}
		else
		{
			System.err.println("Student list is emptys");
		}
		
		
	}

	private static void findStudentByid(Scanner sc1) {
		System.out.println("Enter the student id you want to find info");
		String studentID = sc1.next();
		
		Student studentFound = null;
		try {
			studentFound =studentList.stream().filter(student ->student.getStudentID().equalsIgnoreCase(studentID))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No data found"));
		}
		catch (RuntimeException e) {
			System.err.println("Student with id " + studentID + " not found ");
		}
		studentFound.printStudentInfo();
		
		
		
	}

	private static void enrollStudent(Scanner sc1) {
		System.out.println("enter student name");
		String name = sc1.next();
		System.out.println("Student Name is "+ name);
		
		System.out.println("enter student age");
		int age = sc1.nextInt();
		System.out.println("Student age is "+ age);
		
		System.out.println("enter student ID");
		String ID = sc1.next();
		System.out.println("Student ID is "+ ID);
		
		Student newStudent = new Student(name, age, ID);
		studentList.add(newStudent);
		
		while(true) {
		System.out.println("Enter the course to be enrolled... Type Done to exit");
		String courseName = sc1.next();
		if(courseName.equalsIgnoreCase("done")) {
			break;
		}
		newStudent.enrollCourse(courseName);
		}
		newStudent.printStudentInfo();
		
	}

	private static void sortByName() {
		Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName()); //lambda expression
				/*
				 * new Comparator<Student>() {
				 * 
				 * @Override public int compare(Student o1, Student o2) { return
				 * o1.getName().compareTo(o2.getName()); } };
				 */
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
		
	}

	private static Student findStudentById(String studentId) {
		Student result = null;
		try {
		result =studentList.stream().filter(x ->x.getStudentID().equalsIgnoreCase(studentId))
		.findFirst()
		.orElseThrow(()-> new RuntimeException("No data found"));
		}
		catch (RuntimeException e) {
			System.err.println("Student with id " + studentId + " not found ");
		}
		return result;
		
	}



}
