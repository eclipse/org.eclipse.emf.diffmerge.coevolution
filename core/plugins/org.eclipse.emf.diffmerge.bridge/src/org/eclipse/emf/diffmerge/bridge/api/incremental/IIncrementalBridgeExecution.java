/**
 * <copyright>
 * 
 * Copyright (c) 2014-2017 Thales Global Services S.A.S.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 * 
 * </copyright>
 */
package org.eclipse.emf.diffmerge.bridge.api.incremental;

import org.eclipse.emf.diffmerge.bridge.api.IBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeTrace;


/**
 * The execution of an incremental bridge.
 * @author Olivier Constant
 */
public interface IIncrementalBridgeExecution extends IBridgeExecution {
  
  /**
   * Return whether the transformation can actually be incremental,
   * given its internal state
   */
  boolean canBeIncremental();
  
  /**
   * Return context data for the interactive merge phase
   * @return a potentially null object
   */
  Object getInteractiveMergeData();
  
  /**
   * Return the trace of the former execution, if any
   * @return a potentially null object
   */
  IBridgeTrace getReferenceTrace();
  
  /**
   * Return whether the transformation is actually incremental,
   * given the execution context
   * Invariant: isActuallyIncremental() => canBeIncremental()
   */
  boolean isActuallyIncremental();
  
  /**
   * Return whether the interactive merge phase must be deferred, if any
   */
  boolean mustDeferInteractiveMerge();
  
  
  /**
   * Modifiable extension of IIncrementalBridgeExecution.
   */
  interface Editable extends IIncrementalBridgeExecution, IBridgeExecution.Editable {
    /**
     * Set whether the interactive merge phase must be deferred, if any
     */
    void setDeferInteractiveMerge(boolean deferInteractiveMerge_p);
    /**
     * Set context data for the interactive merge phase
     * @param mergeData_p a potentially null object
     */
    void setInteractiveMergeData(Object mergeData_p);
    /**
     * Set the trace of the former execution
     * @param referenceTrace_p a potentially null object
     */
    void setReferenceTrace(IBridgeTrace referenceTrace_p);
  }
  
}
