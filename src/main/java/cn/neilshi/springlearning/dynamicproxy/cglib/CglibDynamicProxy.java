package cn.neilshi.springlearning.dynamicproxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 依靠继承被代理类实现 （被代理类的儿子）
 * */
public class CglibDynamicProxy implements MethodInterceptor {
    Object target;

    public Object getProxyInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 继承被代理对象
        enhancer.setSuperclass(target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 回调方法
     * */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result;
        String cglibBefore = "cglibBefore...";
        result = method.invoke(target, args);
        String cglibAfter = "...cglibAfter";
        return cglibBefore + result + cglibAfter;
    }
}
