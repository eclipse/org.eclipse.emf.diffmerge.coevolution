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
package org.eclipse.emf.diffmerge.bridge.util.structures;


/**
 * An implementation of 6-Tuples.
 * @param <E1> the type of the first element of the Tuple
 * @param <E2> the type of the second element of the Tuple
 * @param <E3> the type of the third element of the Tuple
 * @param <E4> the type of the fourth element of the Tuple
 * @param <E5> the type of the fifth element of the Tuple
 * @param <E6> the type of the sixth element of the Tuple
 * @author Olivier Constant
 */
public class Tuple6<E1, E2, E3, E4, E5, E6> extends Tuple5<E1, E2, E3, E4, E5> {
  
  /**
   * Constructor
   * @param e1_p the non-null first element of the Tuple
   * @param e2_p the non-null second element of the Tuple
   * @param e3_p the non-null third element of the Tuple
   * @param e4_p the non-null fourth element of the Tuple
   * @param e5_p the non-null fifth element of the Tuple
   * @param e6_p the non-null sixth element of the Tuple
   */
  public Tuple6(E1 e1_p, E2 e2_p, E3 e3_p, E4 e4_p, E5 e5_p, E6 e6_p) {
    super(e1_p, e2_p, e3_p, e4_p, e5_p, e6_p);
  }
  
  /**
   * Technical constructor
   * @param elements_p the non-null, non-empty list of non-null elements of the tuple
   * Duplicates are permitted.
   */
  protected Tuple6(Object... elements_p) {
    super(elements_p);
  }
  
  /**
   * Return the sixth element of the Tuple
   * @return a non-null object
   */
  public E6 get6() {
    @SuppressWarnings("unchecked") // OK by construction
    E6 result = (E6)get(6);
    return result;
  }
  
}
