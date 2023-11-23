package org.jacky;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;

@EnableDubbo
@SpringBootApplication
@MapperScan("org.jacky.dao")
public class UserProviderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(UserProviderApplication.class, args);
        Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sqlSessionFactory.openSession();
    }

}