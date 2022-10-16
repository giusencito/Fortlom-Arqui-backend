package com.fortlom.answer.interfaces.dto.Opinion;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateOpinionResource {

    private Date registerdate;
    private boolean agree;
}
