package com.fortlom.account.interfaces.dto.song;

import com.fortlom.account.domain.MusicAggregate.enumeration.Category;
import com.fortlom.account.interfaces.dto.album.AlbumResource;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class SongResource {

    private Long id;


    private String name;


    private String musicUrl;



    private Category category;



    private AlbumResource album;
}
