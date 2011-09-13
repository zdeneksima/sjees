/*
 * Copyright 2011 sellcom.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sellcom.sjees.persistence.criteria.selection;

import org.sellcom.sjees.annotations.NotApi;
import org.sellcom.sjees.persistence.ComparisonOperator;
import org.sellcom.sjees.persistence.PropertyModificationFunction;
import org.sellcom.sjees.persistence.SelectionCriterion;

@NotApi
public abstract class SimpleCriterion extends SelectionCriterion {

	private PropertyModificationFunction propertyModificationFunction;

	private String propertyPath;

	private Object[] referenceValues;


	public SimpleCriterion(PropertyModificationFunction propertyModificationFunction, String propertyPath, ComparisonOperator comparisonOperator, Object... referenceValues) {
		this.propertyModificationFunction = propertyModificationFunction;
		this.propertyPath = propertyPath;
		this.referenceValues = referenceValues;
	}


	public PropertyModificationFunction getPropertyModificationFunction() {
		return propertyModificationFunction;
	}

	public String getPropertyPath() {
		return propertyPath;
	}

	public Object[] getReferenceValues() {
		return referenceValues;
	}

}
