package com.fortlom.forum.domain.ForumAggregate.persistence;
import com.fortlom.forum.domain.ForumAggregate.entity.Forum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ForumRepository extends JpaRepository<Forum,Long>{

    List<Forum> findByUserid(Long userId);
    boolean existsById(Long userId);
}
