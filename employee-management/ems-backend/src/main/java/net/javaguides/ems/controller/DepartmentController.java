package net.javaguides.ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems.dto.DepartmentDto;
import net.javaguides.ems.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
