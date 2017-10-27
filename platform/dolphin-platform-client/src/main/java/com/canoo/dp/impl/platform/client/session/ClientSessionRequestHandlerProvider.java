package com.canoo.dp.impl.platform.client.session;

import com.canoo.platform.client.PlatformClient;
import com.canoo.platform.client.session.ClientSessionStore;
import com.canoo.platform.core.PlatformConfiguration;
import com.canoo.platform.core.http.HttpURLConnectionHandler;
import com.canoo.platform.core.http.spi.RequestHandlerProvider;
import org.apiguardian.api.API;

import static org.apiguardian.api.API.Status.INTERNAL;

@API(since = "0.x", status = INTERNAL)
public class ClientSessionRequestHandlerProvider implements RequestHandlerProvider {
    @Override
    public HttpURLConnectionHandler getHandler(PlatformConfiguration configuration) {
        return new ClientSessionRequestHandler(PlatformClient.getService(ClientSessionStore.class));
    }
}
