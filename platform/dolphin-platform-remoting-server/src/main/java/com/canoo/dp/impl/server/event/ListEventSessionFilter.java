/*
 * Copyright 2015-2017 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.canoo.dp.impl.server.event;

import com.canoo.platform.remoting.server.event.EventSessionFilter;

import java.util.Arrays;
import java.util.List;

public class ListEventSessionFilter implements EventSessionFilter {

    private final List<String> sessionIds;

    public ListEventSessionFilter(String... sessionIds) {
        this.sessionIds = Arrays.asList(sessionIds);
    }

    @Override
    public boolean shouldHandleEvent(String s) {
        return sessionIds.contains(s);
    }
}

