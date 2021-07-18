package com.sealab.user.service;

import com.sealab.user.VO.Department;
import com.sealab.user.VO.ResponseTemplateVO;
import com.sealab.user.entity.User;
import com.sealab.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {

        return userRepository.save(user);
    }

    public User getUserById(Long userId) {

        return userRepository.findByUserId(userId);
    }

    public ResponseTemplateVO getUserWithDepartmentById(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
    }
}
