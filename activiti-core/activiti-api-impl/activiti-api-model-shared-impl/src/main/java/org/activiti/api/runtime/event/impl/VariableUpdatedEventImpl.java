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
package org.activiti.api.runtime.event.impl;

import org.activiti.api.model.shared.event.VariableUpdatedEvent;
import org.activiti.api.model.shared.model.VariableInstance;

public class VariableUpdatedEventImpl<T> extends VariableEventImpl implements VariableUpdatedEvent {

    private T previousValue;

    private boolean isEphemeralVariable;

    public VariableUpdatedEventImpl() {
    }

    public VariableUpdatedEventImpl(VariableInstance entity, T previousValue, boolean isEphemeralVariable) {
        super(entity);
        this.previousValue = previousValue;
        this.isEphemeralVariable = isEphemeralVariable;
    }

    @Override
    public VariableEvents getEventType() {
        return VariableEvents.VARIABLE_UPDATED;
    }

    @Override
    public T getPreviousValue() {
        return previousValue;
    }

    @Override
    public boolean isEphemeralVariable() {
        return isEphemeralVariable;
    }
}
