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
package org.eclipse.emf.diffmerge.bridge.incremental;

import java.util.Collections;

import org.eclipse.emf.diffmerge.api.scopes.IModelScope;
import org.eclipse.emf.diffmerge.impl.scopes.RootedModelScope;
import org.eclipse.emf.ecore.EObject;


/**
 * A model scope which is dedicated to holding intermediate targets in incremental transformations.
 * @author Olivier Constant
 */
public class IntermediateModelScope extends RootedModelScope {
  
  /** The optional source data set */
  protected final Object _sourceDataSet;
  
  /** The optional target data set */
  protected final IModelScope _targetDataSet;

  /**
   * Default constructor
   * 
   * @param sourceDataSet_p the (non-null) source data set
   * @param targetDataSet_p the (non-null) target data set
   */
  public IntermediateModelScope(Object sourceDataSet_p, IModelScope targetDataSet_p) {
    super(Collections.<EObject>emptyList());
    _sourceDataSet = sourceDataSet_p;
    _targetDataSet = targetDataSet_p;
  }
  
	/**
	 * @see org.eclipse.emf.diffmerge.impl.scopes.AbstractModelScope#getOriginator()
	 */
	@Override
	public Object getOriginator() {
		return Messages.IntermediateModelScope_Originator;
	}
	
  /**
   * Returns the backed target data set
   * @return the (non-null) target data set
   */
  public IModelScope getTargetDataSet() {
    return _targetDataSet;
  }
}
