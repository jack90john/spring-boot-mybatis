package com.jack.self.controller;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 描述：登录控制器类
 * 作者：Jack
 * 时间：2016/10/19 16:56
 *
 * @version 1.0
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {

        if (ArrayUtils.isNotEmpty(request.getCookies())) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("userName")) {
                    try {
                        model.addAttribute("userNameCookie", URLEncoder.encode(cookie.getValue(), "UTF-8"));
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "login";
    }
}
