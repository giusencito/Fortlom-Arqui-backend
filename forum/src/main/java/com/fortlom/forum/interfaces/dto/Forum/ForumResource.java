package com.fortlom.forum.interfaces.dto.Forum;

import com.fortlom.forum.domain.ForumAggregate.valueobject.UserAccount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ForumResource {

    private Long id;


    private String forumname;




    private String forumdescription;



    private String forumrules;



    private Long userid;



    private UserAccount userAccount;
}
