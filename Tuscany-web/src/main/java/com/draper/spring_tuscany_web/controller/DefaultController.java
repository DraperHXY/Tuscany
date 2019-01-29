package com.draper.spring_tuscany_web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class DefaultController {

    @GetMapping("")
    private String index1(HttpServletRequest request) {
        log.warn("request uri = [{}]", request.getRequestURI());
        log.warn("request url = [{}]", request.getRequestURL());
        log.warn("local port = [{}]", request.getServerPort());
        log.warn("remote user = [{}]", request.getRemoteUser());
        return "index";
    }

    @GetMapping("/index")
    private String index2() {

        return "index";
    }

}
