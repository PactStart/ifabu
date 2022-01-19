package io.github.pactstart.ifabu.configuration.mvc;

import io.github.pactstart.ifabu.component.UserTokenManager;
import io.github.pactstart.ifabu.configuration.AppException;
import io.github.pactstart.ifabu.entity.User;
import io.github.pactstart.ifabu.errorcode.ResponseCode;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpInterceptor extends HandlerInterceptorAdapter {

    private UserTokenManager userTokenManager;

    public HttpInterceptor(UserTokenManager userTokenManager) {
        this.userTokenManager = userTokenManager;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        if(requestURI.startsWith("/app")) {
            String token = request.getHeader("token");
            User user = userTokenManager.getUserByToken(token);
            if(user == null) {
                AppException e = new AppException();
                e.setResponseCode(ResponseCode.NOT_LOGIN);
                throw e;
            }
        }
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
