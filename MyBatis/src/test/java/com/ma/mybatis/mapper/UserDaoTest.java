package com.ma.mybatis.mapper;
import com.ma.mybatis.pojo.User;
import com.ma.mybatis.pojo.UserCustom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class UserDaoTest {
    @Test
    public void addUser() throws IOException {
        InputStream cof = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cof);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper  mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setAge(22);
        user.setName("小红");
        mapper.addUser(user);
        sqlSession.close();
    }
    @Test
    /**
     * 通过ID查询用户
     */
    public void findUserById() throws IOException {
        InputStream cof = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cof);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(2);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    /**
     * 通过NAME查询用户
     */
    public void findUserByName() throws IOException {
        InputStream cof = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cof);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserByName(null);
        System.out.println(user);
        sqlSession.close();
    }
    @Test
    /**
     * 通过多个ID查询用户
     */
    public void findUsers() throws IOException {
        InputStream cof = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cof);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserCustom userCustom = new UserCustom();
        userCustom.setIds(Arrays.asList(1,2,3));
        List<User> users = mapper.findUsers(userCustom);
        for (User user:users ){
            System.out.println(user);
        }
        sqlSession.close();
    }
    @Test
    /**
     * 更改用户名
     */
    public void updateUserNmae() throws IOException {
        InputStream cof = Resources.getResourceAsStream("sqlMapConfig.xml");
        //创建会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(cof);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setName("Jack");
        mapper.updateUserName(user);
        sqlSession.close();
    }


}
