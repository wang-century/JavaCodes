package cn.centuryw.java.advance.multithreading;

/**
 * 静态代理
 * 1. 真实角色
 * 2. 代理角色
 */
public class StaticProxy {
    public static void main(String[] args) {
        Man man = new Man();
        WeddingCompany weddingCompany = new WeddingCompany(man);
        weddingCompany.happyMarry();
    }
}

interface Marry {
    void happyMarry();
}

/**
 * 真实角色
 */
class Man implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("嫦娥奔月...");
    }
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void ready() {
        System.out.println("婚礼准备");
    }

    private void after() {
        System.out.println("结束打理");
    }
}