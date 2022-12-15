package br.com.crudproject.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crudproject.controller.request.EmployeeRequestDto;
import br.com.crudproject.controller.response.EmployeeResponseDto;
import br.com.crudproject.mapper.EmployeeMapper;
import br.com.crudproject.model.Employee;
import br.com.crudproject.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
    EmployeeRepository employeeRepository;
	
	public void save(EmployeeRequestDto dtoRequest) {
		Employee employee = EmployeeMapper.converterParaEmployee(dtoRequest);
		employeeRepository.save(employee);
	}
	
	
	public java.util.List<EmployeeResponseDto> findEmployees(){
		return employeeRepository.findAll().stream().map(EmployeeMapper :: converterParaDto).collect(Collectors.toList());
}
	
	public Employee buscarEmployeeById(Long id) {
		 Optional<Employee>employee = employeeRepository.findById(id);
		 return employee.orElseThrow(() -> new RuntimeException("employee não encontrado"));
	}
	
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}
	

}