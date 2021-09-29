package com.lynn.mapper;

import com.lynn.model.User;
import com.lynn.model.UserShortCut;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * explain: MyBatis各类标签的示例
 *
 * @Author Lynn
 * @Date 2021/9/26
 **/
@Mapper
public interface UserMapper
{
    /*通过注解方式实现*/
    /**
     * TODO 接收用户id，返回string类型的用户名称
     * @author Lynn
     * @date 2021/9/26 20:34
     * @param id
     * @return java.lang.String
     */
    @Select("SELECT username FROM imooc_user WHERE id = #{id}")
    String selectUsernameById(Integer id);

/*通过xml方式实现*/
/**
 * TODO 接收用户id，返回Int类型的用户年龄
 * @author Lynn
 * @date 2021/9/26 20:43
 * @param id
 * @return java.lang.Integer
 */
    Integer selectUserAgeById(Integer id);

/**
 * TODO 用select标签使用XML配置通过年龄和分数查询用户
 * @author Lynn
 * @date 2021/9/27 9:13
 * @param user
 * @return com.lynn.model.User
 */
    User selectUserByAgeAndScore(User user);

/**
 * TODO 使用resultMap标签，只获取用户名和年龄
 * @author Lynn
 * @date 2021/9/27 10:42
 * @param id
 * @return com.lynn.model.UserShortCut
 */
    UserShortCut selectUserShortcutById(Integer id);

/**
 * TODO
 * @author Lynn
 * @date 2021/9/27 11:30
 * @param user
 * @return int
 */
    int insertUser(User user);

/**
 * TODO 更新用户年龄
 * @author Lynn
 * @date 2021/9/27 20:21
 * @param age
 * @param id
 * @return int
 */
    int updateUserAgeById(@Param("age") Integer age, @Param("id") Integer id);

/**
 * TODO 使用delete标签依据用户名删除用户数据
 * @author Lynn
 * @date 2021/9/28 22:16
 * @param username
 * @return java.lang.String
 */
    int deleteUserByName(@Param("username") String username);

/**
 * TODO 通过用户名字统计用户在表中的数据条数
 * @author Lynn
 * @date 2021/9/28 22:41
 * @param username
 * @return int
 */
    int checkTheCuntByName(@Param("username") String username);
}
