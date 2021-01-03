package com.ccc;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 18:53
 * @Pacakge: com.ccc
 * @ClassName: Singleton4
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Singleton4 {
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
