package com.lynn.pattern;

import com.lynn.mapper.UserMapper;
import com.lynn.model.User;
import com.lynn.model.UserShortCut;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.SQLException;
import java.util.List;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/27
 **/
@SuppressWarnings({"Duplicates"})
public class StartWithMapper
{
    public static void main(String[] args) throws IOException, SQLException
    {
        String  resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        //得到 Mapper
        UserMapper mapper = session.getMapper(UserMapper.class);
        //调用注解的SQL
        String username = mapper.selectUsernameById(1);
        System.out.println("username: " + username);
        //调用XML的SQL
        Integer age = mapper.selectUserAgeById(1);
        System.out.println("age: " + age);

        //得到mapper
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User condition = new User();
        condition.setAge(18);
        condition.setScore(100);

        //调用方法
        User user = userMapper.selectUserByAgeAndScore(condition);
        //得到 user
        System.out.println(user);

        UserShortCut shortCut = userMapper.selectUserShortcutById(1);
        System.out.println(shortCut);

        User user1 = new User();
        user1.setUsername("insert test");
        user1.setAge(100);
        user1.setScore(100000);
        int rows = userMapper.insertUser(user1);
        System.out.println(rows);

        int rows1 = userMapper.updateUserAgeById(180, 1);
        System.out.println(rows1);

        /*使用delete标签循环删除多余的数据*/
        String delName = "insert test";
        Integer checkNum = userMapper.checkTheCuntByName(delName);
        if (checkNum == null)
        {
            System.out.println("User message is empty!!!");
        }else if(checkNum == 1)
        {
            System.out.println("User only have one message!!!");
        }else
        {
            int delUserByName = userMapper.deleteUserByName(delName);
            System.out.println(delUserByName);
        }

        /*OGNL表达式*/
        User pedro = new User();
        pedro.setUsername("pedro");
        pedro.setAge(22);

        /*执行insert、update标签时一定需要通过commit方法提交会话*/
        session.commit();

        //关闭会话
        session.close();

    }
}
