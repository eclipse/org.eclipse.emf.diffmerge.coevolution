/*********************************************************************
 * Copyright (c) 2014-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.bridge.operations;

import org.apache.log4j.Logger;
import org.eclipse.emf.diffmerge.bridge.Messages;
import org.eclipse.emf.diffmerge.bridge.api.IBridge;
import org.eclipse.emf.diffmerge.bridge.api.IBridgeExecution;
import org.eclipse.emf.diffmerge.bridge.impl.AbstractBridge;
import org.eclipse.emf.diffmerge.generic.impl.helpers.AbstractExpensiveOperation;


/**
 * A base operation that executes a bridge between data sets.
 * @author Olivier Constant
 */
public abstract class AbstractBridgeOperation extends AbstractExpensiveOperation {
  
  /** The source data set */
  private final Object _sourceDataSet;
  
  /** The target data set */
  private final Object _targetDataSet;
  
  /** The bridge specification */
  private final IBridge<?,?> _bridge;
  
  /** The non-null bridge execution */
  private final IBridgeExecution _bridgeExecution;
  
  
  /**
   * Constructor
   * @param sourceDataSet_p the non-null source data set
   * @param targetDataSet_p the non-null target data set
   * @param bridge_p the non-null bridge to execute
   * @param execution_p a non-null execution for the bridge
   */
  public AbstractBridgeOperation(Object sourceDataSet_p, Object targetDataSet_p,
      IBridge<?,?> bridge_p, IBridgeExecution execution_p) {
    _sourceDataSet = sourceDataSet_p;
    _targetDataSet = targetDataSet_p;
    _bridge = bridge_p;
    _bridgeExecution = execution_p;
  }
  
  /**
   * Return the bridge specification for the operation
   * @return a non-null object
   */
  public IBridge<?,?> getBridge() {
    return _bridge;
  }
  
  /**
   * Return the bridge execution
   * @return a non-null object
   */
  public IBridgeExecution getBridgeExecution() {
    return _bridgeExecution;
  }
  
  /**
   * Return a logger for this operation
   * @return a non-null logger
   */
  protected Logger getLogger() {
    Logger result;
    IBridge<?,?> bridge = getBridge();
    if (bridge instanceof AbstractBridge<?,?>) {
      result = ((AbstractBridge<?,?>)bridge).getLogger();
    } else {
      result = Logger.getLogger(AbstractBridge.class);
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.generic.util.IExpensiveOperation#getOperationName()
   */
  public String getOperationName() {
    return Messages.AbstractBridgeOperation_Name;
  }
  
  /**
   * Return the source data set
   * @return a non-null object
   */
  public Object getSourceDataSet() {
    return _sourceDataSet;
  }
  
  /**
   * Return the target data set
   * @return a non-null object
   */
  public Object getTargetDataSet() {
    return _targetDataSet;
  }
  
}