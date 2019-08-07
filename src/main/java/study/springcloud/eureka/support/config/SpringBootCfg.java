package study.springcloud.eureka.support.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "study.springcloud.eureka")
public class SpringBootCfg {

}
