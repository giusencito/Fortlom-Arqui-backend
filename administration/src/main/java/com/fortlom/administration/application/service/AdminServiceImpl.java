package com.fortlom.administration.application.service;

import com.fortlom.administration.application.exception.ResourceNotFoundException;
import com.fortlom.administration.domain.adminAgreegate.entity.Admin;
import com.fortlom.administration.domain.adminAgreegate.persistence.AdminRepository;
import com.fortlom.administration.domain.adminAgreegate.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validator;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {


    private static final String ENTITY = "Admin";

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public Admin getById(Long adminId) {
        return adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException(ENTITY, adminId));
    }

    @Override
    public Admin create(Admin admin) {


        return  adminRepository.save(admin);
    }
}
