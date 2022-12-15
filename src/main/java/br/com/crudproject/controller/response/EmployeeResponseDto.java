package br.com.crudproject.controller.response;

import lombok.Data;

@Data
public class EmployeeResponseDto {

	private Long id;
	
	private String name;
	
	private Double salary;
}
