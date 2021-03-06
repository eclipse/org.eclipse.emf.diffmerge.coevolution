/*********************************************************************
 * Copyright (c) 2018 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.bridge.mapping.impl;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IRule;


/**
 * A base implementation of IRule.
 * @param <S> the type of source data
 * @param <TRS> the type of the source subset that traces the target
 * @param <T> the type of target data
 * @see IRule
 * @author Olivier Constant
 */
public abstract class CommonRule<S, TRS, T>
implements IRule<S, TRS, T> {
  
  /** The non-null identifier of the rule */
  private final CommonRuleIdentifier<S, TRS, T> _identifier;
  
  /** The non-null query providing input data */
  private IQuery<?, ? extends S> _query;
  
  
  /**
   * Default constructor for a randomly generated ID
   * @param provider_p a non-null input provider
   */
  public CommonRule(IQuery<?, ? extends S> provider_p) {
    this(provider_p, new CommonRuleIdentifier<S, TRS, T>());
  }
  
  /**
   * Constructor
   * @param provider_p a non-null input provider
   * @param id_p the non-null identifier of the rule
   */
  public CommonRule(IQuery<?, ? extends S> provider_p, String id_p) {
    this(provider_p, new CommonRuleIdentifier<S, TRS, T>(id_p));
  }
  
  /**
   * Constructor
   * @param provider_p a non-null input provider
   * @param id_p the non-null identifier of the rule
   */
  public CommonRule(IQuery<?, ? extends S> provider_p, CommonRuleIdentifier<S, TRS, T> id_p) {
    _query = provider_p;
    _query.accept(this);
    _identifier = id_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.IIdentifiedWithType#getID()
   */
  public CommonRuleIdentifier<S, TRS, T> getID() {
    return _identifier;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IRule#getInputProvider()
   */
  public IQuery<?, ? extends S> getInputProvider() {
    return _query;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.api.ISymbolProvider#getSymbol(org.eclipse.emf.diffmerge.bridge.api.ISymbolFunction)
   */
  public Object getSymbol(ISymbolFunction function_p) {
    return function_p.getSymbol(getID());
  }
  
  /**
   * Return a new iterable over elements of the given type
   * @param <TYPE> the type of the elements
   * @return a non-null, modifiable, empty list
   */
  protected <TYPE> List<TYPE> newIterable() {
    return new LinkedList<TYPE>();
  }
  
  /**
   * Return an iterable over the given elements
   * @param elements_p a possibly empty, possibly null array or sequence of parameters
   * @return a non-null, non-modifiable list
   */
  protected <TYPE> List<TYPE> newIterable(TYPE... elements_p) {
    if (elements_p == null || elements_p.length == 0 ||
        elements_p.length == 1 && elements_p[0] == null)
      return Collections.emptyList();
    return Arrays.asList(elements_p);
  }
  
}
