package br.com.crudproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.crudproject.controller.request.EmployeeRequestDto;
import br.com.crudproject.controller.response.EmployeeResponseDto;
import br.com.crudproject.model.Employee;
import br.com.crudproject.service.EmployeeService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public void save(@RequestBody @Valid EmployeeRequestDto employeeRequestDto) {
		employeeService.save(employeeRequestDto);
	}

	@GetMapping
	public ResponseEntity<List<EmployeeResponseDto>> buscarEmployees(EmployeeResponseDto dto) {
		return ResponseEntity.ok(employeeService.findEmployees());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> buscarEmployeeById(@PathVariable Long id) {
		return ResponseEntity.ok(employeeService.buscarEmployeeById(id));
	}
	

	@PutMapping
	public ResponseEntity<Void> updateEmployee (@RequestBody @Valid Employee employee) {
		employeeService.updateEmployee(employee);
		return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deletebyId(@PathVariable Long id){
	employeeService.deleteById(id);
	 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
