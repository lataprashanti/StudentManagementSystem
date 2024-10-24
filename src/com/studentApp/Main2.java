package com.studentApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	private static List<Student> studentList;
	
	public static void main(String[] args) {
		System.out.println(" *** Student Managemnet System ***");
		studentList=new ArrayList<Student>();
		
		
		Student s1;
		s1= new Student("PL", 35, "S-1");
		s1.enrollCourse("java");

		Student s2 = new Student("tiki", 22, "S-2");
		s2.enrollCourse("python");

		
		Student s3 = new Student("AMLA", 22, "S-3");
		s3.enrollCourse("python");
		
		// adding the student object to list
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		Student result = findStudentById("S-10");
		System.out.println("result " +result);
		
		sortByName();
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
