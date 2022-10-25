package com.fortlom.administration.domain.adminAgreegate.persistence;


import com.fortlom.administration.domain.adminAgreegate.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {


    Optional<Admin> findByUsername(String username);



    Boolean existsByUsername(String username);

}
