package com.bezkoder.springjwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchTodoCondition {
    private String email;  //search key
    private long activity_group_id;
    private long id;
}
