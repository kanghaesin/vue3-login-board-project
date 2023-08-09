package com.bezkoder.springjwt.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRoleDto implements Serializable {

    private Long user_id;
    private Integer role_id;

    private String roles;
}
