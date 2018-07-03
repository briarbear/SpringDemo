package ioc;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IOC 容器类
 */
public class ClassPathXmlApplicationContext implements BeanFactroy {
    private Map<String,Object> beans = new HashMap<String, Object>(); //IOC容器

    /**
     * 构造函数，完成xml文件的解析
     */
    public ClassPathXmlApplicationContext() throws JDOMException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SAXBuilder builder = new SAXBuilder();
        Document document  = builder.build(this.getClass().getClassLoader().getResource("iocbeans.xml"));
        Element root = document.getRootElement();
        //获得bean元素集合
        List<Element> list = root.getChildren("bean");

        for (int i = 0; i < list.size(); i++) {
            Element element = list.get(i);
            String id = element.getAttributeValue("id");
            String clazz = element.getAttributeValue("class");

            System.out.println(id + " : " + clazz);

            //通过反射构建对象
//            Object obj = Class.forName(clazz).newInstance()
            Object obj = Class.forName(clazz).getDeclaredConstructor().newInstance();

            //添加到map容器中
            beans.put(id,obj);

            //注入依赖
            for (Element property : element.getChildren("property")) {
                String name = property.getAttributeValue("name");
                String injectBean = property.getAttributeValue("bean");
                Object propertyObj = beans.get(injectBean);

                //拼接setter方法
                String methodNmae = "set" + name.substring(0,1).toUpperCase() + name.substring(1);
                System.out.println("method name = " + methodNmae);

                Method m = obj.getClass().getMethod(methodNmae,propertyObj.getClass().getInterfaces());

                //注入
                m.invoke(obj,propertyObj);

            }

        }

    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }
}
