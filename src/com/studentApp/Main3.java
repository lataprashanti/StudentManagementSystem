package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

private static List<Student> studentList;
	
	public static void main(String[] args) {
		System.out.println(" *** Student Managemnet System ***");
		studentList=new ArrayList<Student>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the Student name");
		String name = sc.next();
		System.out.println("Name is " + name);
		
		System.out.println("Enter Student Age");
		int age = sc.nextInt();
		System.out.println("Age is " + age);
		
		
		
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
		//System.out.println(studentList);
		
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
