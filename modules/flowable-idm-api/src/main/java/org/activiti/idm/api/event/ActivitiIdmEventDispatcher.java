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
package org.activiti.idm.api.event;

/**
 * Dispatcher which allows for adding and removing {@link ActivitiIdmEventListener} s to the Activiti IDM Engine as well as dispatching {@link ActivitiIdmEvent} to all the listeners registered.
 * 
 * @author Tijs Rademakers
 */
public interface ActivitiIdmEventDispatcher {

  /**
   * Adds an event-listener which will be notified of ALL events by the dispatcher.
   * 
   * @param listenerToAdd
   *          the listener to add
   */
  void addEventListener(ActivitiIdmEventListener listenerToAdd);

  /**
   * Adds an event-listener which will only be notified when an event of the given types occurs.
   * 
   * @param listenerToAdd
   *          the listener to add
   * @param types
   *          types of events the listener should be notified for
   */
  void addEventListener(ActivitiIdmEventListener listenerToAdd, ActivitiIdmEventType... types);

  /**
   * Removes the given listener from this dispatcher. The listener will no longer be notified, regardless of the type(s) it was registered for in the first place.
   * 
   * @param listenerToRemove
   *          listener to remove
   */
  void removeEventListener(ActivitiIdmEventListener listenerToRemove);

  /**
   * Dispatches the given event to any listeners that are registered.
   * 
   * @param event
   *          event to dispatch.
   */
  void dispatchEvent(ActivitiIdmEvent event);

  /**
   * @param enabled
   *          true, if event dispatching should be enabled.
   */
  void setEnabled(boolean enabled);

  /**
   * @return true, if event dispatcher is enabled.
   */
  boolean isEnabled();
}
