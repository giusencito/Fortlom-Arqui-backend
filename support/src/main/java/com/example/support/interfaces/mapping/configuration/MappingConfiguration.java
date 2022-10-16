package com.example.support.interfaces.mapping.configuration;

import com.example.support.interfaces.mapping.entity.FollowMapper;
import com.example.support.interfaces.mapping.entity.RateMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {

    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public FollowMapper FollowMapper() {
        return new FollowMapper();
    }
    @Bean
    public RateMapper RateMapper() {
        return new RateMapper();
    }
}
