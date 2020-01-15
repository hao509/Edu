package com.yang.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.yang.edu.dao")
//@EnableTransactionManagement
public class EduApplication {
    public static void main( String [] args) {
        SpringApplication.run(EduApplication.class,args);
    }
}
