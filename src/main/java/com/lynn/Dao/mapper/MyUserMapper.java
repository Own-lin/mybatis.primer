package com.lynn.Dao.mapper;

import com.lynn.Dao.mapper.PO.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *explain:
 *@Author Lynn
 *@Date 2021/9/30
**/
@Mapper
public interface MyUserMapper
{

/**
 * TODO 通过国家查找名字
 * @author Lynn
 * @date 2021/9/30 21:54
 * @param country 传入国家名
 * @param uid 传入uid
 * @return java.util.List<com.lynn.Dao.mapper.PO.MyUser>
 */
    public List<MyUser> searchNameByCountryOrUid(@Param("country")String country, @Param("uid") Integer uid);

}

