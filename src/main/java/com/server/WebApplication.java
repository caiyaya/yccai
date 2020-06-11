package com.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.support.RegistrationPolicy;

@SpringBootApplication(scanBasePackages = {"com.server","com.github.tobato.fastdfs"})
@EnableConfigurationProperties
@MapperScan(basePackages = {"com.server.web.mapper"})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
