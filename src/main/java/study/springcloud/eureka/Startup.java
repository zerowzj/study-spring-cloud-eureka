package study.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import study.springcloud.eureka.support.config.SpringBootCfg;

public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
