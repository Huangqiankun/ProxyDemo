package staticproxy;

public class ProxySubject implements Subject {
    private Subject subject;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void sayGoodBye() {
        //代理类，功能的增强 调用前 sayGoodBye 可做操作（比如是否能调用的权限认证）
        System.out.println("ProxySubject sayGoodBye begin  " +
                "代理类，功能的增强 调用前 sayGoodBye 可做操作（比如是否能调用的权限认证）");
        //在代理类的方法中 间接访问被代理对象的方法
        subject.sayGoodBye();
        System.out.println("ProxySubject sayGoodBye end " +
                "这里可处理原方法调用后的逻辑处理");
    }

    @Override
    public void sayHello(String str) {
        //代理类，功能的增强 调用前 sayHello 可做操作（比如是否能调用的权限认证） 并测试带参数的方法
        System.out.println("ProxySubject sayHello begin  " +
                "代理类，功能的增强 调用前 sayHello 可做操作（比如是否能调用的权限认证）");
        //在代理类的方法中 间接访问被代理对象的方法
        subject.sayHello(str);
        System.out.println("ProxySubject sayHello end " +
                "这里可处理原方法调用后的逻辑处理");
    }

    @Override
    public boolean isProxy() {
        //代理类，功能的增强 调用前 isProxy 可做操作（比如是否能调用的权限认证） 并测试带返回的方法
        System.out.println("ProxySubject isProxy begin  " +
                "代理类，功能的增强 调用前 isProxy 可做操作（比如是否能调用的权限认证）");
        boolean boolReturn = subject.isProxy();
        System.out.println("ProxySubject isProxy end " +
                "这里可处理原方法调用后的逻辑处理");
        return boolReturn;
    }
}
