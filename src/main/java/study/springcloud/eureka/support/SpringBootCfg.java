package study.springcloud.eureka.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication(scanBasePackages = "study.springcloud.eureka",
        exclude = {SecurityAutoConfiguration.class})
public class SpringBootCfg {

}
