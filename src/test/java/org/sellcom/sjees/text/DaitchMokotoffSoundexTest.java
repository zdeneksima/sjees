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
