package aop.myaop;

import org.springframework.stereotype.Component;

@Component
public class MyAOP {

    public void before(){
        System.out.println("before...");
    }

    public void after(){
        System.out.println("after...");
    }
}
