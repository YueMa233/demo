package com.ma.spring.demo01;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.beans.IntrospectionException;
import java.lang.reflect.Method;

public class UserTest {
    @Test
    public void test01() {
        //1、创建Spring的工厂对象（BeanFactory ApplicationContext）
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2、使用applicationContext.xml内部配置的bean来创建对象
        User user= (User) applicationContext.getBean("user");
        System.out.println(user);
        //applicationContext.close();
    }
    @Test
    public void test02() throws ClassNotFoundException, IntrospectionException, IllegalAccessException, InstantiationException {
        Class clazz = Class.forName("com.ma.spring.demo01.User");
        //PropertyDescriptor propertyDescriptor = new PropertyDescriptor("name",clazz);
        //System.out.println(propertyDescriptor.getWriteMethod().getName());
        Object obj = clazz.newInstance();
        for(Method method : clazz.getMethods()){
            if(method.getName().startsWith("set")){
                System.out.println(method.getName());
            }
        }

    }
}
