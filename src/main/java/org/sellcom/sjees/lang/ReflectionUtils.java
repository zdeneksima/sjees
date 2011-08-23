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

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.List;
import java.util.Map;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * Utility class containing methods implementing common operations related to Reflection API.
 *
 * @author Petr Zelenka
 */
@Beta
public class ReflectionUtils {

	private ReflectionUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns the {@link Class} object corresponding to the specified {@link Type}.
	 * Returns {@code null} if such {@link Class} object cannot be determined.
	 *
	 * @throws IllegalArgumentException if {@code type} is {@code null}
	 */
	public static Class<?> getClassForType(Type type) {
		Preconditions.checkArgument(type != null, "Type cannot be null");

		if (type instanceof Class<?>) {
			return (Class<?>) type;
		}

		if (type instanceof ParameterizedType) {
			return getClassForType(((ParameterizedType) type).getRawType());
		}

		if (type instanceof GenericArrayType) {
			Type componentType = ((GenericArrayType) type).getGenericComponentType();
			Class<?> componentClass = getClassForType(componentType);

			if (componentClass != null ) {
				return Array.newInstance(componentClass, 0).getClass();
			}
		}

		return null;
	}

	/**
	 * Returns a list of {@link Class} objects corresponding to the actual type parameters of the specified generic type.
	 * The list contains the {@link Class} objects in the order of declaration of the type parameters.
	 * If the {@link Class} object cannot be determined for a type parameter, {@code null} is returned for that {@link Class} object.
	 * <p>
	 * {@code classOfGenericType} is the class of the generic type of which the type parameters shall be examined.
	 * {@code baseClassOfGenericType} is the superclass of the generic type on which the type parameters to be examined were declared.
	 *
	 * @throws IllegalArgumentException if {@code classOfGenericType} or {@code baseClassOfGenericType} is {@code null}
	 */
	public static <T> List<Class<?>> getTypeArgumentsForGenericType(Class<? extends T> classOfGenericType, Class<T> baseClassOfGenericType) {
		Preconditions.checkArgument(classOfGenericType != null, "Class of generic type cannot be null");
		Preconditions.checkArgument(baseClassOfGenericType != null, "Base class of generic type cannot be null");

		Map<Type, Type> resolvedTypes = Maps.newHashMap();

		// Walk up the inheritance hierarchy up to the base class and resolve type arguments of parameterized types on the way
		Type currentType = classOfGenericType;
		while (!getClassForType(currentType).equals(baseClassOfGenericType)) {
			if (currentType instanceof Class<?>) {
				currentType = ((Class<?>) currentType).getGenericSuperclass();
			} else {
				ParameterizedType parameterizedType = (ParameterizedType) currentType;
				Class<?> rawType = (Class<?>) parameterizedType.getRawType();

				Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
				TypeVariable<?>[] typeParameters = rawType.getTypeParameters();

				for (int i = 0; i < actualTypeArguments.length; i++) {
					resolvedTypes.put(typeParameters[i], actualTypeArguments[i]);
				}

				if (!rawType.equals(baseClassOfGenericType)) {
					currentType = rawType.getGenericSuperclass();
				}
			}
		}

		// Determine raw classes for all actual type arguments of the base class
		Type[] actualTypeArguments;
		if (currentType instanceof Class<?>) {
			actualTypeArguments = ((Class<?>) currentType).getTypeParameters();
		} else {
			actualTypeArguments = ((ParameterizedType) currentType).getActualTypeArguments();
		}

		List<Class<?>> classesOfAcutalTypeArguments = Lists.newArrayList();
		for (Type baseType: actualTypeArguments) {
			while (resolvedTypes.containsKey(baseType)) {
				baseType = resolvedTypes.get(baseType);
			}

			classesOfAcutalTypeArguments.add(getClassForType(baseType));
		}

		return classesOfAcutalTypeArguments;
	}

}
