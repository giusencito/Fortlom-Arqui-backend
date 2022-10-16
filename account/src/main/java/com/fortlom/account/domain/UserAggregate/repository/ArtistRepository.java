package com.fortlom.account.domain.UserAggregate.repository;


import com.fortlom.account.domain.UserAggregate.entity.childentity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Long> {

    Optional<Artist> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String Usermail);
    boolean existsById(Long artistId);
    Optional<Artist> findByUsernameOrEmail(String username,String email);

    Optional<Artist> findByRealnameAndLastname(String realname,String lastname);

}
