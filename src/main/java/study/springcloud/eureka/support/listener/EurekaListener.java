package study.springcloud.eureka.support.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
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
        String serviceId = event.getServerId();
        String appName = event.getAppName();
        log.info(">>>>>> service [{}  {}] cancel", appName, serviceId);
    }

    /**
     * 服务注册
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String id = instanceInfo.getId();
        String appName = instanceInfo.getAppName();
        int leaseDuration = event.getLeaseDuration();
        log.info(">>>>>> service [{}, {}] register",  appName, id);
    }

    /**
     * 服务续约
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        String serviceId = event.getServerId();
        String appName = event.getAppName();
        event.getInstanceInfo();
        log.info(">>>>>> service [{}, {}] renewal", appName, serviceId);
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
