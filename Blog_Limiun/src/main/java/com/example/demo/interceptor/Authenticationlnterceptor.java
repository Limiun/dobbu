package com.example.demo.interceptor;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.annotation.PassToken;


import com.example.demo.annotation.UserLoginToken;
import com.example.demo.bean.User;
import com.example.demo.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;


public class Authenticationlnterceptor implements AsyncHandlerInterceptor {
    private static final org.slf4j.Logger logger =  LoggerFactory.getLogger(Authenticationlnterceptor.class);

    @Autowired
    UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean checkUser = false;
        boolean checkAnnotation = true;
        System.out.println(request.getRequestURI());
        String token = request.getHeader("token");
        logger.info("这里取到token："+token);

        if (!(handler instanceof HandlerMethod)){
            return true;
        }
        //检查是否有passtoken注释，有则跳过认证
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        if (method.isAnnotationPresent(PassToken.class)){
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        /**这里获取用户（如果有用户，把checkUser重置为true；**/

        //检测有没有需要用户权限的注解@UserLogin,有就需要对用户权限检测
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            checkAnnotation = false;
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId = null;
                int id = Integer.parseInt(userId);
                try {
                    userId = JWT.decode(token).getAudience().get(0);
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }
                User user = userService.getUserById(id);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new RuntimeException("401");
                }
                return true;
            }
        }

        if (checkUser&&checkAnnotation){
            return true;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
