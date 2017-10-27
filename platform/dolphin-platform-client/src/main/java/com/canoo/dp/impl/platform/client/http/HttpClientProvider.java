package com.canoo.dp.impl.platform.client.http;

import com.canoo.dp.impl.platform.client.AbstractServiceProvider;
import com.canoo.platform.client.ClientConfiguration;
import com.canoo.platform.client.PlatformClient;
import com.canoo.platform.core.http.HttpClient;
import com.canoo.platform.core.http.HttpURLConnectionFactory;
import com.canoo.platform.core.http.spi.RequestHandlerProvider;
import com.canoo.platform.core.http.spi.ResponseHandlerProvider;
import com.google.gson.Gson;
import org.apiguardian.api.API;

import java.util.Iterator;
import java.util.ServiceLoader;

import static org.apiguardian.api.API.Status.INTERNAL;

@API(since = "0.x", status = INTERNAL)
public class HttpClientProvider extends AbstractServiceProvider<HttpClient> {

    public HttpClientProvider() {
        super(HttpClient.class);
    }

    @Override
    protected HttpClient createService(ClientConfiguration configuration) {
        final HttpURLConnectionFactory connectionFactory = configuration.getHttpURLConnectionFactory();
        final HttpClientImpl client = new HttpClientImpl(PlatformClient.getService(Gson.class), connectionFactory, configuration);

        final ServiceLoader<RequestHandlerProvider> requestLoader = ServiceLoader.load(RequestHandlerProvider.class);
        final Iterator<RequestHandlerProvider> requestIterator = requestLoader.iterator();
        while (requestIterator.hasNext()) {
            client.addRequestHandler(requestIterator.next().getHandler(configuration));
        }

        final ServiceLoader<ResponseHandlerProvider> responseLoader = ServiceLoader.load(ResponseHandlerProvider.class);
        final Iterator<ResponseHandlerProvider> responseIterator = responseLoader.iterator();
        while (responseIterator.hasNext()) {
            client.addResponseHandler(responseIterator.next().getHandler(configuration));
        }
        return client;
    }
}
