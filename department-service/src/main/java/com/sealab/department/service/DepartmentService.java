package com.sealab.department.service;

import com.sealab.department.entity.Department;
import com.sealab.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("Inside save Department");
        return departmentRepository.save(department);
    }

    public Department findDepartmentById(long departmentId) {
        log.info("Inside find Department");
        return departmentRepository.findByDepartmentId(departmentId);
    }
}
