package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.entity.Department;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

//    Build Add or create REST API
    @PostMapping
    public ResponseEntity<DepartmentDto>createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department,HttpStatus.CREATED);
    }

//    Build GET REST API
    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto>getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDto departmentDto=departmentService.getDepartmentBtId(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

//    Build getAll Departments REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDto>>getAllDepartments(){
      List<DepartmentDto>departments=departmentService.getAllDepartments();
      return ResponseEntity.ok(departments);
    }

//    Build updateDepartment REST API
    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>updateDepartment(@PathVariable("id") Long departmentId,
                                                         @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto departmentDto=departmentService.updateDepartment(departmentId,updatedDepartment);
        return ResponseEntity.ok(departmentDto);
    }

//    Build delete department REST API
    @DeleteMapping("{id}")
       public ResponseEntity<String>deleteDepartment(@PathVariable("id") Long departmentId){
       departmentService.deleteDepartment(departmentId);
       return ResponseEntity.ok("Department with the given id is deleted");
   }

  }
