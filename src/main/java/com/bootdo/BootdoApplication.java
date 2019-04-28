package com.bootdo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bootdo.common.exception.ValidateMessage;
import com.bootdo.system.config.CommonImport;

@EnableAutoConfiguration(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.bootdo.*.dao")
@SpringBootApplication
@EnableCaching
@Import(value= {CommonImport.class,ValidateMessage.class})
public class BootdoApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootdoApplication.class, args);
//        System.out.println("ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
//                " ______                    _   ______            \n" +
//                "|_   _ \\                  / |_|_   _ `.          \n" +
//                "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
//                "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
//                " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
//                "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  ");
    }
}
