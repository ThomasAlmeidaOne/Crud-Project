package br.com.crudproject.mapper;

import br.com.crudproject.controller.request.EmployeeAtualizacaoDto;
import br.com.crudproject.controller.request.EmployeeRequestDto;
import br.com.crudproject.controller.response.EmployeeResponseDto;
import br.com.crudproject.model.Employee;

public class EmployeeMapper {
	
	public static  Employee converterParaEmployee(EmployeeRequestDto dtoRequest) {
		Employee employee = new Employee();
		employee.setName(dtoRequest.getName());
		employee.setSalary(dtoRequest.getSalary());
		return employee;
	}
	public static Employee converterParaEmployee (EmployeeAtualizacaoDto dtoAtualizacaoRequest) {
		Employee employee  = new Employee();
		employee.setId(dtoAtualizacaoRequest.getId());
		employee.setName(dtoAtualizacaoRequest.getName());
		employee.setSalary(dtoAtualizacaoRequest.getSalary());
		return employee;
	}
	
	public static EmployeeResponseDto converterParaDto(Employee employee) {
		EmployeeResponseDto dtoResponse = new EmployeeResponseDto();
		dtoResponse.setId(employee.getId());
		dtoResponse.setName(employee.getName());
		dtoResponse.setSalary(employee.getSalary());
		return dtoResponse;
	}

}
