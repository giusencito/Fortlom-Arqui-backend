package com.fortlom.account.domain.UserAggregate.repository;
import com.fortlom.account.domain.UserAggregate.entity.Rol;
import com.fortlom.account.domain.UserAggregate.enumeration.Rolname;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    Optional<Rol> findByName(Rolname name);
    boolean existsByName(Rolname name);
}
