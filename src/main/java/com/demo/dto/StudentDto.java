package com.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentDto {

	@NotBlank(message = "Name is Required")
	private String name;

	@NotBlank(message = "Email is Required")
	private String email;

	@NotBlank(message = "Department is Required")
	private String department;

	@NotBlank(message = "City is Required")
	private String city;

	@NotBlank(message = "Mobile No is Required")
	private String mobile;

	@NotNull(message = "Marks is Required")
	private Double marks;
}
