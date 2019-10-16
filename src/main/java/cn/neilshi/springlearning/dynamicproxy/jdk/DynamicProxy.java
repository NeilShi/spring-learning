package cn.neilshi.springlearning.dynamicproxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 依靠接口实现
 * */
public class DynamicProxy implements InvocationHandler {
    Object target;

    /**
     * 绑定委托对象
     * 动态生成代理类并返回
     * */
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理调用对象方法时会调用到此
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        String before = "before...";
        result = method.invoke(target, args);
        String after = "...after";

        return before + result + after;
    }
}
