package com.fortlom.answer.interfaces.mapping.entity;

import com.fortlom.answer.domain.AnswerAggregate.entity.childentity.Opinion;
import com.fortlom.answer.interfaces.dto.Opinion.CreateOpinionResource;
import com.fortlom.answer.interfaces.dto.Opinion.OpinionResource;
import com.fortlom.answer.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;


public class OpinionMapper {

    @Autowired
    EnhancedModelMapper mapper;



    public OpinionResource toResource(Opinion model) {
        return mapper.map(model, OpinionResource.class);
    }

    public Page<OpinionResource> modelListToPage(List<Opinion> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, OpinionResource.class), pageable, modelList.size());
    }
    public Opinion toModel(CreateOpinionResource resource) {
        return mapper.map(resource, Opinion.class);
    }

}
