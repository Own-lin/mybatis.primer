package com.lynn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/27
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    private Long id;
    private String username;
    private Integer age;
    private Integer score;
}
