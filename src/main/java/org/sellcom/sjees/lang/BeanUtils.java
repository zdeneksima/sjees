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
package org.sellcom.sjees.lang;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.Map;

import org.sellcom.sjees.util.LruCache;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Maps;

/**
 * Utility class containing methods implementing common operations with Java Beans.
 *
 * @author Petr Zelenka
 */
@Beta
public class BeanUtils { // TODO [Petr Zelenka]: Implement tests, concentrate on properties of primitive types

	private static final Map<Class<?>, Map<String, PropertyDescriptor>> PROPERTY_DESCRIPTOR_CACHE = new LruCache<Class<?>, Map<String,PropertyDescriptor>>(100);


	private BeanUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns a {@link PropertyDescriptor} for the specified property of the specified bean.
	 * Returns {@code null} if the property descriptor cannot be obtained.
	 *
	 * @throws IllegalArgumentException if {@code beanClass} is {@code null}
	 * @throws IllegalArgumentException if {@code propertyName} is {@code null} or empty
	 */
	public static PropertyDescriptor getPropertyDescriptor(Class<?> beanClass, String propertyName) {
		Preconditions.checkArgument(beanClass != null, "Bean class must not be null");
		Preconditions.checkArgument(!Strings.isNullOrEmpty(propertyName), "Property name must not be null or empty");

		Map<String, PropertyDescriptor> propertyDescriptorsForBeanClass = PROPERTY_DESCRIPTOR_CACHE.get(beanClass);

		if (propertyDescriptorsForBeanClass == null) {
			try {
				propertyDescriptorsForBeanClass = Maps.newHashMap();
				for (PropertyDescriptor descriptor : Introspector.getBeanInfo(beanClass).getPropertyDescriptors()) {
					propertyDescriptorsForBeanClass.put(descriptor.getName(), descriptor);
				}

				PROPERTY_DESCRIPTOR_CACHE.put(beanClass, propertyDescriptorsForBeanClass);
			} catch (IntrospectionException e) {
				return null;
			}
		}

		return propertyDescriptorsForBeanClass.get(propertyName);
	}

	/**
	 * Returns a {@link Class} object representing the data type of the specified property of the specified bean.
	 * Returns {@code null} if the property type cannot be determined.
	 *
	 * @throws IllegalArgumentException if {@code beanClass} is {@code null}
	 * @throws IllegalArgumentException if {@code propertyName} is {@code null} or empty
	 */
	public static Class<?> getPropertyType(Class<?> beanClass, String propertyName) {
		PropertyDescriptor descriptor = getPropertyDescriptor(beanClass, propertyName);

		if (descriptor != null) {
			return descriptor.getPropertyType();
		}

		return null;
	}

}
