package com.wwg.webdemo01.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author wangweiguang 2020/12/22 17:18
 */
@RestController
public class UserInfoController {

    @GetMapping("/say")
    public String say(String message){
      /*  try {
            UserInfo user = UserInfoContext.getUser();
            System.out.println("user=="+user.getSelectNationId());

        }catch (Exception e){
            throw new  RuntimeException(e);
        }*/

        return "hello==="+message;
    }
}
