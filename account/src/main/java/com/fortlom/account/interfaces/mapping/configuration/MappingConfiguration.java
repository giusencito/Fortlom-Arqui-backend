package com.fortlom.account.interfaces.mapping.configuration;
import com.fortlom.account.interfaces.mapping.entity.ArtistMapper;
import com.fortlom.account.interfaces.mapping.entity.FanaticMapper;
import com.fortlom.account.interfaces.mapping.entity.TagMapper;
import com.fortlom.account.interfaces.mapping.entity.UserAccountMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("enhancedModelMapperConfiguration")
public class MappingConfiguration {
    @Bean
    public EnhancedModelMapper modelMapper() {
        return new EnhancedModelMapper();
    }
    @Bean
    public ArtistMapper artistMapper() {
        return new ArtistMapper();
    }
    @Bean
    public FanaticMapper fanaticMapper() {
        return new FanaticMapper();
    }
    @Bean
    public TagMapper tagMapper() {
        return new TagMapper();
    }

    @Bean
    public UserAccountMapper UserAccountMapper() {
        return new UserAccountMapper();
    }
}
