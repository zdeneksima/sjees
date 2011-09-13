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
 *
 * @author Petr Zelenka
 * @author Zdeněk Šíma
 */
@Beta
public interface PersistableDomainObjectRepository<T extends PersistableDomainObject> {

	/**
	 * Returns the persistable domain object having the specified id.
	 *
	 * @throws IllegalArgumentException if {@code id} is {@code null}
	 */
	T getById(BigInteger id);

	/**
	 * Reloads the specified persistable domain object.
	 * Discards any changes made to the persistable domain object, if any.
	 *
	 * @throws IllegalArgumentException if {@code persistableDomainObject} is {@code null}
	 */
	T reload(T persistableDomainObject);

	/**
	 * Removes the specified persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code persistableDomainObject} is {@code null}
	 */
	void remove(T persistableDomainObject);

	/**
	 * Saves the specified persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code persistableDomainObject} is {@code null}
	 */
	T save(T persistableDomainObject);

	/**
	 * Saves or updates the specified persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code persistableDomainObject} is {@code null}
	 */
	T saveOrUpdate(T persistableDomainObject);

	/**
	 * Updates the specified persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code persistableDomainObject} is {@code null}
	 */
	T update(T persistableDomainObject);

}
