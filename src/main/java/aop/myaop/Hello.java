package aop.myaop;

import org.springframework.stereotype.Component;

@Component
public class Hello implements Greeding {


    @Override
    public void say() {
        System.out.println("say hello");
    }
}
