package com.fortlom.report.domain.complaintAgregate.entity;


import com.fortlom.report.domain.complaintAgregate.valueobject.UserAccount;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;

    @NotNull
    private Long userMain;

    @NotNull
    private Long userReported;


    private Long publicationId;

    private Long forumId;

    private Long commentId;

    @Transient
    private UserAccount userAccountMain;
    @Transient
    private UserAccount userAccountReported;


}
