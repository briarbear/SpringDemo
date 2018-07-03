package ioc;


import org.jdom2.JDOMException;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class StudentServiceTest {

    @Test
    public void helloService() throws NoSuchMethodException, IllegalAccessException, IOException, InstantiationException, JDOMException, InvocationTargetException, ClassNotFoundException {
        var factory = new ClassPathXmlApplicationContext();

        var service = (StudentService)factory.getBean("service");

        var student = (Student)factory.getBean("student");
        student.name = "xiongzp08";
        service.helloService(student);
    }
}