package com.ziyue.datasource;


import com.ziyue.mybaits.datasource.MyBaitsDataSource;
import com.ziyue.mybaits.entity.TestEntity;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MyBaitsDataSourceTest {

    private Logger logger = Logger.getLogger(MyBaitsDataSourceTest.class);

    @Test
    public void createSession() {
        SqlSessionFactory sqlSessionFactory = MyBaitsDataSource.createSessionFactoryWithXML();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestEntity test = sqlSession.selectOne("com.ziyue.mybaits.dao.TestMapper.getAllTest");
        logger.info(test);
    }

    public String setName() {
        try {
            System.out.println(System.currentTimeMillis());
            System.out.println("bbbbbbbbbb");
            return "hahahahaa";
        } finally {
            System.out.println(System.currentTimeMillis());
            System.out.println("aaaaaaaaaa");
        }
    }

    @Test
    public void doTest() {
        System.out.println(setName());
    }
}