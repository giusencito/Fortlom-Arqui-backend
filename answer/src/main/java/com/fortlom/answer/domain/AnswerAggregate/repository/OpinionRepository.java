package com.fortlom.answer.domain.AnswerAggregate.repository;


import com.fortlom.answer.domain.AnswerAggregate.entity.childentity.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionRepository extends JpaRepository<Opinion,Long>{

    List<Opinion> findByUserid(Long Userid);
    List<Opinion>findByContentid(Long contentid);
    List<Opinion>findByAgree(boolean agree);
    List<Opinion>findByContentidAndAgree(Long contentid,boolean agree);
    List<Opinion>findByUseridAndContentid(Long Userid,Long contentid);
    boolean existsByContentidAndUserid(Long contentid,Long Userid);
}
