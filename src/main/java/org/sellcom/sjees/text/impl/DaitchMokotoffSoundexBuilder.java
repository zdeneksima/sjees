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
package org.sellcom.sjees.text.impl;

import java.util.List;
import java.util.Set;

import org.sellcom.sjees.annotations.NotApi;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

@NotApi
public class DaitchMokotoffSoundexBuilder {

	private static final Function<StringBuilder, String> CODE_TRANSFORMER = new Function<StringBuilder, String>() {
			@Override
			public String apply(StringBuilder input) {
				return Strings.padEnd(input.toString(), 7, '0').substring(1, 7);
			}
		};


	private List<StringBuilder> codes;

	private List<String> lastSounds;

	private List<StringBuilder> nextCodes = null;

	private List<String> nextLastSounds = null;


	public DaitchMokotoffSoundexBuilder() {
		codes = Lists.newArrayList();
		codes.add(new StringBuilder("="));

		lastSounds = Lists.newArrayList();
		lastSounds.add("=");
	}


	public Set<String> build() {
		return Sets.newHashSet(Iterables.transform(codes, CODE_TRANSFORMER));
	}

	public void endStep() {
		codes = nextCodes;
		lastSounds = nextLastSounds;
	}

	public void offerSounds(String sounds) {
		for (int i = 0; i < codes.size(); i++) {
			StringBuilder nextCode = new StringBuilder(codes.get(i));

			String previousLastSound = lastSounds.get(i);
			String nextLastSound = previousLastSound;

			if (!sounds.equals(previousLastSound)) {
				nextCode.append(sounds);
				nextLastSound = sounds.isEmpty() ? "" : sounds.substring(sounds.length() - 1);
			}

			nextCodes.add(nextCode);
			nextLastSounds.add(nextLastSound);
		}
	}

	public void startStep() {
		nextCodes = Lists.newArrayListWithExpectedSize(2 * codes.size());
		nextLastSounds = Lists.newArrayListWithExpectedSize(2 * lastSounds.size());
	}

}
