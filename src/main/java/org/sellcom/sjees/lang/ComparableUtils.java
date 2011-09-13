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

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;

/**
 * Utility class containing methods implementing common operations with {@code Comparable}s.
 *
 * @author Petr Zelenka
 */
@Beta
public class ComparableUtils {

	private ComparableUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns the maximum of the specified objects.
	 *
	 * @throws IllegalArgumentException if {@code objects} is {@code null}
	 * @throws IllegalArgumentException if the size of {@code objects} is less than one
	 */
	public static <T extends Comparable<T>> T max(T... objects) {
		Preconditions.checkArgument(objects != null, "The input parameter must not be null");
		Preconditions.checkArgument(objects.length > 0, "The input parameter must contain at least one element");

		T result = objects[0];

		for (T currentObject : objects) {
			if (currentObject.compareTo(result) > 0) {
				result = currentObject;
			}
		}

		return result;
	}

	/**
	 * Returns the minimum of the specified objects.
	 *
	 * @throws IllegalArgumentException if {@code objects} is {@code null}
	 * @throws IllegalArgumentException if the size of {@code objects} is less than one
	 */
	public static <T extends Comparable<T>> T min(T... objects) {
		Preconditions.checkArgument(objects != null, "The input parameter must not be null");
		Preconditions.checkArgument(objects.length > 0, "The input parameter must contain at least one element");

		T result = objects[0];

		for (T currentObject : objects) {
			if (currentObject.compareTo(result) < 0) {
				result = currentObject;
			}
		}

		return result;
	}

}
