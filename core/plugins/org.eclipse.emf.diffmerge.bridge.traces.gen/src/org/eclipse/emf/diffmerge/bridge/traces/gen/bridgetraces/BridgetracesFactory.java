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
package org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.BridgetracesPackage
 * @generated
 */
public interface BridgetracesFactory extends EFactory {
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  BridgetracesFactory eINSTANCE = org.eclipse.emf.diffmerge.bridge.traces.gen.bridgetraces.impl.BridgetracesFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Trace</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trace</em>'.
   * @generated
   */
  Trace createTrace();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  BridgetracesPackage getBridgetracesPackage();

} //BridgetracesFactory
