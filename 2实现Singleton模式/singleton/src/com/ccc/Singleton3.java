package com.ccc;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 18:52
 * @Pacakge: com.ccc
 * @ClassName: Singleton3
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Singleton3 {
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
