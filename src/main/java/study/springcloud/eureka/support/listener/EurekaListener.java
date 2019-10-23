package study.springcloud.eureka.support.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EurekaListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaListener.class);

    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        LOGGER.info("EurekaInstanceCanceledEvent {}", event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        LOGGER.info("EurekaInstanceRegisteredEvent {}", event.getInstanceInfo());
    }

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        LOGGER.info("EurekaInstanceRegisteredEvent {}", event.getAppName());
    }
}
