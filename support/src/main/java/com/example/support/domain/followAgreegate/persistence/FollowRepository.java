package com.example.support.domain.followAgreegate.persistence;
import com.example.support.domain.followAgreegate.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FollowRepository extends JpaRepository<Follow,Long>{

    List<Follow> findByArtistid(Long artistid);
    List<Follow> findByFanaticid(Long fanaticId);
    boolean existsByArtistidAndAgree(Long artistid,boolean fanaticId);
    boolean existsByArtistidAndFanaticid(Long artistid,Long fanaticId);
    List<Follow>findByArtistidAndFanaticid(Long artistid,Long fanaticId);
    List<Follow> findByArtistidAndAgree(Long artistid,boolean fanaticId);
}
