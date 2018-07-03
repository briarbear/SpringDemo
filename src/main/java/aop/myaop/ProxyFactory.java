package aop.myaop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
@Component
public class ProxyFactory {

    //目标对象
    private static Object target;
    private static MyAOP myAOP;

    //生成代理对象的方法
//    @Autowired
    public static Object getProxyInstance(Object object,MyAOP aop){
        target = object;
        myAOP  = aop;

        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), (proxy, method, args) -> {
            myAOP.before(); //执行before方法
            //指向目标对象的方法
            Object returnValue = method.invoke(target,args);
            myAOP.after(); //执行afer方法
            return returnValue;
        });
    }
}
