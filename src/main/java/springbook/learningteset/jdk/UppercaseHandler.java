package springbook.learningteset.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {
    Object target;

    public UppercaseHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = (String)method.invoke(target, args);
        if(ret instanceof String)
            return ((String)ret).toUpperCase();
        else
            return ret;
    }
}