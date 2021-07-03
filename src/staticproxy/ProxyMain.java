package staticproxy;

import dynamicproxy.SubjectInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyMain {

    public static void main(String[] args) {

//        //------------------   静态代理调用  -------------------
//
//        //被代理的对象，某些情况下 我们不希望修改已有的代码，我们采用代理来间接访问
//        RealSubject realSubject = new RealSubject();
//        //代理类对象，将原有代码不想修改的对象传入代理类对象
//        ProxySubject proxySubject = new ProxySubject(realSubject);
//        //调用代理类对象的方法
//        proxySubject.sayGoodBye();
//        System.out.println("******");
//        proxySubject.sayHello("Test");
//        System.out.println("******");
//        proxySubject.isProxy();


        //------------------  动态代理调用  -------------------
        //被代理类
        Subject realSubject = new RealSubject();
        //我们要代理哪个类，就将该对象传进去，最后是通过该被代理对象来调用其方法的
        SubjectInvocationHandler handler = new SubjectInvocationHandler(realSubject);
        //生成代理类
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), handler);
        //输出代理类对象
        System.out.println("Proxy : " + subject.getClass().getName());
        System.out.println("Proxy super : " + subject.getClass().getSuperclass().getName());
        System.out.println("Proxy interfaces : " + subject.getClass().getInterfaces()[0].getName());
        //调用代理类sayGoodBye方法
        subject.sayGoodBye();
        System.out.println("--------");
        //调用代理类sayHello方法
        subject.sayHello("Test");
        System.out.println("--------");
        System.out.println("---subject.isProxy()-----" + subject.isProxy());
    }

}




