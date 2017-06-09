/**
 * <copyright>
 * 
 * Copyright (c) 2015-2017 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.bridge.integration.transposer;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.emf.diffmerge.bridge.api.ICause;
import org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction;
import org.polarsys.kitalpha.transposer.transformation.context.TransformationKey;


/**
 * A bridge cause for Transposer transformations.
 * It simply wraps a Transposer transformation key.
 * @see TransformationKey
 */
public class TransposerBridgeCause implements ICause.Symbolic<Object> {
  
  /** The non-null transformation key with non-null source and role */
  private final TransformationKey _transformationKey;
  
  
  /**
   * Constructor
   * @param key_p a non-null Transposer transformation key with non-null source and role
   */
  public TransposerBridgeCause(TransformationKey key_p) {
    assert key_p != null;
    assert key_p.getSourceObject() != null;
    assert key_p.getRole() != null;
    _transformationKey = key_p;
  }
  
  /**
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object other_p) {
    boolean result = false;
    if (other_p instanceof TransposerBridgeCause) {
      TransposerBridgeCause peer = (TransposerBridgeCause)other_p;
      result = _transformationKey.equals(peer.getTransformationKey());
    }
    return result;
  }
  
  /**
   * Return the wrapped transformation key
   * @return a non-null transformation key with non-null source and role
   */
  public TransformationKey getTransformationKey() {
    return _transformationKey;
  }
  
  /**
   * Return the role that characterizes this cause
   * @return a non-null string
   */
  public String getRole() {
    return getTransformationKey().getRole();
  }
  
  /**
   * Return the source element that characterizes this cause
   * @return a non-null object
   */
  public Object getSource() {
    return getTransformationKey().getSourceObject();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.ICause.Symbolic#getSourceElements()
   */
  public Collection<Object> getSourceElements() {
    return Collections.singleton(getSource());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.ISymbolProvider#getSymbol(org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction)
   */
  public Object getSymbol(ISymbolFunction function_p) {
    String result = null;
    Object sourceIdentification = function_p.getSymbol(getSource());
    if (sourceIdentification != null) {
      StringBuilder builder = new StringBuilder();
      builder.append("Source["); //$NON-NLS-1$
      builder.append(sourceIdentification);
      builder.append("]Role["); //$NON-NLS-1$
      builder.append(getRole());
      builder.append(']');
      result = builder.toString();
    }
    return result;
  }
  
  /**
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    return _transformationKey.hashCode();
  }
  
}
