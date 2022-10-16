package com.fortlom.account.interfaces.mapping.entity;

import com.fortlom.account.domain.UserAggregate.entity.Tag;
import com.fortlom.account.interfaces.dto.tag.CreateTagResource;
import com.fortlom.account.interfaces.dto.tag.TagResource;
import com.fortlom.account.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.io.Serializable;
public class TagMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public TagResource toResource(Tag model) {
        return mapper.map(model, TagResource.class);
    }

    public Page<TagResource> modelListToPage(List<Tag> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, TagResource.class), pageable, modelList.size());
    }
    public Tag toModel(CreateTagResource resource) {
        return mapper.map(resource, Tag.class);
    }
}
