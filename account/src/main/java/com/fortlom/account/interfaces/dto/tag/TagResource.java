package com.fortlom.account.interfaces.dto.tag;

import com.fortlom.account.domain.UserAggregate.service.ArtistService;
import com.fortlom.account.interfaces.dto.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagResource {
    private Long id;

    private String name;

    private ArtistResource artist;
}
