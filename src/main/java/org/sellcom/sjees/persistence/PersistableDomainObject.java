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

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

/**
 * Parent class for persistable domain objects.
 */
@Beta
@SequenceGenerator(name = "GlobalIdGenerator", sequenceName = "GLOBAL_ID_SEQ")
@MappedSuperclass
public abstract class PersistableDomainObject {

	@NotNull @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GlobalIdGenerator")
	@Column(name = "ID", precision = 20, scale = 0, nullable = false, updatable = false) // FIXME (Petr Zelenka): "unique = true" not declared here because of https://issues.apache.org/jira/browse/DERBY-789
	private Long id;

	@NotNull @Version
	@Column(name = "VERSION", precision = 20, scale = 0, nullable = false)
	private Long version;


	/**
	 * Indicates whether the specified object is "equal to" this one.
	 * In order to be equal, both objects must be of type {@code PersistentDomainObject} and have the same id.
	 * {@code PersistentDomainObject} that have not yet been assigned an id are never equal.
	 * Be sure to have the id assigned before using the {@code PersistentDomainObject} in collections.
	 */
	@Override
	public boolean equals(Object other) {
		if (getId() == null) {
			return false;
		}

		if (!(other instanceof PersistableDomainObject)){
			return false;
		}

		return Objects.equal(((PersistableDomainObject) other).getId(), getId());
	}

	/**
	 * Returns the id of this persistable domain object.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Returns the version of this persistable domain object.
	 */
	public Long getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(getId());
	}

	/**
	 * Sets the id of this persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code id} is {@code null}
	 * @throws IllegalStateException if the id has already been set
	 */
	public void setId(Long id) {
		Preconditions.checkState(getId() == null, "Id has already been set");
		Preconditions.checkArgument(id != null, "Id cannot be null");

		this.id = id;
	}

	/**
	 * Sets the version of this persistable domain object.
	 *
	 * @throws IllegalArgumentException if {@code version} is {@code null}
	 * @throws IllegalStateException if the version has already been set
	 */
	public void setVersion(Long version) {
		Preconditions.checkState(getVersion() == null, "Version has already been set");
		Preconditions.checkArgument(version != null, "Version cannot be null");

		this.version = version;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("id", getId())
				.add("version", getVersion())
				.toString();
	}

}
