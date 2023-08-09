package com.bezkoder.springjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserRoleIds implements Serializable {
    private Long user_id;
    private int role_id;
}
