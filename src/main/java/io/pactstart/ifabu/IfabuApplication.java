package io.pactstart.ifabu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = {"io.pactstart.ifabu.dao"})
@Controller
@SpringBootApplication
public class IfabuApplication {

    public static void main(String[] args) {
        SpringApplication.run(IfabuApplication.class, args);
    }

    @ResponseBody
    @RequestMapping("/healthCheck")
    public Object healthCheck() {
        return "hello,world";
    }
}
