package com.wwg.webdemo01.model;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/5/27 9:16
 */
public class TestA {


    public void fun(String str){
        System.out.println(str);
    }

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }

}
