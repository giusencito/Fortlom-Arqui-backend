package com.fortlom.administration.interfaces.controllers;

import com.fortlom.administration.domain.adminAgreegate.entity.Admin;
import com.fortlom.administration.domain.adminAgreegate.service.AdminService;
import com.fortlom.administration.interfaces.dto.Admin.AdminResource;
import com.fortlom.administration.interfaces.dto.Admin.CreateAdminResource;
import com.fortlom.administration.interfaces.mapping.entity.AdminMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/administrationservice")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/admins/{adminId}")
    public ResponseEntity<AdminResource> getById(@PathVariable Long adminId) {

        return ResponseEntity.ok(mapper.toResource(adminService.getById(adminId)));

    }
    @PostMapping("/admins")
    public ResponseEntity<AdminResource> createForum(@RequestBody CreateAdminResource request) {
        Admin admin = mapping.map(request, Admin.class);
        return ResponseEntity.ok(mapping.map(adminService.create(admin), AdminResource.class));
    }
}