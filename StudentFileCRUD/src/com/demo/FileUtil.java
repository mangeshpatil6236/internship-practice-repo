package com.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtil {

	public static void saveStudent(Student student) {
		// TODO Auto-generated method stub

		try {
			FileWriter fw = new FileWriter("student.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(student.toString());
			bw.newLine();
			System.err.println("Student Save Successfully...");
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<Student> readStudents() {
		// TODO Auto-generated method stub

		ArrayList<Student> list = new ArrayList<Student>();

		try {
			BufferedReader br = new BufferedReader(new FileReader("student.txt"));

			String line;

			while ((line = br.readLine()) != null) {
				String[] data = line.split(",");

				int id = Integer.parseInt(data[0].trim());

				String name = data[1].trim();

				double marks = Double.parseDouble(data[2].trim());

				Student student = new Student(id, name, marks);

				list.add(student);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		return list;
	}

	public static void updateStudent(ArrayList<Student> list) {
		// TODO Auto-generated method stub

		try {
			FileWriter fw = new FileWriter("student.txt");
			BufferedWriter bw = new BufferedWriter(fw);

			for (Student s : list) {
				bw.write(s.toString());
				bw.newLine();
			}

			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	 

}
