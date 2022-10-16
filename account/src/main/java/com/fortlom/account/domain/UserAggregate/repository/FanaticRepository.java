package com.fortlom.account.domain.UserAggregate.repository;
import com.fortlom.account.domain.UserAggregate.entity.childentity.Artist;
import com.fortlom.account.domain.UserAggregate.entity.childentity.Fanatic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FanaticRepository extends JpaRepository<Fanatic,Long>{

    Optional<Fanatic> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String Usermail);
    boolean existsById(Long fanaticId);

    Optional<Fanatic> findByUsernameOrEmail(String username,String email);

    Optional<Fanatic> findByRealnameAndLastname(String realname,String lastname);
}
