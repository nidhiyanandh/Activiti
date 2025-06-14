/*
 * Copyright 2010-2020 Alfresco Software, Ltd.
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

package org.activiti.spring.boot.process.listener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.activiti.api.model.shared.event.VariableCreatedEvent;
import org.activiti.api.runtime.shared.events.VariableEventListener;
import org.springframework.stereotype.Component;

@Component
public class VariableCreatedListener implements VariableEventListener<VariableCreatedEvent> {

    private final List<VariableCreatedEvent> events = new ArrayList<>();

    @Override
    public void onEvent(VariableCreatedEvent event) {
        events.add(event);
    }

    public void clear() {
        events.clear();
    }

    public List<VariableCreatedEvent> getEvents() {
        return Collections.unmodifiableList(events);
    }
}
