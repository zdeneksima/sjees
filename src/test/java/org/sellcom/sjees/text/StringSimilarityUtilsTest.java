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

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringSimilarityUtilsTest {

	@Test
	public void testComputeSoundexCodeBasicBatch() {
		assertEquals("A355", StringSimilarityUtils.computeSoundexCode("Adomomi"));
		assertEquals("A462", StringSimilarityUtils.computeSoundexCode("Allricht"));
		assertEquals("A536", StringSimilarityUtils.computeSoundexCode("Andrews"));
		assertEquals("A261", StringSimilarityUtils.computeSoundexCode("Ashcraft"));
		assertEquals("B400", StringSimilarityUtils.computeSoundexCode("Ball"));
		assertEquals("B635", StringSimilarityUtils.computeSoundexCode("Barton"));
		assertEquals("B312", StringSimilarityUtils.computeSoundexCode("Booth-Davis"));
		assertEquals("B635", StringSimilarityUtils.computeSoundexCode("Burton"));
		assertEquals("D562", StringSimilarityUtils.computeSoundexCode("De Morgan"));
		assertEquals("E166", StringSimilarityUtils.computeSoundexCode("Eberhard"));
		assertEquals("E460", StringSimilarityUtils.computeSoundexCode("Ellery"));
		assertEquals("E521", StringSimilarityUtils.computeSoundexCode("Engebrethson"));
		assertEquals("E460", StringSimilarityUtils.computeSoundexCode("Euler"));
		assertEquals("G200", StringSimilarityUtils.computeSoundexCode("Gauss"));
		assertEquals("G200", StringSimilarityUtils.computeSoundexCode("Ghosh"));
		assertEquals("G362", StringSimilarityUtils.computeSoundexCode("Gutierrez"));
		assertEquals("G232", StringSimilarityUtils.computeSoundexCode("Gwozdziewycz"));
		assertEquals("H524", StringSimilarityUtils.computeSoundexCode("Hanselmann"));
		assertEquals("H416", StringSimilarityUtils.computeSoundexCode("Heilbronn"));
		assertEquals("H512", StringSimilarityUtils.computeSoundexCode("Heimbach"));
		assertEquals("H416", StringSimilarityUtils.computeSoundexCode("Hilbert"));
		assertEquals("H431", StringSimilarityUtils.computeSoundexCode("Hildebrand"));
		assertEquals("H452", StringSimilarityUtils.computeSoundexCode("Holmes"));
		assertEquals("J250", StringSimilarityUtils.computeSoundexCode("Jackson"));
		assertEquals("K530", StringSimilarityUtils.computeSoundexCode("Kant"));
		assertEquals("K152", StringSimilarityUtils.computeSoundexCode("Kavanagh"));
		assertEquals("K525", StringSimilarityUtils.computeSoundexCode("Kingsmith"));
		assertEquals("K530", StringSimilarityUtils.computeSoundexCode("Knuth"));
		assertEquals("L300", StringSimilarityUtils.computeSoundexCode("Ladd"));
		assertEquals("L000", StringSimilarityUtils.computeSoundexCode("Lee"));
		assertEquals("L530", StringSimilarityUtils.computeSoundexCode("Lind"));
		assertEquals("L222", StringSimilarityUtils.computeSoundexCode("Lissajous"));
		assertEquals("L300", StringSimilarityUtils.computeSoundexCode("Lloyd"));
		assertEquals("L222", StringSimilarityUtils.computeSoundexCode("Lukaschowsky"));
		assertEquals("L222", StringSimilarityUtils.computeSoundexCode("Lukasiewicz"));
		assertEquals("M235", StringSimilarityUtils.computeSoundexCode("McDonnell"));
		assertEquals("M200", StringSimilarityUtils.computeSoundexCode("McGee"));
		assertEquals("O165", StringSimilarityUtils.computeSoundexCode("O'Brien"));
		assertEquals("O155", StringSimilarityUtils.computeSoundexCode("Opnian"));
		assertEquals("O155", StringSimilarityUtils.computeSoundexCode("Oppenheimer"));
		assertEquals("P236", StringSimilarityUtils.computeSoundexCode("Pfister"));
		assertEquals("R355", StringSimilarityUtils.computeSoundexCode("Riedemanas"));
		assertEquals("R163", StringSimilarityUtils.computeSoundexCode("Roberts"));
		assertEquals("S532", StringSimilarityUtils.computeSoundexCode("Saint John"));
		assertEquals("S545", StringSimilarityUtils.computeSoundexCode("Scanlon"));
		assertEquals("S000", StringSimilarityUtils.computeSoundexCode("Shaw"));
		assertEquals("S530", StringSimilarityUtils.computeSoundexCode("Smith"));
		assertEquals("S530", StringSimilarityUtils.computeSoundexCode("Smythe"));
		assertEquals("S315", StringSimilarityUtils.computeSoundexCode("Stevens"));
		assertEquals("T522", StringSimilarityUtils.computeSoundexCode("Tymczak"));
		assertEquals("V532", StringSimilarityUtils.computeSoundexCode("VanDeusen"));
		assertEquals("V536", StringSimilarityUtils.computeSoundexCode("von der Lehr"));
		assertEquals("W200", StringSimilarityUtils.computeSoundexCode("Wachs"));
		assertEquals("W252", StringSimilarityUtils.computeSoundexCode("Washington"));
		assertEquals("W452", StringSimilarityUtils.computeSoundexCode("Williams"));
		assertEquals("Z300", StringSimilarityUtils.computeSoundexCode("Zita"));
		assertEquals("Z325", StringSimilarityUtils.computeSoundexCode("Zitzmeinn"));
	}

	@Test
	public void testComputeSoundexCodeB650Batch() {
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Barham"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Barone"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Barron"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Berna"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Birney"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Birnie"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Boorom"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Boren"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Born"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bourn"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bourne"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bowron"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brain"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brame"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brann"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Braun"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Breen"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brien"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brim"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brimm"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brinn"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brion"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Broom"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Broome"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brown"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Browne"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bruen"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bruhn"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bruin"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brumm"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Brun"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bruno"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Bryan"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Burian"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Burn"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Burney"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Byram"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Byrne"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Byron"));
		assertEquals("B650", StringSimilarityUtils.computeSoundexCode("Byrum"));
	}

	@Test
	public void testComputeSoundexCodeS460Batch() {
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Sailor"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Salyer"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Saylor"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Schaller"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Scheller"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Schiller"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Schooler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Schuler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Schuyler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Seiler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Seyler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Sgler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Sholar"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Shuler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Silar"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Siler"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Siller"));
		assertEquals("S460", StringSimilarityUtils.computeSoundexCode("Swhgler"));
	}

}
