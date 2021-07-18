package com.sealab.department.controller;

import com.sealab.department.entity.Department;
import com.sealab.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("Inside save Department method");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{departmentId}")
    public Department findDepartmentById(@PathVariable("departmentId") Long departmentId){
        log.info("Inside find Department method");
        return departmentService.findDepartmentById(departmentId);
    }

}
