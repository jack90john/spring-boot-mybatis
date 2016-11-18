package com.jack.self.config;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 任务：
 * 描述：
 * 作者：蒋珂
 * 时间：2016/10/19 13:37
 * 类名: spring-boot-mybatis
 *
 * @version 1.0
 */
@Component
public class DefaultAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/unauthorized");
        dispatcher.forward(request, response);
    }
}
