package study.springcloud.eureka.support.listener;

import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.event.HeartbeatEvent;
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

    @EventListener
    public void listen(HeartbeatEvent event) {
        //
        event.getValue();
        log.info(">>>>>>");
        log.info(">>>>>> service [{}  {}] hear beat");
        log.info(">>>>>>");
    }

    /**
     * 服务下线
     */
    @EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        //
        String appName = event.getAppName();
        //
        String serviceId = event.getServerId();
        log.info(">>>>>>");
        log.info(">>>>>> service [{}  {}] cancel", appName, serviceId);
        log.info(">>>>>>");
    }

    /**
     * 服务注册
     */
    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        //
        int leaseDuration = event.getLeaseDuration();
        //
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String id = instanceInfo.getId();
        String appName = instanceInfo.getAppName();

        log.info(">>>>>>");
        log.info(">>>>>> service [{}, {}] register",  appName, id);
        log.info(">>>>>>");
    }

    /**
     * 服务续约
     */
    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        //
        String appName = event.getAppName();
        //
        String serviceId = event.getServerId();

        event.getInstanceInfo();
        log.info(">>>>>>");
        log.info(">>>>>> service [{}, {}] renewal", appName, serviceId);
        log.info(">>>>>>");
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
