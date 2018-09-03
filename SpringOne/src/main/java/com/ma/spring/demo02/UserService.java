package com.ma.spring.demo02;


        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.beans.factory.annotation.Qualifier;
        import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    @Autowired
    @Qualifier("userDao")
    private UserDao userDao;
    public void addUser(){
        System.out.println("UserService......addUser()...");
        userDao.insert();
    }
}
