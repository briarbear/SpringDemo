package aop.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class StudentTest {

    @Autowired
    private Person student;

    @Test
    public void sayHello() {
        student.sayHello("xzp");

        /**
         * 当目标类实现接口，那么Spring AOP会选择JDK动态代理
         * 输出为com.sun.proxy.$Proxy26
         */
        System.out.println(student.getClass());

    }
}