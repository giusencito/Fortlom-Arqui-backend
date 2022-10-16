package com.fortlom.forum.interfaces.controllers;

import com.fortlom.forum.domain.ForumAggregate.entity.Forum;
import com.fortlom.forum.domain.ForumAggregate.service.ForumService;
import com.fortlom.forum.interfaces.dto.Forum.CreateForumResource;
import com.fortlom.forum.interfaces.dto.Forum.ForumResource;
import com.fortlom.forum.interfaces.dto.Forum.UpdateForumResource;
import com.fortlom.forum.interfaces.mapping.entity.ForumMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin
@RequestMapping("/api/v1/forumservice")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @Autowired
    private ForumMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/forums")
    public Page<ForumResource> getAllForums(Pageable pageable) {
        return mapper.modelListToPage(forumService.getAllForums(), pageable);
    }
    @GetMapping("/forums/{forumId}")
    public ResponseEntity<ForumResource> getForumById(@PathVariable Long forumId) {

        return ResponseEntity.ok(mapper.toResource(forumService.getForumById(forumId)));

    }
    @GetMapping("/user/{usersId}/forums")
    public ResponseEntity<Page<ForumResource>> getAllForumsByusersId(@PathVariable Long usersId,Pageable pageable) {

        return ResponseEntity.ok(mapper.modelListToPage(forumService.getForumsByUserId(usersId), pageable));
    }
    @PostMapping("/user/{usersId}/forums")
    public ResponseEntity<ForumResource> createForum(@PathVariable Long usersId,@RequestBody CreateForumResource request) {
        Forum forum = mapping.map(request, Forum.class);
        return ResponseEntity.ok(mapping.map(forumService.createForum(usersId, forum), ForumResource.class));
    }
    @DeleteMapping("/forums/{forumId}")
    public ResponseEntity<?> deleteForum(@PathVariable Long forumId) {
        return forumService.deleteForum(forumId);
    }

    @GetMapping("/check/{forumId}")
    public boolean existforumid(@PathVariable("forumId") Long forumId){
        return forumService.existsforum(forumId);
    }
    @PutMapping("/chagetules/{forumId}")
    public ForumResource updateForum(@PathVariable Long forumId, @RequestBody UpdateForumResource request) {
        return mapper.toResource(forumService.UpdateRules(forumId, mapper.toModel(request)));
    }
}
