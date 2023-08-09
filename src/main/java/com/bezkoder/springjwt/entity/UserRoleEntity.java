package com.bezkoder.springjwt.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="USER_ROLES")
@Entity
@IdClass(UserRoleIds.class)
public class UserRoleEntity {

//    @EmbeddedId
//    private UserRoleIds userRoleIds;

    @Id
    private Long user_id;
    @Id
    private int role_id;

}