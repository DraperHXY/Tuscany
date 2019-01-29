package com.draper.spring_tuscany_web.controller;

import com.draper.tuscany_core.model.User;
import com.draper.tuscany_core.service.UserService;
import com.draper.spring_tuscany_web.util.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequestMapping("/user")
@Controller
public class UserController {

    private Map<String, String> redis = new HashMap<>();

    @Resource
    private UserService userService1;

    @Resource
    private UserService userService2;

    private UserService userService;

    @GetMapping("/loginIn")
    private String loginInGet() {
        return "user/loginIn";
    }

    @PostMapping("/loginIn")
    private String loginInPost(@RequestParam("account") String account, @RequestParam("password") String password) {
        userService = (UserService) RandomServiceUtil.getService(userService1, userService2);

        // 参数校验
        if (account == null || account.trim().length() == 0
                || password == null || password.trim().length() == 0)
            return "index";

        if (StringMatchsUtil.isMobile(account)){
            User user = userService.selectUserByPhone(account);
        } else {
            User user = userService.selectUserByEmail(account);
        }
        return "index";
    }

    @GetMapping("/loginUp/p")
    private String loginUpPhoneGet() {
        return "user/loginUpPhone";
    }

    @GetMapping("/loginUp/e")
    private String loginUpEmailGet() {
        return "user/loginUpEmail";
    }

    @PostMapping("/loginUp/p")
    private String loginUpPhonePost(@RequestParam Map<String, String> params) {

        // 实现随机访问
        userService = (UserService) RandomServiceUtil.getService(userService1, userService2);

        // 获取前端数据
        String name = params.get("name");
        String firstPassword = params.get("firstPassword");
        String secondPassword = params.get("secondPassword");
        String phoneNumber = params.get("phoneNumber");
        String verifyCode = params.get("verifyCode");

        User user = new User();
        user.setName(name);
        user.setPassword(firstPassword);
        user.setPhone(phoneNumber);

        log.warn("user phone = [{}] login up", phoneNumber);
        boolean result = userService.insertUserByPhone(user);
        log.warn("user login up result = [{}]", result);
        return "index";
    }

    @PostMapping("/loginUp/e")
    private String loginUpEmailPost(@RequestParam Map<String, String> params) {

        // 实现随机访问
        userService = (UserService) RandomServiceUtil.getService(userService1, userService2);

        String name = params.get("name");
        String firstPassword = params.get("firstPassword");
        String secondPassword = params.get("secondPassword");
        String email = params.get("email");
        String verifyCode = params.get("verifyCode");

        User user = new User();
        user.setName(name);
        user.setPassword(firstPassword);
        user.setEmail(email);

        log.warn("user email = [{}] login up", email);
        boolean result = userService.insertUserByPhone(user);
        log.warn("user login up result = [{}]", result);
        return "index";
    }

    @Autowired
    private SMSManager smsManager;

    @PostMapping("/sendPhoneCode")
    private void sendPhoneCodePost(@RequestParam("phone") String phone) {
        int code = RandomCodeUtil.build();
        log.warn("start send phone = [{}], code = [{}]", phone, code);
        redis.put("phone" + phone, String.valueOf(code));
        smsManager.sendTemplateSMS(phone, "1", new String[]{String.valueOf(code), "15"});
        log.warn("send phone = [{}], code = [{}] compelete", phone, code);
    }

    @Autowired
    private EmailManager emailManager;

    @PostMapping("/sendEmailCode")
    private void sendEmailCodePost(@RequestParam("email") String email) {
        int code = RandomCodeUtil.build();
        log.warn("start send email = [{}], code = [{}]", email, code);
        redis.put("email" + email, String.valueOf(code));
        emailManager.sendVerifyCode(email, String.valueOf(code));
        log.warn("send email = [{}], code = [{}] compelete", email, code);
    }

}
