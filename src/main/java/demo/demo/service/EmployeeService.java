package demo.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.demo.repository.EmployeeRepository;
import demo.demo.model.EmployeeEntity;


// logger
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Service
public class EmployeeService {
    

        private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    // Constructor
    public EmployeeService () {
        System.err.println("EmployeeService Instance Initialized");
    } 
   

    // Methods

    public List<EmployeeEntity> getAllEmployees() {

        return employeeRepository.findAll();

    }

    public Optional<EmployeeEntity> getEmployeeById (Long id) {
        return employeeRepository.findById(id);
    }

    public EmployeeEntity createEmployee (EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

    
    public EmployeeEntity updateEmployee(Long id, EmployeeEntity employeeDetails) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));

      

        if (employeeDetails.getFirstName() != null) {
            employee.setFirstName(employeeDetails.getFirstName());
        }
        if (employeeDetails.getLastName() != null) {
            employee.setLastName(employeeDetails.getLastName());
        }
        if (employeeDetails.getEmail() != null) {
            employee.setEmail(employeeDetails.getEmail());
        }
      
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

  
}
