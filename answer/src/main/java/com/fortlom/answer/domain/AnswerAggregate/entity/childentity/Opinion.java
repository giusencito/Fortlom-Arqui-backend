package com.fortlom.answer.domain.AnswerAggregate.entity.childentity;


import com.fortlom.answer.domain.AnswerAggregate.entity.Answer;
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
@Table(name="opinions")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Opinion extends Answer {

    private boolean agree;
    private Long contentid;


}
