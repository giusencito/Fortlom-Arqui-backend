package com.fortlom.report.interfaces.mapping.configuration;
import com.fortlom.report.interfaces.dto.complaint.ComplaintResource;
import com.fortlom.report.interfaces.mapping.entity.ComplaintMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public ComplaintMapper ComplaintMapper() {
        return new ComplaintMapper();
    }
}
