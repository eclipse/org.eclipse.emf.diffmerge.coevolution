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
package org.eclipse.emf.diffmerge.bridge.examples.uml.modular.queries;

import java.util.List;

import org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution;
import org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryHolder;
import org.eclipse.emf.diffmerge.bridge.mapping.impl.QueryAndRule;
import org.eclipse.uml2.uml.Component;
import org.eclipse.uml2.uml.UMLFactory;
import org.polarsys.capella.core.data.capellacore.Type;
import org.polarsys.capella.core.data.cs.DeployableElement;
import org.polarsys.capella.core.data.cs.Part;
import org.polarsys.capella.core.data.fa.AbstractFunction;
import org.polarsys.capella.core.data.fa.ComponentFunctionalAllocation;
import org.polarsys.capella.core.data.pa.PhysicalComponent;
import org.polarsys.capella.core.data.pa.deployment.PartDeploymentLink;


/**
 * Function Allocation -> Component.
 * @author Olivier Constant
 */
public class Allocation2ComponentQueryAndRule
extends QueryAndRule<PartDeploymentLink, AbstractFunction, Component> {
  
  /** The static identifier */
  public static final QueryAndRuleIdentifier<AbstractFunction, Component> ID =
      new QueryAndRuleIdentifier<AbstractFunction, Component>("Function2Component"); //$NON-NLS-1$
  
  
  /**
   * Constructor
   * @param parent_p a non-null object
   */
  public Allocation2ComponentQueryAndRule(IQueryHolder<? extends PartDeploymentLink> parent_p) {
    super(parent_p, ID);
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.api.IQuery#evaluate(java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
   */
  public Iterable<AbstractFunction> evaluate(PartDeploymentLink input_p,
      IQueryExecution queryExecution_p) {
    List<AbstractFunction> result = newIterable();
    DeployableElement deployed = input_p.getDeployedElement();
    if (deployed instanceof Part) {
      Type type = ((Part)deployed).getType();
      if (type instanceof PhysicalComponent) {
        for (ComponentFunctionalAllocation allocation :
          ((PhysicalComponent)type).getOwnedFunctionalAllocation()) {
          result.add(allocation.getFunction());
        }
      }
    }
    return result;
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.impl.QueryAndRule#createTarget(java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution)
   */
  @Override
  public Component createTarget(AbstractFunction source_p,
      IQueryExecution queryExecution_p) {
    return UMLFactory.eINSTANCE.createComponent();
  }
  
  /**
   * @see org.eclipse.emf.diffmerge.bridge.mapping.impl.QueryAndRule#defineTarget(java.lang.Object, java.lang.Object, org.eclipse.emf.diffmerge.bridge.mapping.api.IQueryExecution, org.eclipse.emf.diffmerge.bridge.mapping.api.IMappingExecution)
   */
  @Override
  public void defineTarget(AbstractFunction source_p,
      Component target_p, IQueryExecution queryExecution_p,
      IMappingExecution mappingExecution_p) {
    // Name
    target_p.setName(source_p.getName());
    // Container
    PartDeploymentLink dLink = queryExecution_p.get(Deployment2ComponentQueryAndRule.ID);
    Component container = mappingExecution_p.get(dLink, Deployment2ComponentQueryAndRule.ID);
    container.getNestedClassifiers().add(target_p);
  }
  
}
