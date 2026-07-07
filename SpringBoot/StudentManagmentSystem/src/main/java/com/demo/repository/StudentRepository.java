 package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByDepartment(String department);

	Optional<Student> findByEmail(String email);

	List<Student> findByCity(String city);

	List<Student> findByMarksGreaterThan(Double marks);

	List<Student> findByMarksLessThan(Double marks);

	List<Student> findByCityAndDepartment(String city, String department);

	List<Student> findByNameStartingWith(String prefix);

	List<Student> findByNameEndingWith(String suffix);

	List<Student> findByMarksBetween(Double start, Double end);
}