package cn.neilshi.springlearning;

import cn.neilshi.springlearning.dynamicproxy.cglib.CglibDynamicProxy;
import cn.neilshi.springlearning.dynamicproxy.cglib.NeilShiNoImpl;
import cn.neilshi.springlearning.dynamicproxy.jdk.DynamicProxy;
import cn.neilshi.springlearning.dynamicproxy.jdk.NeilShi;
import cn.neilshi.springlearning.dynamicproxy.jdk.Person;
import org.junit.Test;

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
}
