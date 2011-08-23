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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.sellcom.sjees.lang.ReflectionUtils;

import com.google.common.annotations.Beta;

/**
 * Base class for JPA repositories for persistable domain objects.
 */
@Beta
public abstract class PersistableDomainObjectJpaRepository<T extends PersistableDomainObject> implements PersistableDomainObjectRepository<T> {

	@PersistenceContext
	protected EntityManager entityManager;

	protected Class<T> persistableDomainObjectClass;


	@SuppressWarnings("unchecked")
	public PersistableDomainObjectJpaRepository() {
		persistableDomainObjectClass = (Class<T>) ReflectionUtils.getTypeArgumentsForGenericType(getClass(), PersistableDomainObjectJpaRepository.class).get(0);
	}


	/**
	 * Attach the specified persistable domain object to the current persistence context if not already attached.
	 */
	protected T ensureAttached(T persistableDomainObject) {
		return entityManager.contains(persistableDomainObject) ? persistableDomainObject : entityManager.merge(persistableDomainObject);
	}

	@Override
	public T getById(BigInteger id) {
		return entityManager.find(persistableDomainObjectClass, id);
	}

	@Override
	public T reload(T persistableDomainObject) {
		T result = ensureAttached(persistableDomainObject);
		entityManager.refresh(result);
		return result;
	}

	@Override
	public void remove(T persistableDomainObject) {
		T result = ensureAttached(persistableDomainObject);
		entityManager.remove(result);
	}

	@Override
	public T save(T persistableDomainObject) {
		T result = persistableDomainObject;
		entityManager.persist(result);
		return result;
	}

	@Override
	public T saveOrUpdate(T persistableDomainObject) {
		return (persistableDomainObject.getId() == null) ? save(persistableDomainObject) : update(persistableDomainObject);
	}

	@Override
	public T update(T persistableDomainObject) {
		T result = ensureAttached(persistableDomainObject);
		return result;
	}

}
