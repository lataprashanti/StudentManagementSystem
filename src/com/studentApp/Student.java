package com.studentApp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
	private String name;
	private int age;
	private String studentID;
	private List<String> courses;
	
	public Student(String name, int age, String studentID) {
		super();
		if(checkAge(age) && validateName(name) && validateStudentID(studentID))
		{
		this.name = name;
		this.age = age;
		this.studentID = studentID;
		courses = new ArrayList<String>(); 
		// initialization of courses, as Courses is a list we can't create an object of interface,
		// list implements Array list so we created the object using Arraylist
		}
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentID() {
		return studentID;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void enrollCourse(String course) {
		if( validateCourses(course)) {
		if(courses.contains(course)) {
			System.err.println("Already enrolled to the course" + " "+course);
		}
		else {
		courses.add(course);
		System.out.println("Student is enrolled to the course "  + course +  "  successfully");
		}
		}
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentID=" + studentID + ", courses=" + courses + "]";
	}

	public void printStudentInfo() {
		System.out.println("----- Students Information ----");
		System.out.println("Here is the student information");
		System.out.println("Student Name :" + " "+ name);
		System.out.println("Student Age :" + age);
		System.out.println("Student ID :" + studentID);
		System.out.println("Courses Name :" + courses);
		
	}
	
	//validation method, age should be between 19 to 35
	public boolean checkAge(int age) {
		if(age >= 19 && age <= 35) {
			return true;
		}
		else
			System.err.println("The age criteria is not satisfying");
			return false;
	}
	
	// validation method for Name
	public boolean validateName(String name) {
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern =Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if(nameMatcher.matches()) {
			return true;
		}
		else
			System.err.println("Invalid Name !! please enter alphabates only");
		return false;	
	}
	
	// validation method for studentID
	public boolean validateStudentID(String studentID) {
		String studentIdRegex = "S-[0-9]+$"; // we can use \\d instead [0-9] also
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentID);
		if(studentIdMatcher.matches()) {
			return true;
		}
		else
			System.err.println("Invalid StudentID, user the format S-1");
			return false;
		
}
	// Validation method for Courses
		public boolean validateCourses(String course) {
			if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Javascript") || course.equalsIgnoreCase("python")) {
				return true;
			}
			else
			
				System.err.println("please enter valid course name as per the list" + "[Java,Javascript,python]");
			
			return false;
			
		}
	
}

