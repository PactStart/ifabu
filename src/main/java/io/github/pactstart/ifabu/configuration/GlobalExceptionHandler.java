package io.github.pactstart.ifabu.configuration;

import io.github.pactstart.ifabu.errorcode.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

@Component
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseCode bindExceptionHandler(BindException e) {
        StringBuilder sb = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(item -> {
            String msg = item.getDefaultMessage();
            if (msg != null) {
                msg = msg.trim();
            }
            if (msg.length() > 1 && msg.charAt(0) == '{' && msg.charAt(msg.length() - 1) == '}') {
                msg = msg.substring(1, msg.length() - 1);
            }
            sb.append(msg);
        });
        return new ResponseCode(ResponseCode.BAD_REQUEST.getCode(), sb.toString());
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseCode constraintViolationExceptionHandler(ConstraintViolationException e) {
        StringBuilder sb = new StringBuilder();
        e.getConstraintViolations().forEach(item -> {
            String msg = item.getMessage();
            if (msg != null) {
                msg = msg.trim();
            }
            if (msg.length() > 1 && msg.charAt(0) == '{' && msg.charAt(msg.length() - 1) == '}') {
                msg = msg.substring(1, msg.length() - 1);
            }
            sb.append(msg);
        });
        return new ResponseCode(ResponseCode.BAD_REQUEST.getCode(), sb.toString());
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseCode methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        e.getBindingResult().getAllErrors().forEach(item -> {
            String msg = item.getDefaultMessage();
            if (msg != null) {
                msg = msg.trim();
            }
            if (msg.length() > 1 && msg.charAt(0) == '{' && msg.charAt(msg.length() - 1) == '}') {
                msg = msg.substring(1, msg.length() - 1);
            }
            sb.append(msg);
        });
        return new ResponseCode(ResponseCode.BAD_REQUEST.getCode(), sb.toString());
    }

    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseBody
    public ResponseCode missingRequestHeaderException(MissingRequestHeaderException e) {
        return new ResponseCode(ResponseCode.BAD_REQUEST.getCode(), e.getMessage());
    }

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseCode appException(AppException e) {
        return e.getResponseCode() != null ? e.getResponseCode() : ResponseCode.SYSTEM_ERROR;
    }

}
