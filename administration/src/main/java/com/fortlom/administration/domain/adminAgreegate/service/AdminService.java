package com.fortlom.administration.domain.adminAgreegate.service;


import com.fortlom.administration.domain.adminAgreegate.entity.Admin;

public interface AdminService {

    Admin getById(Long adminId);
    Admin create(Admin admin);
}
