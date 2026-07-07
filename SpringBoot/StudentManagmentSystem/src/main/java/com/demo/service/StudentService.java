 package com.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.demo.dto.StudentDto;
import com.demo.entity.Student;

public interface StudentService {

	String saveStudent(StudentDto studentDto);

	List<Student> getAllStudent();

	Student findById(Integer id);

	String updateStudent(Integer id, Student student);

	String deletStudent(Integer id);

	List<Student> findByName(String name);

	List<Student> findByDepartment(String department);

	Student findByEmail(String email);

	List<Student> searchByCity(String city);

	Page<Student> getAllStudents(int pageNo, int pageSize);
	
	List<Student> findByMarksGreaterThan(Double marks);
	
	List<Student> findByMarksLessThan(Double marks);
	
	List<Student> findByCityAndDepartment(String city, String department);
	
	List<Student> findByNameStartingWith(String prefix);
	
	List<Student> findByNameEndingWith(String suffix);
	
	List<Student> findMarksBetween(Double start, Double end);
	
	List<StudentDto> sortStudents(String field, String direction);
}