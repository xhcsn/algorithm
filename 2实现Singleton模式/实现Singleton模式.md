#### 第一种解法————只适用于单线程环境
采用的是懒汉式单例模式：
```Java
//Singleton1.Java
public class Singleton1{
    //设计一个静态私有变量，代表单例，并且不实例化以满足懒汉式
    private static Singleton1 instance1 = null;
    //私有化静态方法，以防止new调用
    private Singleton1(){

    }
    //公开方法、获取实例
    public static Singleton1 getInstance1(){
        if(instance1 == null){
            instance1 = new Singleton1();
        }
        return instance1;
    }
}
```

#### 第二种解法————可以在多线程环境中工作，但是效率不高
对于Java来说只需要在getInstance1方法上加入同步锁，即可以做到在多线程环境下工作，尽管其效率不高，代码如下：
```Java
//Singleton2.Java
public class Singleton2{
    //设计一个静态私有变量，代表单例，并且不实例化以满足懒汉式
    private static Singleton2 instance2 = null;
    //私有化静态方法，以防止new调用
    private Singleton2(){

    }
    //公开方法、获取实例
    public static synchronized Singleton2 getInstance2(){
        if(instance2 == null){
            instance2 = new Singleton2();
        }
        return instance2;
    }
}
```

#### 第三种解法————双重校验锁以提高其在多线程中的效率
通过双重校验锁来提高其在多线程中的效率，使用双重校验锁的原因如下：

```Java
//Singleton3.Java
public class Singleton3{
    //设计一个静态私有变量，代表单例，并且不实例化以满足懒汉式
    private static Singleton3 instance3 = null;
    //私有化静态方法，以防止new调用
    private Singleton3(){

    }
    //公开方法、获取实例
    public static Singleton3 getInstance3(){
        if(instance3 == null){
            //以Singleton3类的字节码为锁对象
            synchronized(Singleton3.class){
                if(instance3 == null){
                    instance3 = new Singleton3();
                }

            }
            
        }
        return instance3;
    }
}
```

#### 第四种解法————使用静态内部类实现的单例模式
这种方法可以保证线程安全，性能上又不会因为同步而有所下降。
使用静态内部类在生成了一个静态final单例，在get方法中调用该单例。
```Java
//Singleton4.java
public class Singleton4{
    private Singleton4(){

    }
    //使用静态内部类实现
    private static class Lazy{
        private static final Singleton4 INSTANCE = new Singleton4();
    }
    //获得实例
    public Singleton4 getInstance4(){
        return Lazy.INSTANCE;
    }
}
```

#### 第五种解法————饿汉式解法
饿汉式解法是在类初始化的时候，就会实例化单例。
```Java
//Singleton5.java解法
public class Singleton5{
    //私有构造方法
    private Singleton5(){

    }
    //新建一个私有静态变量
    private static final Singleton5 instance5 = new Singleton5();
    //对外界的接口
    public Singleton5 getInstance5(){
        return instance5;
    }
}
```























