package com.canoo.dolphin.integration.server.listener;

import com.canoo.platform.server.ServerListener;
import com.canoo.platform.server.client.ClientSession;
import com.canoo.platform.server.client.ClientSessionListener;
import com.canoo.platform.remoting.server.event.RemotingEventBus;

import javax.inject.Inject;

@ServerListener
public class TestClientSessionListener implements ClientSessionListener {

    @Inject
    private RemotingEventBus eventBus;

    public static boolean eventBusInjected = false;

    @Override
    public void sessionCreated(ClientSession clientSession) {
        eventBusInjected = (eventBus != null);
    }

    @Override
    public void sessionDestroyed(ClientSession clientSession) {

    }
}
