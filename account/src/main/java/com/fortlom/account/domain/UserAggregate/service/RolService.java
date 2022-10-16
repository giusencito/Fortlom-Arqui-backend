package com.fortlom.account.domain.UserAggregate.service;

import com.fortlom.account.domain.UserAggregate.entity.Rol;
import com.fortlom.account.domain.UserAggregate.enumeration.Rolname;

import java.util.List;
import java.util.Optional;
public interface RolService {
    Optional<Rol> findByName(Rolname name);

    void seed();

    List<Rol> getAll();
}
