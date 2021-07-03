package staticproxy;

public class RealSubject implements Subject {
    @Override
    public void sayGoodBye() {
        System.out.println("RealSubject 我是原封不动的代码 sayGoodBye ");
    }
    @Override
    public void sayHello(String str) {
        System.out.println("RealSubject 我是原封不动的代码 sayHello  " + str);
    }

    @Override
    public boolean isProxy() {
        System.out.println("RealSubject  我是原封不动的代码    isProxy     ");
        return false;
    }
}
