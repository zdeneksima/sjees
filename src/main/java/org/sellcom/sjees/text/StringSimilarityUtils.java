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

import java.util.Map;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;

/**
 * Utility class containing methods computing similarity of {@code String}s.
 *
 * @author Petr Zelenka
 */
@Beta
public class StringSimilarityUtils {

	private static final Map<String, String> SOUNDEX_RULES = new ImmutableMap.Builder<String, String>()
			.put("\\AA", "=")
			.put("\\AE", "=")
			.put("\\AI", "=")
			.put("\\AO", "=")
			.put("\\AU", "=")
			.put("\\AH", "=")
			.put("\\AW", "=")
			.put("\\AY", "=")
			.put("[AEIOUY]", "0")
			.put("[BFPV]", "1")
			.put("[CGJKQSXZ]", "2")
			.put("[DT]", "3")
			.put("L", "4")
			.put("[MN]", "5")
			.put("R", "6")
			.put("[HW]", "")
			.put("([0-9])\\1+", "$1")
			.put("0", "")
			.build();


	private StringSimilarityUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Computes the Soundex code for a string.
	 * Uses Soundex rules as defined by the U.S. National Archives and Records Administration (NARA).
	 * <p>
	 * Considers only ASCII letters.
	 * If the string contains accented letters, you may want to strip the accents first.
	 *
	 * @throws IllegalArgumentException if {@code string} is {@code null}
	 * @throws IllegalArgumentException if {@code string} does not contain at least one ASCII letter
	 */
	public static String computeSoundexCode(String string) {
		Preconditions.checkArgument(string != null, "The input string must not be null");
		String input = string.replaceAll("[^A-Za-z]", "").toUpperCase();
		Preconditions.checkArgument(input.length() > 0, "The input string must contain at least one ASCII letter");

		return input.substring(0, 1) + Strings.padEnd(StringUtils.replaceAllUsingRules(input, SOUNDEX_RULES), 4, '0').substring(1, 4);
	}

}
