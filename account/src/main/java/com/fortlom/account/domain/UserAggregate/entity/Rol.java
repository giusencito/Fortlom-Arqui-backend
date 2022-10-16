package com.fortlom.account.domain.UserAggregate.entity;
import com.fortlom.account.domain.UserAggregate.enumeration.Rolname;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Rolname name;
}
