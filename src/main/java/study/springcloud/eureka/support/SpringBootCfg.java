package study.springcloud.eureka.support;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

//服务注册和发现
@EnableEurekaServer

@SpringBootApplication(scanBasePackages = "study.springcloud.eureka")
public class SpringBootCfg {

}
