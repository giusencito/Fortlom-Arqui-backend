package com.fortlom.account.interfaces.dto.album;

import com.fortlom.account.domain.UserAggregate.entity.childentity.Artist;
import com.fortlom.account.interfaces.dto.artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AlbumResource {


    private Long id;



    private String name;


    private String Description;


    private ArtistResource artist;

}
