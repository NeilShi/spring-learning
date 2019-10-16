package cn.neilshi.springlearning.ioc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ComponentScan 自动扫描
 * */
@Configuration
@ComponentScan("cn.neilshi.springlearning.ioc.*")
public class ApplicationScanConfig {
}
