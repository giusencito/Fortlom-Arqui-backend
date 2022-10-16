package com.fortlom.forum.domain.ForumAggregate.service;
import com.fortlom.forum.domain.ForumAggregate.entity.Forum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface ForumService {
    List<Forum> getAllForums();
    Page<Forum> getAllForums(Pageable pageable);
    Forum getForumById(Long ForumId);
    Forum createForum(Long userId,Forum Forum);
    List<Forum> getForumsByUserId(Long userId);
    ResponseEntity<?> deleteForum(Long forumId);
    boolean existsforum(Long forumId);
    Forum UpdateRules(Long forumId,Forum request);

}
