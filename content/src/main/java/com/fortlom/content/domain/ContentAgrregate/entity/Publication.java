package com.fortlom.content.domain.ContentAgrregate.entity;


import javax.persistence.PrimaryKeyJoinColumn;
import lombok.*;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="publications")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Publication extends Content{
    private Boolean image;
}
