package br.com.crudproject.controller.request;

import lombok.Data;

@Data
public class EmployeeAtualizacaoDto {

	private Long id;
	
	private String name;
	
	private Double salary;
}
