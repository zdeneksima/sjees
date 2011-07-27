package org.sellcom.sjees.text;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.io.CharStreams;

public class NaraSoundexTest {

	private static final Map<String, String> testCases = Maps.newHashMap();


	@BeforeClass
	public static void setUp() throws IOException {
		InputStream dataFileInputStream = NaraSoundexTest.class.getResourceAsStream("NaraSoundexTest.data");
		List<String> lines = CharStreams.readLines(new InputStreamReader(dataFileInputStream));

		for (String currentLine : lines) {
			if (!currentLine.startsWith(";")) {
				Iterable<String> components = Splitter.on("->").trimResults().split(currentLine);
				testCases.put(Iterables.get(components, 0), Iterables.get(components, 1));
			}
		}
	}

	@Test
	public void test() throws IOException {
		for (String input : testCases.keySet()) {
			String expectedOutput = testCases.get(input);
			assertThat("\n   input: " + input, StringSimilarityUtils.computeNaraSoundexCode(input), is(equalTo(expectedOutput)));
		}
	}

}
