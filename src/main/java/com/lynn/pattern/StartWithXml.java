package com.lynn.pattern;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/26
 **/
@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "Duplicates"})
public class StartWithXml
{
    public static void main(String[] args) throws IOException, SQLException
    {
        /*配置使用MyBatis*/
        String resource = "mybatis-config.xml";
        /*读取配置文件*/
        InputStream inputStream = Resources.getResourceAsStream(resource);
        /*按照配置文件得到SqlSessionFactory*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /*新建会话*/
        SqlSession session = sqlSessionFactory.openSession();
        /*执行sql*/
        PreparedStatement preparedStatement = session.getConnection().prepareStatement("SELECT * FROM imooc_user WHERE id = ?");
        preparedStatement.setInt(1, 1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println("username: " + resultSet.getString("username"));

        }
        session.close();

    }
}


















