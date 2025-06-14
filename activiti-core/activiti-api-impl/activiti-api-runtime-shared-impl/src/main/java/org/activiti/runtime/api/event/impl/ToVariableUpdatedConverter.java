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
package org.activiti.runtime.api.event.impl;

import org.activiti.api.model.shared.event.VariableUpdatedEvent;
import org.activiti.api.runtime.event.impl.VariableUpdatedEventImpl;
import org.activiti.api.runtime.model.impl.VariableInstanceImpl;
import org.activiti.engine.delegate.event.ActivitiVariableUpdatedEvent;

import java.util.Optional;

public class ToVariableUpdatedConverter implements EventConverter<VariableUpdatedEvent, ActivitiVariableUpdatedEvent> {

    private final EphemeralVariableResolver ephemeralVariableResolver;

    public ToVariableUpdatedConverter(EphemeralVariableResolver ephemeralVariableResolver) {
        this.ephemeralVariableResolver = ephemeralVariableResolver;
    }

    @Override
    public Optional<VariableUpdatedEvent> from(ActivitiVariableUpdatedEvent internalEvent) {
        boolean isEphemeral = ephemeralVariableResolver.isEphemeralVariable(internalEvent);

        VariableInstanceImpl<Object> variableInstance = createVariableInstance(internalEvent, isEphemeral);
        Object previousValue = isEphemeral? null : internalEvent.getVariablePreviousValue();

        return Optional.of(new VariableUpdatedEventImpl<>(variableInstance, previousValue, isEphemeral));
    }
}
