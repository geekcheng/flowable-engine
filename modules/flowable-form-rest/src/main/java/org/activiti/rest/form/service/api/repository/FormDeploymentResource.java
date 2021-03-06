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
package org.activiti.rest.form.service.api.repository;

import org.activiti.form.api.FormDeployment;
import org.activiti.form.api.FormRepositoryService;
import org.activiti.form.engine.ActivitiFormObjectNotFoundException;
import org.activiti.rest.form.FormRestResponseFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Yvo Swillens
 */
@RestController
public class FormDeploymentResource {

  @Autowired
  protected FormRestResponseFactory formRestResponseFactory;

  @Autowired
  protected FormRepositoryService formRepositoryService;

  @RequestMapping(value = "/form-repository/deployments/{deploymentId}", method = RequestMethod.GET, produces = "application/json")
  public FormDeploymentResponse getFormDeployment(@PathVariable String deploymentId) {
    FormDeployment deployment = formRepositoryService.createDeploymentQuery().deploymentId(deploymentId).singleResult();

    if (deployment == null) {
      throw new ActivitiFormObjectNotFoundException("Could not find a form deployment with id '"+deploymentId);
    }

    return formRestResponseFactory.createFormDeploymentResponse(deployment);
  }

  @RequestMapping(value = "/form-repository/deployments/{deploymentId}", method = RequestMethod.DELETE, produces = "application/json")
  public void deleteFormDeployment(@PathVariable String deploymentId, HttpServletResponse response) {
    formRepositoryService.deleteDeployment(deploymentId);
    response.setStatus(HttpStatus.NO_CONTENT.value());
  }
}
