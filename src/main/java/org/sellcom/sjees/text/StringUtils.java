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
package org.sellcom.sjees.text;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Utility class containing methods implementing common operations with {@code String}s.
 * 
 * @author Petr Zelenka
 */
@Beta
public class StringUtils {

	private StringUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns the first non-empty string from the given parameters.
	 * Considers {@code null}s to be empty strings.
	 * 
	 * @throws IllegalArgumentException if the last parameter is an empty string or {@code null}
	 */
	public static String firstNonEmpty(String... strings) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(strings[strings.length - 1]), "The last parameter must not be empty or null");

		for (String s : strings) {
			if (!Strings.isNullOrEmpty(s)) {
				return s;
			}
		}

		throw new AssertionError(); // Should never happen.
	}

	/**
	 * Checks whether the given string consists of whitespace only.
	 * Considers whitespace as defined by {@link Character#isWhitespace(char)}.
	 * 
	 * @throws IllegalArgumentException if {@code string} is {@code null}
	 */
	public static boolean isBlank(String string) {
		Preconditions.checkArgument(string != null, "The input string must not be null");

		for (int i = 0; i < string.length(); i++) {
			if (!Character.isWhitespace(string.charAt(i))) {
				return false;
			}
		}

		return true;
	}

}
