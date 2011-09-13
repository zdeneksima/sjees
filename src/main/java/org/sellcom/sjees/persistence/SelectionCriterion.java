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
package org.sellcom.sjees.persistence;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

import com.google.common.annotations.Beta;

/**
 * Criterion for selecting {@link PersistableDomainObject}s.
 */
@Beta
public abstract class SelectionCriterion {

	public abstract Predicate getJpaPredicate(CriteriaBuilder criteriaBuilder, Class<?> rootPersistableDomainObjectClass);

}
