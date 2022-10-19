package com.fortlom.answer.domain.AnswerAggregate.entity.childentity;
import com.fortlom.answer.domain.AnswerAggregate.entity.*;
import com.fortlom.answer.domain.AnswerAggregate.valueobject.UserAccount;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="comments")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Comment extends Answer {

    @NotNull
    @NotBlank
    @Size(max = 150)
    private String commentdescription;

    @Transient
    private UserAccount userAccount;
}
