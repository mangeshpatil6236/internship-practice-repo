package com.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class StudentService {

	Scanner sc = new Scanner(System.in);
	private static int firstId = 101001;

	public void createStudent() {
		// TODO Auto-generated method stub

		System.out.println("Enter Name : ");
		String name = sc.next();

		System.out.println("Enter marks : ");
		double marks = sc.nextDouble();

		Student student = new Student(firstId++, name, marks);
		FileUtil.saveStudent(student);
	}

	public void viewStudent() {
		// TODO Auto-generated method stub

		ArrayList<Student> list = FileUtil.readStudents();

		if (list.isEmpty()) {
			System.err.println("No Student Found");
		}

		System.err.println("------------------------");
		System.out.println("id\tname\tmarks");
		System.err.println("------------------------");

		for (Student x : list) {
			System.out.println(x.getId() + "\t" + x.getName() + "\t" + x.getMarks());
		}

	}

	public void updateStudent() {
		// TODO Auto-generated method stub

		ArrayList<Student> list = FileUtil.readStudents();

		System.out.println("Enter Student ID to Update : ");
		int id = sc.nextInt();

		boolean found = false;

		for (Student s : list) {
			if (s.getId() == id) {
				System.out.println("Enter new Name : ");
				String name = sc.next();

				System.out.println("Enter new Marks : ");
				double marks = sc.nextDouble();

				s.setName(name);
				s.setMarks(marks);

				found = true;

				break;
			}
		}

		if (found) {
			FileUtil.updateStudent(list);

			System.err.println("Student Update Successfully...");
		} else {
			System.err.println("Student Not Found !");
		}

	}

	public void deleteStudent() {
		// TODO Auto-generated method stub

		ArrayList<Student> list = FileUtil.readStudents();

		System.out.println("Enter Id for Delete : ");
		int id = sc.nextInt();

		boolean found = false;

		Iterator<Student> itr = list.iterator();

		while (itr.hasNext()) {

			Student s = itr.next();
			if (s.getId() == id) {
				itr.remove();
				found = true;
				break;
			}
		}

		if (found) {
			FileUtil.updateStudent(list);
			System.err.println("Student Delete Successfully");
		} else {
			System.out.println("Student Not Found !");
		}

	}

}
