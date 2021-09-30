package com.lynn.Dao.mapper.PO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/30
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyUser
{
    private int id;
    private String name;
    private int uid;
    private int age;
    private String gender;
    private String country;
}
