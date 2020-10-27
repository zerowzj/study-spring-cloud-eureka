package study.springcloud.eureka.support.listener;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.appinfo.LeaseInfo;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.util.Strings;
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
     * 服务注册
     */
    @EventListener
    public void registeredListen(EurekaInstanceRegisteredEvent event) {
        //
        int leaseDuration = event.getLeaseDuration();
        //实例信息
        InstanceInfo instanceInfo = event.getInstanceInfo();
        String id = instanceInfo.getId();
        String instanceId = instanceInfo.getInstanceId();
        String appName = instanceInfo.getAppName();

        log.info(">>>>>>");
        log.info(">>>>>> [{}, {}, {}] Register", appName, id, leaseDuration);
        log.info(">>>>>>");
    }

    /**
     * 服务续约
     */
    @EventListener
    public void renewedListen(EurekaInstanceRenewedEvent event) {
        //
        String appName = event.getAppName();
        //
        String serverId = event.getServerId();
        //实例信息
        InstanceInfo instanceInfo = event.getInstanceInfo();
        //续约信息
        LeaseInfo leaseInfo = instanceInfo.getLeaseInfo();
        leaseInfo.getDurationInSecs();
        leaseInfo.getEvictionTimestamp();
        leaseInfo.getRenewalIntervalInSecs();
        leaseInfo.getRenewalTimestamp();
        leaseInfo.getServiceUpTimestamp();

        log.info(">>>>>>");
        log.info(">>>>>> [{}, {}] Renewal", appName, serverId);
        log.info(">>>>>>");
    }

    /**
     * 服务下线
     */
    @EventListener
    public void canceledListen(EurekaInstanceCanceledEvent event) {
        //
        String appName = event.getAppName();
        //
        String serverId = event.getServerId();

        log.info(">>>>>>");
        log.info(">>>>>> [{}  {}] Cancel", appName, serverId);
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
