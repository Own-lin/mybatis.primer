package com.lynn.Dao.mapper;

import com.lynn.Dao.mapper.PO.MyUser;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * explain:
 *
 * @Author Lynn
 * @Date 2021/9/30
 **/
public class MyUserMapperImpl implements MyUserMapper
{

    private SqlSessionFactory mySqlSessionFactory;
    public MyUserMapperImpl(SqlSessionFactory mySqlSessionFactory)
    {
        this.mySqlSessionFactory = mySqlSessionFactory;
    }

    /**
     * TODO 通过国家查找名字
     *
     * @param country 传入国家名
     * @param uid     传入uid
     * @return java.util.List<com.lynn.Dao.mapper.PO.MyUser>
     * @author Lynn
     * @date 2021/9/30 21:54
     */
    @Override
    public List<MyUser> searchNameByCountryOrUid(String country, Integer uid) {
        //创建SQLSession
        SqlSession mySqlSession = mySqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一标识
        MyUserMapper myUserMapper = mySqlSession.getMapper(MyUserMapper.class);
        List<MyUser> myUserCountry = mySqlSession.selectList("MyUserMapper", country);
        List<MyUser> fetchCountryOrUid = myUserMapper.searchNameByCouaasssxdszasntryOrUid("中国", null);
        System.out.println(myUserCountry);
        System.out.println(fetchCountryOrUid);

        mySqlSession.commit();
        mySqlSession.close();

        return mySqlSession.selectList("MyUserMapper", "中国");
    }
}
