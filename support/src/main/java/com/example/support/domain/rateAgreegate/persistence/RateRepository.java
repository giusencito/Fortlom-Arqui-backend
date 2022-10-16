package com.example.support.domain.rateAgreegate.persistence;




import com.example.support.domain.rateAgreegate.entity.Rate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RateRepository extends JpaRepository<Rate,Long> {
    List<Rate> findByArtistid(Long artistid);
    List<Rate> findByFanaticid(Long fanaticId);
    boolean existsByArtistidAndFanaticid(Long artistid,Long fanaticId);
    List<Rate> findByArtistidAndReview(Long artistid,Float review);
    List<Rate> findByArtistidAndFanaticid(Long artistid,Long fanaticId);

}
