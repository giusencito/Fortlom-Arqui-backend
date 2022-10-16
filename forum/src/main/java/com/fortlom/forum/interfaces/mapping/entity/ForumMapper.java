package com.fortlom.forum.interfaces.mapping.entity;
import com.fortlom.forum.domain.ForumAggregate.entity.Forum;
import com.fortlom.forum.interfaces.dto.Forum.CreateForumResource;
import com.fortlom.forum.interfaces.dto.Forum.ForumResource;
import com.fortlom.forum.interfaces.dto.Forum.UpdateForumResource;
import com.fortlom.forum.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class ForumMapper {


    @Autowired
    EnhancedModelMapper mapper;



    public ForumResource toResource(Forum model) {
        return mapper.map(model, ForumResource.class);
    }

    public Page<ForumResource> modelListToPage(List<Forum> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumResource.class), pageable, modelList.size());
    }
    public Forum toModel(CreateForumResource resource) {
        return mapper.map(resource, Forum.class);
    }

    public Forum toModel(UpdateForumResource resource) {
        return mapper.map(resource, Forum.class);
    }
}
