package com.studentApp;

public class Main {

	public static void main(String[] args) {
		System.out.println(" *** Student Managemnet System ***");
		
		Student s1;
		s1= new Student("PL", 35, "S-1");
		s1.enrollCourse("java");
	//	s1.enrollCourse("java"); so in the program student able to enroll to the same course multiple times which is not good so we need to add some validations
		s1.enrollCourse("javascript");
		s1.enrollCourse("DSA");
		//System.out.println(s1);
		s1.printStudentInfo();
		
		Student s2 = new Student("tiki", 22, "S-2");
		s2.enrollCourse("python");
		//s2.enrollCourse("DSA");
		//System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("AMLA", 22, "S-3");
		s3.enrollCourse("python");
		s3.enrollCourse("DSA");
		//System.out.println(s3);
		s3.printStudentInfo();

	}

}
