package com.canoo.platform.remoting.server.event;

import com.canoo.dp.impl.platform.core.Assert;
import com.canoo.dp.impl.server.event.ListEventSessionFilter;

/**
 * A factory that provides some common implementations for the {@link EventSessionFilter}.
 *
 * @author Hendrik Ebbers
 */
public class EventSessionFilterFactory {

    /**
     * Creates a {@link EventSessionFilter} that allows subscriptions for all client sessions (see {@link com.canoo.platform.server.client.ClientSession}) of the given session ids
     * @param clientSessionIds the ids for all allowed client sessions
     * @return the filter
     */
    public static EventSessionFilter allowClientSessions(final String... clientSessionIds) {
        return new ListEventSessionFilter(clientSessionIds);
    }

    /**
     * Creates a {@link EventSessionFilter} that blocks subscriptions for all client sessions (see {@link com.canoo.platform.server.client.ClientSession}) of the given session ids
     * @param clientSessionIds the ids for all blocked client sessions
     * @return the filter
     */
    public static EventSessionFilter excludeClientSessions(final String... clientSessionIds) {
        return not(allowClientSessions(clientSessionIds));
    }

    /**
     * Returns a filter that negates the result of the given filter
     * @param filter the given filter
     * @return the filter
     */
    public static EventSessionFilter not(final EventSessionFilter filter) {
        Assert.requireNonNull(filter, "filter");
        return new EventSessionFilter() {

            @Override
            public boolean shouldHandleEvent(final String sessionId) {
                return !filter.shouldHandleEvent(sessionId);
            }
        };
    }

    /**
     * Returns a filter that only allow a client session if it is allowed by all given filters.
     * @param filters given filters
     * @return the filter
     */
    public static EventSessionFilter and(final EventSessionFilter... filters) {
        return new EventSessionFilter() {
            @Override
            public boolean shouldHandleEvent(String sessionId) {
                for(EventSessionFilter filter : filters) {
                    if(!filter.shouldHandleEvent(sessionId)) {
                        return false;
                    }
                }
                return true;
            }
        };
    }

    /**
     * Returns a filter that only allow a client session if it is allowed by at least one of the given filters.
     * @param filters given filters
     * @return the filter
     */
    public static EventSessionFilter or(final EventSessionFilter... filters) {
        return new EventSessionFilter() {
            @Override
            public boolean shouldHandleEvent(String sessionId) {
                for(EventSessionFilter filter : filters) {
                    if(filter.shouldHandleEvent(sessionId)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

}
