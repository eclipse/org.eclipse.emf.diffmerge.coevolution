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
package org.eclipse.emf.diffmerge.bridge.impl;

import org.eclipse.emf.diffmerge.bridge.api.INamedElement;


/**
 * A straightforward implementation of INamedElement.
 * @author Olivier Constant
 */
public abstract class AbstractNamedElement implements INamedElement {
  
  /** The empty string */
  protected static final String EMPTY_STRING = ""; //$NON-NLS-1$
  
  /** The non-null name */
  private final String _name;
  
  
  /**
   * Default constructor for empty name
   */
  protected AbstractNamedElement() {
    this(EMPTY_STRING);
  }
  
  /**
   * Constructor
   * @param name_p the non-null name
   */
  protected AbstractNamedElement(String name_p) {
    assert name_p != null;
    _name = name_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.INamedElement#getName()
   */
  public String getName() {
    return _name;
  }
  
}
