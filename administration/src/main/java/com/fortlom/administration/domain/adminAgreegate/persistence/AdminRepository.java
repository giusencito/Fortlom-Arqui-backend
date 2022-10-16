package com.fortlom.administration.domain.adminAgreegate.persistence;


import com.fortlom.administration.domain.adminAgreegate.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {






}
