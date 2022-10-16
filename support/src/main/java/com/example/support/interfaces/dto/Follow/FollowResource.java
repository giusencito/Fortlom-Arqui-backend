package com.example.support.interfaces.dto.Follow;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FollowResource {

    private Long id;

    private Long artistid;


    private Long fanaticid;
}
