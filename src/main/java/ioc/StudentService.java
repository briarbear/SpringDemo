package ioc;

/**
 * 学生服务类
 */
public class StudentService {

    private Greeting greeting;

    public Greeting getGreeting() {
        return greeting;
    }

    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }

    /**
     * 对某人打招呼
     * @param p
     */
    public void helloService(Person p){
        this.greeting.hello(p);
    }
}
