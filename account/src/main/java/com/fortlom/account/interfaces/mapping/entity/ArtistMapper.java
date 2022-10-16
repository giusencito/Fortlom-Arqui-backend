package com.fortlom.account.interfaces.mapping.entity;
import com.fortlom.account.domain.UserAggregate.entity.childentity.Artist;
import com.fortlom.account.interfaces.dto.artist.ArtistResource;
import com.fortlom.account.interfaces.dto.artist.CreateArtistResource;
import com.fortlom.account.interfaces.dto.artist.UpdateArtistResource;
import com.fortlom.account.interfaces.mapping.configuration.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.io.Serializable;

public class ArtistMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;


    public ArtistResource toResource(Artist model) {
        return mapper.map(model, ArtistResource.class);
    }

    public Page<ArtistResource> modelListToPage(List<Artist> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ArtistResource.class), pageable, modelList.size());
    }
    public Artist toModel(CreateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }

    public Artist toModel(UpdateArtistResource resource) {
        return mapper.map(resource, Artist.class);
    }
}
