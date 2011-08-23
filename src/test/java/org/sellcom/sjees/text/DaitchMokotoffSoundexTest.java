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

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.common.io.CharStreams;

public class DaitchMokotoffSoundexTest {

	private static final Multimap<String, String> testCases = HashMultimap.create();


	@BeforeClass
	public static void setUp() throws IOException {
		InputStream dataFileInputStream = NaraSoundexTest.class.getResourceAsStream("DaitchMokotoffSoundexTest.data");
		List<String> lines = CharStreams.readLines(new InputStreamReader(dataFileInputStream));

		for (String currentLine : lines) {
			if (!currentLine.startsWith(";")) {
				Iterable<String> components = Splitter.on("->").trimResults().split(currentLine);
				Iterable<String> expectedValues = Splitter.on(",").trimResults().split(Iterables.get(components, 1));
				testCases.putAll(Iterables.get(components, 0), expectedValues);
			}
		}
	}

	@Test
	public void testComputeNaraSoundexCode() {
		for (String input : testCases.keySet()) {
			Set<String> expectedOutput = Sets.newHashSet(testCases.get(input));
			assertThat("\n   input: " + input, StringSimilarityUtils.computeDaitchMokotoffSoundexCode(input), is(equalTo(expectedOutput)));
		}
	}

}
