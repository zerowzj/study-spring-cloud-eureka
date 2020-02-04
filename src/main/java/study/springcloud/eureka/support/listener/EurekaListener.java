package study.springcloud.eureka.support.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EurekaListener {

    /**
     * 服务下线
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        event.getServerId();
        event.getAppName();
        log.info("EurekaInstanceCanceledEvent {}", event.getAppName());
    }

    /**
     * 服务注册
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        event.getInstanceInfo();
        event.getLeaseDuration();
        log.info("EurekaInstanceRegisteredEvent {}", event.getInstanceInfo());
    }

    /**
     * 服务续约
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        event.getServerId();
        event.getAppName();
        event.getInstanceInfo();
        log.info("EurekaInstanceRegisteredEvent {}", event.getAppName());
    }

    /**
     * 服务端启动事件
     */
    @EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        log.info("EurekaInstanceRegisteredEvent {}", event.getSource());
    }

    /**
     * 服务端可用事件
     */
    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        log.info("EurekaInstanceRegisteredEvent {}", event.getSource());
    }
}
