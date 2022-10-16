package com.fortlom.answer.interfaces.dto.Opinion;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OpinionResource {
    private Long id;

    private Date registerdate;

    private Long userid;

    private boolean agree;

    private Long contentid;

}
