package com.example.support.interfaces.mapping.entity;
import com.example.support.domain.rateAgreegate.entity.Rate;
import com.example.support.interfaces.dto.Rate.CreateRateResource;
import com.example.support.interfaces.dto.Rate.RateResource;
import com.example.support.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
public class RateMapper {



    @Autowired
    EnhancedModelMapper mapper;



    public RateResource toResource(Rate model) {
        return mapper.map(model, RateResource.class);
    }

    public Page<RateResource> modelListToPage(List<Rate> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RateResource.class), pageable, modelList.size());
    }
    public Rate toModel(CreateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

}
