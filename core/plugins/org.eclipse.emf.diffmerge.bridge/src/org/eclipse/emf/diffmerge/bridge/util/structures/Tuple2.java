/**
 * <copyright>
 * 
 * Copyright (c) 2014 Thales Global Services S.A.S.
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
package org.eclipse.emf.diffmerge.bridge.util.structures;


/**
 * An implementation of 2-Tuples (couples).
 * @param <E1> the type of the first element of the Tuple
 * @param <E2> the type of the second element of the Tuple
 * @author Olivier Constant
 */
public class Tuple2<E1, E2> extends Tuple1<E1> {
  
  /**
   * Constructor
   * @param e1_p the non-null first element of the Tuple
   * @param e2_p the non-null second element of the Tuple
   */
  public Tuple2(E1 e1_p, E2 e2_p) {
    super(e1_p, e2_p);
  }
  
  /**
   * Technical constructor
   * @param elements_p the non-null, non-empty list of non-null elements of the tuple
   * Duplicates are permitted.
   */
  protected Tuple2(Object... elements_p) {
    super(elements_p);
  }
  
  /**
   * Return the second element of the Tuple
   * @return a non-null object
   */
  public E2 get2() {
    @SuppressWarnings("unchecked") // OK by construction
    E2 result = (E2)get(2);
    return result;
  }
  
}
