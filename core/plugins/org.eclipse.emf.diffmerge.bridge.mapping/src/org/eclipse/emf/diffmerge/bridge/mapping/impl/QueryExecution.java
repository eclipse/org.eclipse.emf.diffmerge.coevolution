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
package org.eclipse.emf.diffmerge.bridge.mapping.impl;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryIdentifier;


/**
 * A simple implementation of IQueryExecution.
 * @see IQueryExecution
 * @author Olivier Constant
 */
public class QueryExecution implements IQueryExecution {
  
  /** The possibly null super-execution */
  private final QueryExecution _superExecution;
  
  /** The possibly null query ID, non-null if and only if _superExecution is not null */
  private final IQueryIdentifier<?> _queryID;
  
  /** The possibly null value for the query ID */
  private final Object _value;
  
  
  /**
   * Constructor
   */
  public QueryExecution() {
    _superExecution = null;
    _queryID = null;
    _value = null;
  }
  
  /**
   * Constructor
   * @param superExecution_p a non-null execution
   * @param queryID_p a non-null query ID
   * @param value_p a potentially null object
   */
  protected QueryExecution(QueryExecution superExecution_p,
      IQueryIdentifier<?> queryID_p, Object value_p) {
    assert superExecution_p != null && queryID_p != null;
    _superExecution = superExecution_p;
    _queryID = queryID_p;
    _value = value_p;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution#get(org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery)
   */
  public <O> O get(IQuery<?, O> query_p) {
    return get(query_p.getID());
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution#get(org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryIdentifier)
   */
  @SuppressWarnings("unchecked")
  public <O> O get(IQueryIdentifier<O> queryID_p) {
    if (queryID_p.equals(_queryID))
      return (O)_value;
    return _superExecution.get(queryID_p);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution#getAll()
   */
  public List<Object> getAll() {
    List<Object> result;
    QueryExecution superEnv = getSuperExecution();
    if (superEnv == null) {
      result = new LinkedList<Object>();
    } else {
      result = superEnv.getAll();
      result.add(_value);
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution#getLast()
   */
  public Object getLast() {
    return _value;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution#getQueryIdentifiers()
   */
  public List<IQueryIdentifier<?>> getQueryIdentifiers() {
    List<IQueryIdentifier<?>> result;
    QueryExecution superEnv = getSuperExecution();
    if (superEnv == null) {
      result = new LinkedList<IQueryIdentifier<?>>();
    } else {
      result = superEnv.getQueryIdentifiers();
      result.add(_queryID);
    }
    return result;
  }
  
  /**
   * Return the super-query execution onto which this query execution is defined
   * @return the possibly null super execution
   */
  public QueryExecution getSuperExecution() {
    return _superExecution;
  }
  
  /**
   * Return whether this query execution is an ancestor of the given one, i.e., the
   * given one originates from this one and includes one or more additional query results.
   * If the given query execution is equal to this one then false is returned.
   * @param peer_p a non-null query execution
   */
  public boolean isAncestorOf(IQueryExecution peer_p) {
    if (peer_p instanceof QueryExecution) {
      QueryExecution superExec = ((QueryExecution)peer_p).getSuperExecution();
      while (superExec != null) {
        if (equals(superExec))
          return true;
        superExec = superExec.getSuperExecution();
      }
    }
    return false;
  }
  
  /**
   * Return whether this query execution is an ancestor of the given one, i.e., the
   * given one originates from this one and includes one or more additional query results.
   * If the given query execution is equal to this one then true is returned.
   * @param peer_p a non-null query execution
   */
  public boolean isAncestorOrEquals(IQueryExecution peer_p) {
    return equals(peer_p)? true: isAncestorOf(peer_p);
  }
  
  /**
   * Create and return a new query execution that extends the given one with the given data
   * @param queryID_p a non-null query ID
   * @param value_p a non-null object
   * @return a non-null object
   */
  public <O> QueryExecution newWith(IQueryIdentifier<O> queryID_p, O value_p) {
    return new QueryExecution(this, queryID_p, value_p);
  }
  
}
