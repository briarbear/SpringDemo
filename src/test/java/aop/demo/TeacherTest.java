package aop.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Config.class)
public class TeacherTest {

    @Autowired
    Teacher teacher;

    @Test
    public void sayHello() {
        teacher.sayHello("xzp teacher");
        /**
         *
         *  当目标类未实现接口时，那么Spring AOP会选择CGLIB来动态代理目标类
         *  输出为 aop.demo.Teacher$$EnhancerBySpringCGLIB$$3d9a2ad0
         */
        System.out.println(teacher.getClass());



    }
}