package com.ccc;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 17:07
 * @Pacakge: com.ccc
 * @ClassName: Singleton2
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Singleton2 {
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
