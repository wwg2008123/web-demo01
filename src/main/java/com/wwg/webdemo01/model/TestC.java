package com.wwg.webdemo01.model;

import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author wangweiguang 2021/5/27 9:16
 */
@Configuration
public class TestC {


    public void fun(String str){
        System.out.println(str);
    }

    public void printName() {
        System.out.println("类名 ：" + Thread.currentThread().getStackTrace()[1].getClassName());
    }

}
