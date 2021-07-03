package dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * <p>
 *
 * </p>
 *
 * @author: hqk
 * @DATE: 2021/7/4
 **/
public class SubjectInvocationHandler implements InvocationHandler {
    //这个就是我们要代理的真实对象
    private Object subject;

    //构造方法，给我们要代理的真实对象赋初值
    public SubjectInvocationHandler(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object object, Method method, Object[] args) throws Throwable {
        //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("before Method invoke  代理类，功能的增强 调用前 "+method+" 可做操作（比如是否能调用的权限认证）");
        System.out.println("Method:" + method);
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用，得到对应的返回值，最后将对应返回值返回
        Object obj = method.invoke(subject, args);
        //在代理真实对象后我们也可以添加一些自己的操作
        System.out.println("after Method invoke  这里可处理原方法调用后的逻辑处理 ");
        return obj;
    }
}
