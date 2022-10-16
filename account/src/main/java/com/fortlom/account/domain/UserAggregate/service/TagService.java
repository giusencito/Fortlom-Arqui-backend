package com.fortlom.account.domain.UserAggregate.service;


import com.fortlom.account.domain.UserAggregate.entity.Tag;
import com.fortlom.account.domain.UserAggregate.entity.childentity.Artist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import java.util.List;
public interface TagService {

    List<Tag> getTagsByArtistId(Long artistId);
    Tag createTag(Long Artist,Tag event);


}
