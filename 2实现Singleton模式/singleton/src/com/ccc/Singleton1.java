package com.ccc;

/**
 * @Description: 该单例是懒汉式单例，在第一次调用的时候才会进行实例化。并且仅仅适用于单线程环境下，
 * 因为其静态方法并未上锁。
 * @Date: 2021/1/3 16:45
 * @Pacakge: com.ccc
 * @ClassName: Singleton1
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Singleton1 {
    //设计一个静态私有变量singleton1
    private static Singleton1 singleton1 = null;
    //设计一个私有的构造函数，以禁止在其他类中创建实例
    private Singleton1(){

    }
    //设计一个静态方法，返回类的实例
    public static Singleton1 getSingleton1() {
        if(singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getSingleton1();
        Singleton1 singleton2 = singleton1;
        Singleton1 singleton3 = Singleton1.getSingleton1();
        System.out.println(singleton1 == singleton2);
        System.out.println(singleton1 == singleton3);
    }
}
