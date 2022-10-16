package com.fortlom.administration.interfaces.mapping.configuration;


import com.fortlom.administration.interfaces.mapping.entity.AdminMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public AdminMapper adminMapper() {
        return new AdminMapper();
    }
}
