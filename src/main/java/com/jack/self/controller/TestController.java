package com.jack.self.controller;


import com.jack.self.config.EnumAuth;
import com.jack.self.model.UserVO;
import com.jack.self.service.entry.QueryUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.List;
/**
 * 描述：测试控制器类
 * 作者：Jack
 * 时间：2016/10/17 15:25
 * @version 1.0
 */
@Slf4j
@Controller
public class TestController {

    @Autowired
    QueryUserService queryUserService;

    @RequestMapping("/queryUser")
    @ResponseBody
    public List<UserVO> queryHospital() {
        return queryUserService.queryUser();
    }


    @RequestMapping("/")
    public String defaultPage(HttpServletRequest request,
                              HttpServletResponse response,
                              Model model){
        // 获取认证信息
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        String userName = userDetails.getUsername();
        boolean cookieFlag = false;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userName")) {
                try {
                    cookie.setValue(URLEncoder.encode(userName, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                cookie.setMaxAge(3600);
                response.addCookie(cookie);
                cookieFlag =  true;
            }
        }
        //如果用户的用户名cookie为空，则发送cookie
        if(cookies.length == 0 || !cookieFlag){
            Cookie cookie = null;
            try {
                cookie = new Cookie("userName", URLEncoder.encode(userName, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //设置时间为1小时
            cookie.setMaxAge(3600);
            cookie.setPath("/");
            //把cookie给浏览器
            response.addCookie(cookie);
        }
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
//        List<String> authlist = new ArrayList<>();
        String auth = EnumAuth.DEFAULT_AUTH.getDefaultAuth();
        for (GrantedAuthority grantedAuthority : authorities) {
            String authority = grantedAuthority.getAuthority();
            auth = String.valueOf(Integer.valueOf(auth) + Integer.valueOf(authority)).replaceAll("2", "1");
        }
        // 当前登陆用户
        model.addAttribute("username", userName);
        // 当前用户拥有权限
        model.addAttribute("authlist", auth);
        return "index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/queryInfo")
    public String queryInfo(){
        return "customer/queryInfo";
    }
}
