package study.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import study.springcloud.eureka.support.config.SpringBootCfg;

/**
 * 入口
 *
 * @author wangzhj
 */
public class Startup {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCfg.class, args);
    }
}
