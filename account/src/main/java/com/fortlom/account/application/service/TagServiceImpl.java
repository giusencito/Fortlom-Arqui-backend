package com.fortlom.account.application.service;

import com.fortlom.account.application.exception.ResourceNotFoundException;
import com.fortlom.account.domain.UserAggregate.entity.Tag;
import com.fortlom.account.domain.UserAggregate.repository.ArtistRepository;
import com.fortlom.account.domain.UserAggregate.repository.TagRepository;
import com.fortlom.account.domain.UserAggregate.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    private static final String ENTITY = "Tag";
    private static final String ENTITY2 = "Artist";
    @Autowired
    private TagRepository tagRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Override
    public List<Tag> getTagsByArtistId(Long artistId) {
        return tagRepository.findByArtistId(artistId);
    }

    @Override
    public Tag createTag(Long Artist, Tag request) {
        return artistRepository.findById(Artist)
                .map(artists -> {
                    request.setArtist(artists);
                    return tagRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, Artist));
    }



}
