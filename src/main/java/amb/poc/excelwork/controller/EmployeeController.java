package amb.poc.excelwork.controller;

import amb.poc.excelwork.entity.Employee;
import amb.poc.excelwork.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo repo;

    @GetMapping("/employee")
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @PostMapping("/employee")
    public Employee save(@RequestBody Employee employee) {
        return repo.save(employee);
    }
}
