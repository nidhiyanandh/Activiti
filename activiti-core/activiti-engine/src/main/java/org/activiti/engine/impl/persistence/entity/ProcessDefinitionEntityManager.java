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

package org.activiti.engine.impl.persistence.entity;

import java.util.List;
import java.util.Map;

import org.activiti.engine.api.internal.Internal;
import org.activiti.engine.impl.Page;
import org.activiti.engine.impl.ProcessDefinitionQueryImpl;
import org.activiti.engine.repository.ProcessDefinition;

/**

 */
@Internal
public interface ProcessDefinitionEntityManager extends EntityManager<ProcessDefinitionEntity> {

  ProcessDefinitionEntity findLatestProcessDefinitionByKey(String processDefinitionKey);

  ProcessDefinitionEntity findLatestProcessDefinitionByKeyAndTenantId(String processDefinitionKey, String tenantId);

  List<ProcessDefinition> findProcessDefinitionsByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery, Page page);

  long findProcessDefinitionCountByQueryCriteria(ProcessDefinitionQueryImpl processDefinitionQuery);

  ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKey(String deploymentId, String processDefinitionKey);

  ProcessDefinitionEntity findProcessDefinitionByDeploymentAndKeyAndTenantId(String deploymentId, String processDefinitionKey, String tenantId);

  ProcessDefinition findProcessDefinitionByKeyAndVersionAndTenantId(String processDefinitionKey, Integer processDefinitionVersion, String tenantId);

  List<ProcessDefinition> findProcessDefinitionsByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults);

  long findProcessDefinitionCountByNativeQuery(Map<String, Object> parameterMap);

  void updateProcessDefinitionTenantIdForDeployment(String deploymentId, String newTenantId);

  void deleteProcessDefinitionsByDeploymentId(String deploymentId);
}
