package aop.demo;

import org.springframework.stereotype.Component;

/**
 * 未实现接口
 */
@Component
public class Teacher {

    public String sayHello(String name) {
        System.out.println("day day up");
        return name + "hello aop";
    }
}
