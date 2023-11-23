package org.jacky;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;

@Service
@EnableDubbo
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class UserConsumerApplication {

    @DubboReference
    private UserService userService;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(UserConsumerApplication.class, args);
        UserConsumerApplication application = context.getBean(UserConsumerApplication.class);
        User user = application.getUserById(1);
        System.out.println(new Date() + " Receive result ======> " + user);
    }

    public User getUserById(int userId) {
        return userService.getUserById(userId);
    }
}
