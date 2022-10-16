package com.fortlom.forum.domain.ForumAggregate.entity;



import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fortlom.forum.domain.ForumAggregate.valueobject.UserAccount;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="forums")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 20)
    @Column(unique = true)
    private String forumname;



    @NotNull
    @NotBlank
    @Size(max = 200)
    private String forumdescription;



    @Size(max = 200)
    private String forumrules;



    private Long userid;


    @Transient
    private UserAccount userAccount;
}
