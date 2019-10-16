package cn.neilshi.springlearning;

import cn.neilshi.springlearning.dynamicproxy.cglib.CglibDynamicProxy;
import cn.neilshi.springlearning.dynamicproxy.cglib.NeilShiNoImpl;
import cn.neilshi.springlearning.dynamicproxy.jdk.DynamicProxy;
import cn.neilshi.springlearning.dynamicproxy.jdk.NeilShi;
import cn.neilshi.springlearning.dynamicproxy.jdk.Person;
import cn.neilshi.springlearning.ioc.config.ApplicationConfig;
import cn.neilshi.springlearning.ioc.config.ApplicationScanConfig;
import cn.neilshi.springlearning.ioc.pojo.People;
import cn.neilshi.springlearning.ioc.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommonTest {
    @Test
    public void testJdkDynamicProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Person myProxy = (Person) dynamicProxy.bind(new NeilShi());
        myProxy.doSomething();
    }

    @Test
    public void testCglibDynamicProxy() {
        CglibDynamicProxy dynamicProxy = new CglibDynamicProxy();
        NeilShiNoImpl myProxy = (NeilShiNoImpl) dynamicProxy.getProxyInstance(new NeilShiNoImpl());
        myProxy.doSomething();
    }

    @Test
    public void testLoadBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        User user = applicationContext.getBean(User.class);
        Assert.assertEquals(user.getName(), "jack");
    }

    @Test
    public void testLoadBeanByScan() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationScanConfig.class);
        People people = applicationContext.getBean(People.class);
        Assert.assertEquals(people.getName(), "rose");
    }
}
