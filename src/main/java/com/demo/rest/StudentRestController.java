package com.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.StudentDto;
import com.demo.entity.Student;
import com.demo.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("student")
public class StudentRestController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<String> addStudent(@Valid @RequestBody StudentDto studentDto) {
		String msg = studentService.saveStudent(studentDto);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@GetMapping("/findbyid/{id}")
	public ResponseEntity<Student> findById(@PathVariable Integer id) {
		Student byId = studentService.findById(id);
		return new ResponseEntity<>(byId, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAll() {

		List<Student> allStudent = studentService.getAllStudent();
		return new ResponseEntity<>(allStudent, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		String msg = studentService.updateStudent(id, student);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {
		String msg = studentService.deletStudent(id);
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@GetMapping("findbyname")
	public ResponseEntity<List<Student>> findByName(@RequestParam String name) {
		List<Student> byName = studentService.findByName(name);
		return new ResponseEntity<>(byName, HttpStatus.OK);
	}

	@GetMapping("findbydep")
	public ResponseEntity<List<Student>> findByDep(@RequestParam String department) {
		List<Student> byDepartment = studentService.findByDepartment(department);
		return new ResponseEntity<>(byDepartment, HttpStatus.OK);
	}

	@GetMapping("findbyemail")
	public ResponseEntity<Student> findByEmail(@RequestParam String email) {
		Student byEmail = studentService.findByEmail(email);
		return new ResponseEntity<>(byEmail, HttpStatus.OK);
	}

	@GetMapping("findbycity")
	public ResponseEntity<List<Student>> searchByCity(@RequestParam String city) {
		List<Student> searchByCity = studentService.searchByCity(city);
		return new ResponseEntity<>(searchByCity, HttpStatus.OK);
	}

	// Pagination

	@GetMapping("/pagination")
	public ResponseEntity<Page<Student>> getAllStudents(@RequestParam(defaultValue = "0") int pageNo,
			@RequestParam(defaultValue = "4") int pageSize) {

		Page<Student> allStudents = studentService.getAllStudents(pageNo, pageSize);
		return new ResponseEntity<>(allStudents, HttpStatus.OK);
	}

	// filteration

	@GetMapping("/findbymarksgreaterthan")
	public ResponseEntity<List<Student>> findByMarksGreaterThan(@RequestParam Double marks) {
		List<Student> byMarksGreaterThan = studentService.findByMarksGreaterThan(marks);
		return new ResponseEntity<>(byMarksGreaterThan, HttpStatus.OK);
	}

	@GetMapping("/findbymarkslessthan")
	public ResponseEntity<List<Student>> findByMarksLessThan(@RequestParam Double marks) {
		List<Student> byMarksLessThan = studentService.findByMarksLessThan(marks);
		return new ResponseEntity<>(byMarksLessThan, HttpStatus.OK);
	}

	@GetMapping("/findbycityanddep")
	public ResponseEntity<List<Student>> findByCityAndDep(@RequestParam String city, @RequestParam String department) {
		List<Student> byCityAndDepartment = studentService.findByCityAndDepartment(city, department);
		return new ResponseEntity<>(byCityAndDepartment, HttpStatus.OK);
	}

	@GetMapping("/findnamestartwith")
	public ResponseEntity<List<Student>> findNameStartWith(@RequestParam String prefix) {

		List<Student> byNameStartingWith = studentService.findByNameStartingWith(prefix);
		return new ResponseEntity<>(byNameStartingWith, HttpStatus.OK);
	}

	@GetMapping("/findnameendwith")
	public ResponseEntity<List<Student>> findNameEndWith(@RequestParam String suffix) {

		List<Student> byNameEndingWith = studentService.findByNameEndingWith(suffix);
		return new ResponseEntity<>(byNameEndingWith, HttpStatus.OK);
	}

	@GetMapping("/findmarksbtw")
	public ResponseEntity<List<Student>> findByMarksBetween(@RequestParam Double start, @RequestParam Double end) {

		List<Student> marksBetween = studentService.findMarksBetween(start, end);
		return new ResponseEntity<>(marksBetween, HttpStatus.OK);
	}

	// Sorting

	@GetMapping("/sort")
	public ResponseEntity<List<StudentDto>> sortStudents(@RequestParam String field, @RequestParam String direction) {

		List<StudentDto> sortStudents = studentService.sortStudents(field, direction);
		return new ResponseEntity<>(sortStudents, HttpStatus.OK);
	}
}
