package cn.neilshi.springlearning.ioc.config;

import cn.neilshi.springlearning.ioc.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    /**
     * @Bean 装载该方法的返回值到IOC容器，指定name为Bean的名称
     * 若不指定name，Bean名称为方法名
     * */
    @Bean(name = "user")
    public User getUser() {
        User user = new User();
        user.setId(1l);
        user.setName("jack");
        return user;
    }
}
