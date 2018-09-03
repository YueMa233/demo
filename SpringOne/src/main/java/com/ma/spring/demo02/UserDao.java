package com.ma.spring.demo02;

        import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDao {
    public void insert(){
        System.out.println("UserDao.....insert()...");
    }
}
