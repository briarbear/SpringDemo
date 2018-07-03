package aop.myaop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class HelloTest {

    ApplicationContext ac =  new ClassPathXmlApplicationContext("aopbeans.xml");

//    @Autowired
    ProxyFactory proxyFactory;

    @Test
    public void say() {
        System.out.println("");
        Object o = ac.getBean("proxy");
        Greeding hello = (Greeding)o;
        hello.say();
        System.out.println(hello.getClass());
    }
}