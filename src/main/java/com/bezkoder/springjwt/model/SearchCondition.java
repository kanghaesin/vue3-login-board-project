package com.bezkoder.springjwt.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchCondition {
    private String sk;  //search key
    private String sv;  //search value

    private Long id;  //search value
    private Long user_id;  //search value
    private ArrayList<Integer> roles;  //search value
}
