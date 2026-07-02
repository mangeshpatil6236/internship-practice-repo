package com.demo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StudentService ss = new StudentService();

		while (true) {
			System.out.println("""
					\n1. Add Student
					2. View Student
					3. Update Student
					4. Delete Student
					5. Exit
					""");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				ss.createStudent();
				break;

			case 2:
				ss.viewStudent();
				break;

			case 3:
				ss.updateStudent();
				break;

			case 4:
				ss.deleteStudent();
				break;

			case 5:
				System.exit(0);

			}
		}
	}
}
