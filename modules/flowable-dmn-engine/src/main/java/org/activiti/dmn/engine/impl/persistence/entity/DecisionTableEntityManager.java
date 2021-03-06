/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.dmn.engine.impl.persistence.entity;

import java.util.List;
import java.util.Map;

import org.activiti.dmn.api.DecisionTable;
import org.activiti.dmn.engine.impl.DecisionTableQueryImpl;
import org.activiti.dmn.engine.impl.Page;

/**
 * @author Joram Barrez
 */
public interface DecisionTableEntityManager extends EntityManager<DecisionTableEntity> {

  DecisionTableEntity findLatestDecisionTableByKey(String decisionTableKey);

  DecisionTableEntity findLatestDecisionTableByKeyAndTenantId(String decisionTableKey, String tenantId);
  
  DecisionTableEntity findLatestDecisionTableByKeyAndParentDeploymentId(String decisionTableKey, String parentDeploymentId);
  
  DecisionTableEntity findLatestDecisionTableByKeyParentDeploymentIdAndTenantId(String decisionTableKey, 
      String parentDeploymentId, String tenantId);

  List<DecisionTable> findDecisionTablesByQueryCriteria(DecisionTableQueryImpl decisionTableQuery, Page page);

  long findDecisionTableCountByQueryCriteria(DecisionTableQueryImpl decisionTableQuery);

  DecisionTableEntity findDecisionTableByDeploymentAndKey(String deploymentId, String decisionTableKey);

  DecisionTableEntity findDecisionTableByDeploymentAndKeyAndTenantId(String deploymentId, String decisionTableKey, String tenantId);

  DecisionTableEntity findDecisionTableByKeyAndVersionAndTenantId(String decisionTableKey, Integer processDefinitionVersion, String tenantId);

  List<DecisionTable> findDecisionTablesByNativeQuery(Map<String, Object> parameterMap, int firstResult, int maxResults);

  long findDecisionTableCountByNativeQuery(Map<String, Object> parameterMap);

  void updateDecisionTableTenantIdForDeployment(String deploymentId, String newTenantId);
  
  void deleteDecisionTablesByDeploymentId(String deploymentId);

}