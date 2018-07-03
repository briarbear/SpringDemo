package aop.demo;

import org.springframework.stereotype.Component;

@Component
public class Student implements Person{

    public String sayHello(String name) {
        System.out.println("good good study");
        return name + "hello aop";
    }
}
