package org.sellcom.sjees.text;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SoundexTest {

	private String expectedOutput;

	private String input;


	public SoundexTest(String expectedOutput, String input) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}


	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
				{ "A355", "Adomomi" },
				{ "A462", "Allricht" },
				{ "A536", "Andrews" },
				{ "A261", "Ashcraft" },
				{ "B400", "Ball" },
				{ "B635", "Barton" },
				{ "B312", "Booth-Davis" },
				{ "B635", "Burton" },
				{ "D562", "De Morgan" },
				{ "E166", "Eberhard" },
				{ "E460", "Ellery" },
				{ "E521", "Engebrethson" },
				{ "E460", "Euler" },
				{ "G200", "Gauss" },
				{ "G200", "Ghosh" },
				{ "G362", "Gutierrez" },
				{ "G232", "Gwozdziewycz" },
				{ "H524", "Hanselmann" },
				{ "H416", "Heilbronn" },
				{ "H512", "Heimbach" },
				{ "H416", "Hilbert" },
				{ "H431", "Hildebrand" },
				{ "H452", "Holmes" },
				{ "J250", "Jackson" },
				{ "K530", "Kant" },
				{ "K152", "Kavanagh" },
				{ "K525", "Kingsmith" },
				{ "K530", "Knuth" },
				{ "L300", "Ladd" },
				{ "L000", "Lee" },
				{ "L530", "Lind" },
				{ "L222", "Lissajous" },
				{ "L300", "Lloyd" },
				{ "L535", "London" },
				{ "L222", "Lukaschowsky" },
				{ "L222", "Lukasiewicz" },
				{ "M235", "McDonnell" },
				{ "M200", "McGee" },
				{ "O165", "O'Brien" },
				{ "O155", "Opnian" },
				{ "O155", "Oppenheimer" },
				{ "P236", "Pfister" },
				{ "R355", "Riedemanas" },
				{ "R163", "Roberts" },
				{ "S532", "Saint John" },
				{ "S545", "Scanlon" },
				{ "S000", "Shaw" },
				{ "S530", "Smith" },
				{ "S530", "Smythe" },
				{ "S315", "Stevens" },
				{ "T522", "Tymczak" },
				{ "V532", "VanDeusen" },
				{ "V536", "von der Lehr" },
				{ "W200", "Wachs" },
				{ "W252", "Washington" },
				{ "W452", "Williams" },
				{ "Z300", "Zita" },
				{ "Z325", "Zitzmeinn" },

				{ "B650", "Barham" },
				{ "B650", "Barone" },
				{ "B650", "Barron" },
				{ "B650", "Berna" },
				{ "B650", "Birney" },
				{ "B650", "Birnie" },
				{ "B650", "Boorom" },
				{ "B650", "Boren" },
				{ "B650", "Born" },
				{ "B650", "Bourn" },
				{ "B650", "Bourne" },
				{ "B650", "Bowron" },
				{ "B650", "Brain" },
				{ "B650", "Brame" },
				{ "B650", "Brann" },
				{ "B650", "Braun" },
				{ "B650", "Breen" },
				{ "B650", "Brien" },
				{ "B650", "Brim" },
				{ "B650", "Brimm" },
				{ "B650", "Brinn" },
				{ "B650", "Brion" },
				{ "B650", "Broom" },
				{ "B650", "Broome" },
				{ "B650", "Brown" },
				{ "B650", "Browne" },
				{ "B650", "Bruen" },
				{ "B650", "Bruhn" },
				{ "B650", "Bruin" },
				{ "B650", "Brumm" },
				{ "B650", "Brun" },
				{ "B650", "Bruno" },
				{ "B650", "Bryan" },
				{ "B650", "Burian" },
				{ "B650", "Burn" },
				{ "B650", "Burney" },
				{ "B650", "Byram" },
				{ "B650", "Byrne" },
				{ "B650", "Byron" },
				{ "B650", "Byrum" },

				{ "S460", "Sailor" },
				{ "S460", "Salyer" },
				{ "S460", "Saylor" },
				{ "S460", "Schaller" },
				{ "S460", "Scheller" },
				{ "S460", "Schiller" },
				{ "S460", "Schooler" },
				{ "S460", "Schuler" },
				{ "S460", "Schuyler" },
				{ "S460", "Seiler" },
				{ "S460", "Seyler" },
				{ "S460", "Sgler" },
				{ "S460", "Sholar" },
				{ "S460", "Shuler" },
				{ "S460", "Silar" },
				{ "S460", "Siler" },
				{ "S460", "Siller" },
				{ "S460", "Swhgler" },
			});
	};

	@Test
	public void testComputeSoundexCode() {
		assertThat("\n   input: " + input, StringSimilarityUtils.computeSoundexCode(input), is(equalTo(expectedOutput)));
	}

}
