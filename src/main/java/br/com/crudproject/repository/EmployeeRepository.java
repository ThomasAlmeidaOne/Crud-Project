package br.com.crudproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.crudproject.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
