 package com.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.exception.StudentNotFound;
import com.demo.repository.StudentRepository;
import com.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public String saveStudent(StudentDto studentDto) {

		Student s = new Student();

		s.setName(studentDto.getName());
		s.setEmail(studentDto.getEmail());
		s.setCity(studentDto.getCity());
		s.setDepartment(studentDto.getDepartment());
		s.setMarks(studentDto.getMarks());
		s.setMobile(studentDto.getMobile());

		studentRepo.save(s);

		return "Student Save Successfull...";
	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> all = studentRepo.findAll();
		return all;
	}

	@Override
	public String updateStudent(Integer id, Student student) {

		Optional<Student> byId = studentRepo.findById(id);
		if (byId.isPresent()) {
			Student existing = byId.get();

			existing.setName(student.getName());
			existing.setEmail(student.getEmail());
			existing.setCity(student.getCity());
			existing.setDepartment(student.getDepartment());
			existing.setMarks(student.getMarks());
			existing.setMobile(student.getMobile());

			studentRepo.save(existing);
			return "Student Update Successfully";
		}
		throw new StudentNotFound("Student Not Found with ID : " + id);
	}

	@Override
	public String deletStudent(Integer id) {

		if (studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return "Student Deleted Successfully....";
		}
		throw new StudentNotFound("Student Not Found with ID : " + id);
	}

	@Override
	public Student findById(Integer id) {
		Optional<Student> byId = studentRepo.findById(id);
		if (byId.isPresent()) {
			Student student = byId.get();
			return student;
		}
		throw new StudentNotFound("Student Not Found with ID : " + id);
	}

	@Override
	public List<Student> findByName(String name) {

		List<Student> byName = studentRepo.findByName(name);
		if (byName.isEmpty()) {
			throw new StudentNotFound("Student Not Found with Name : " + name);
		}
		return byName;
	}

	@Override
	public List<Student> findByDepartment(String department) {
		List<Student> byDepartment = studentRepo.findByDepartment(department);
		if (byDepartment.isEmpty()) {
			throw new StudentNotFound("Student Not Found with Department : " + department);
		}
		return byDepartment;
	}

	@Override
	public Student findByEmail(String email) {

		Optional<Student> byEmail = studentRepo.findByEmail(email);
		if (byEmail.isPresent()) {
			Student student = byEmail.get();
			return student;
		}

		throw new StudentNotFound("Student Not Found With Email : " + email);
	}

	@Override
	public List<Student> searchByCity(String city) {
		List<Student> byCity = studentRepo.findByCity(city);
		if (byCity.isEmpty()) {
			throw new StudentNotFound("Student Not Found with City : " + city);
		}
		return byCity;

	}

	@Override
	public Page<Student> getAllStudents(int pageNo, int pageSize) {

		PageRequest of = PageRequest.of(pageNo, pageSize);
		Page<Student> all = studentRepo.findAll(of);
		if (all.isEmpty()) {
			throw new StudentNotFound("Student Data is Empty !!");
		}
		return all;
	}

	@Override
	public List<Student> findByMarksGreaterThan(Double marks) {

		List<Student> byMarksGreaterThan = studentRepo.findByMarksGreaterThan(marks);
		if (byMarksGreaterThan.isEmpty()) {
			throw new StudentNotFound("Student Not found with greater than Marks : " + marks);
		}
		return byMarksGreaterThan;
	}

	@Override
	public List<Student> findByMarksLessThan(Double marks) {

		List<Student> byMarksLessThan = studentRepo.findByMarksLessThan(marks);
		if (byMarksLessThan.isEmpty()) {
			throw new StudentNotFound("Student Not found with less than Marks : " + marks);
		}
		return byMarksLessThan;
	}

	@Override
	public List<Student> findByCityAndDepartment(String city, String department) {

		List<Student> byCityAndDepartment = studentRepo.findByCityAndDepartment(city, department);
		if (byCityAndDepartment.isEmpty()) {
			throw new StudentNotFound("Student not found with city : " + city + " and department : " + department);
		}
		return byCityAndDepartment;
	}

	@Override
	public List<Student> findByNameStartingWith(String prefix) {

		List<Student> byNameStartingWith = studentRepo.findByNameStartingWith(prefix);
		if (byNameStartingWith.isEmpty()) {
			throw new StudentNotFound("Student not found starting name with : " + prefix);
		}
		return byNameStartingWith;
	}

	@Override
	public List<Student> findByNameEndingWith(String suffix) {

		List<Student> byNameEndingWith = studentRepo.findByNameEndingWith(suffix);
		if (byNameEndingWith.isEmpty()) {
			throw new StudentNotFound("Student not found ending name with : " + suffix);
		}
		return byNameEndingWith;
	}

	@Override
	public List<Student> findMarksBetween(Double start, Double end) {

		List<Student> byMarksBetween = studentRepo.findByMarksBetween(start, end);
		if (byMarksBetween.isEmpty()) {
			throw new StudentNotFound("Student not Found with marks between : " + start + " to " + end);
		}
		return byMarksBetween;
	}

	@Override
	public List<StudentDto> sortStudents(String field, String direction) {

		Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(field).descending() : Sort.by(field).ascending();

		List<Student> students = studentRepo.findAll(sort);

		List<StudentDto> list = new ArrayList<>();

		for (Student s : students) {
			StudentDto dto = new StudentDto();

			dto.setCity(s.getCity());
			dto.setDepartment(s.getDepartment());
			dto.setEmail(s.getEmail());
			dto.setMarks(s.getMarks());
			dto.setMobile(s.getMobile());
			dto.setName(s.getName());

			list.add(dto);
		}

		return list;
	}

}