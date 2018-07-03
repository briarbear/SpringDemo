package ioc;

public class Hello implements Greeting {
    @Override
    public void hello(Person p) {
        System.out.println("hello to "+p.name);
    }
}
