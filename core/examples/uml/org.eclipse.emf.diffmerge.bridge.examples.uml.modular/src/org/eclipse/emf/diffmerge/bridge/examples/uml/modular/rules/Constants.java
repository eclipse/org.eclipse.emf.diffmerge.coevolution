/*********************************************************************
 * Copyright (c) 2015-2019 Thales Global Services S.A.S.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Thales Global Services S.A.S. - initial API and implementation
 **********************************************************************/
package org.eclipse.emf.diffmerge.bridge.examples.uml.modular.rules;


/**
 * The location of common constants.
 * @author Olivier Constant
 */
public interface Constants {
  
  /** For the rule that uses EnumStructs */
  public enum AssocElements {
    /** The UML association */
    ASSOC,
    /** The source property of the association */
    SRC_PROP,
    /** The target property of the association */
    TARGET_PROP
  }
  
}
