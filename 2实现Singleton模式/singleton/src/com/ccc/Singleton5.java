package com.ccc;

/**
 * @Description: 公用常量
 * @Date: 2021/1/3 19:08
 * @Pacakge: com.ccc
 * @ClassName: Singleton5
 * @Version: v1.0.0
 * @Author: ccc
 */
public class Singleton5 {
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
