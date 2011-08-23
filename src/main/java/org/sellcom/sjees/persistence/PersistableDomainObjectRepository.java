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

import java.math.BigInteger;

import com.google.common.annotations.Beta;

/**
 * Repository for persistable domain objects.
 */
@Beta
public interface PersistableDomainObjectRepository<T extends PersistableDomainObject> {

	/**
	 * Returns the persistable domain object having the specified id.
	 */
	T getById(BigInteger id);

	/**
	 * Reloads the specified persistable domain object.
	 * Discards any changes made to the persistable domain object, if any.
	 */
	T reload(T persistableDomainObject);

	/**
	 * Removes the specified persistable domain object.
	 */
	void remove(T persistableDomainObject);

	/**
	 * Saves the specified persistable domain object.
	 */
	T save(T persistableDomainObject);

	/**
	 * Saves or updates the specified persistable domain object.
	 */
	T saveOrUpdate(T persistableDomainObject);

	/**
	 * Updates the specified persistable domain object.
	 */
	T update(T persistableDomainObject);

}
