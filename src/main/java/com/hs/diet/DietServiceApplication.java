package com.hs.diet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EnableJpaRepositories("com.hs.diet.dao")
@ComponentScan(basePackages = {"com.hs.diet.controller", "com.hs.diet.service"})//手动指定bean组件扫描范围
public class DietServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DietServiceApplication.class, args);
    }
}
