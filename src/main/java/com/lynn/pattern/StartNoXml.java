package com.lynn.pattern;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/26
 **/
@SuppressWarnings({"SqlResolve", "SqlNoDataSourceInspection", "Duplicates"})
public class StartNoXml
{
    public static void main(String[] args) throws SQLException
    {
        JdbcTransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();
        PooledDataSource dataSource = new  PooledDataSource("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/mybatis?&useSSL=false&serverTimezone=UTC",
                "root", "1075465357");
        /*配置环境，向环境中指定环境id、事务和数据源*/
        Environment environment = new Environment.Builder("development")
                .transactionFactory(jdbcTransactionFactory)
                .dataSource(dataSource).build();
        /*相减MyBatis配置类*/
        Configuration configuration = new Configuration(environment);
        /*得到SqlSessionFactory核心类*/
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        /*开始一个sql会话*/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /*得到sql链接并运行sql语句*/
        PreparedStatement preparedStatement = sqlSession
                .getConnection()
                .prepareStatement("SELECT * FROM imooc_user WHERE id = ?");
        preparedStatement.setInt(1, 1);
        ResultSet result = preparedStatement.executeQuery();
    //    验证结果
        while (result.next()){
            System.out.println("username: " + result.getString("username"));
        }
        sqlSession.close();



    }

}
