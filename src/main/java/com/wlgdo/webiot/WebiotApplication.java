package com.wlgdo.webiot;

import com.wlgdo.webiot.listenner.IoTApplicatonCloseEventListener;
import com.wlgdo.webiot.listenner.IoTApplicatonStartEventListener;
import com.wlgdo.webiot.netty.nettyserver.WebIoTNettyServer;
import com.wlgdo.webiot.netty.websocket.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import javax.annotation.PostConstruct;


/**
 * @author Ligang.Wang[Feify@wlgdo.com]
 */
@SpringBootApplication
public class WebiotApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(WebiotApplication.class);

        application.addListeners(new IoTApplicatonStartEventListener());
        application.addListeners(new IoTApplicatonCloseEventListener());
        application.run(args);

    }

    @PostConstruct
    public void init() throws Exception {
        WebIoTNettyServer.init();
        WebSocketServer.init();
    }

}
