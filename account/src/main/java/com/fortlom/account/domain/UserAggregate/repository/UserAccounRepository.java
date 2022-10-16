package com.fortlom.account.domain.UserAggregate.repository;

import com.fortlom.account.domain.UserAggregate.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccounRepository extends JpaRepository<UserAccount,Long>{
    Optional<UserAccount> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<UserAccount> findByUsernameOrEmail(String username,String email);

    Optional<UserAccount> findByTokenpassword(String tokenpassword);

   boolean existsById(Long id);
}
