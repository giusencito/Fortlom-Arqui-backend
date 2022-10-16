package com.fortlom.forum.interfaces.mapping.configuration;


import com.fortlom.forum.interfaces.mapping.entity.ForumMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public ForumMapper ForumMapper() {
        return new ForumMapper();
    }
}
