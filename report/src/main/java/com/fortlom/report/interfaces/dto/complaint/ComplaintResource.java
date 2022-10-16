package com.fortlom.report.interfaces.dto.complaint;


import com.fortlom.report.domain.complaintAgregate.valueobject.UserAccount;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ComplaintResource {

    private Long id;

    private String description;

    private Long userMain;

    private Long userReported;


    private Long publicationId;

    private Long forumId;

    private Long commentId;

    private UserAccount userAccountMain;

    private UserAccount userAccountReported;
}
