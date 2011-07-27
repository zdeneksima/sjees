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
import java.util.Set;

import org.sellcom.sjees.text.impl.DaitchMokotoffSoundexBuilder;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;

/**
 * Utility class containing methods computing similarity of {@code String}s.
 *
 * @author Petr Zelenka
 */
@Beta
public class StringSimilarityUtils {

	/*
	 * Perl's Text::Phonetic::DaitchMokotoff maps "UE" to { "0", "1", "" } instead of { "0", "", "" }
	 *
	 * It also seems that some implementations map "J" (first rule) to { "1", "1", "" } instead of { "1", "", "" }
	 */
	private static final Map<String, Multimap<String, String[]>> DAITCH_MOKOTOFF_SOUNDEX_RULES = new ImmutableMap.Builder<String, Multimap<String, String[]>>()
			.put("A", new ImmutableMultimap.Builder<String, String[]>()
					.put("AY", new String[] { "0", "1", "" })
					.put("AU", new String[] { "0", "7", "" })
					.put("AJ", new String[] { "0", "1", "" })
					.put("AI", new String[] { "0", "1", "" })
					.put("A", new String[] { "0", "", "" })
					.build())
			.put("Ä", new ImmutableMultimap.Builder<String, String[]>()
					.put("Ä", new String[] { "0", "", "" })
					.build())
			.put("B", new ImmutableMultimap.Builder<String, String[]>()
					.put("B", new String[] { "7", "7", "7" })
					.build())
			.put("C", new ImmutableMultimap.Builder<String, String[]>()
					.put("CZS", new String[] { "4", "4", "4" })
					.put("CZ", new String[] { "4", "4", "4" })
					.put("CSZ", new String[] { "4", "4", "4" })
					.put("CS", new String[] { "4", "4", "4" })
					.put("CK", new String[] { "5", "5", "5" })
					.put("CK", new String[] { "45", "45", "45" })
					.put("CHS", new String[] { "5", "54", "54" })
					.put("CH", new String[] { "5", "5", "5" })
					.put("CH", new String[] { "4", "4", "4" })
					.put("C", new String[] { "5", "5", "5" })
					.put("C", new String[] { "4", "4", "4" })
					.build())
			.put("D", new ImmutableMultimap.Builder<String, String[]>()
					.put("DZS", new String[] { "4", "4", "4" })
					.put("DZH", new String[] { "4", "4", "4" })
					.put("DZ", new String[] { "4", "4", "4" })
					.put("DT", new String[] { "3", "3", "3" })
					.put("DSZ", new String[] { "4", "4", "4" })
					.put("DSH", new String[] { "4", "4", "4" })
					.put("DS", new String[] { "4", "4", "4" })
					.put("DRZ", new String[] { "4", "4", "4" })
					.put("DRS", new String[] { "4", "4", "4" })
					.put("D", new String[] { "3", "3", "3" })
					.build())
			.put("E", new ImmutableMultimap.Builder<String, String[]>()
					.put("EY", new String[] { "0", "1", "" })
					.put("EU", new String[] { "1", "1", "" })
					.put("EJ", new String[] { "0", "1", "" })
					.put("EI", new String[] { "0", "1", "" })
					.put("E", new String[] { "0", "", "" })
					.build())
			.put("F", new ImmutableMultimap.Builder<String, String[]>()
					.put("FB", new String[] { "7", "7", "7" })
					.put("F", new String[] { "7", "7", "7" })
					.build())
			.put("G", new ImmutableMultimap.Builder<String, String[]>()
					.put("G", new String[] { "5", "5", "5" })
					.build())
			.put("H", new ImmutableMultimap.Builder<String, String[]>()
					.put("H", new String[] { "5", "5", "" })
					.build())
			.put("I", new ImmutableMultimap.Builder<String, String[]>()
					.put("IU", new String[] {"1", "", ""  })
					.put("IO", new String[] { "1", "", "" })
					.put("IE", new String[] { "1", "", "" })
					.put("IA", new String[] { "1", "", "" })
					.put("I", new String[] { "0", "", "" })
					.build())
			.put("J", new ImmutableMultimap.Builder<String, String[]>()
					.put("J", new String[] { "1", "", "" })
					.put("J", new String[] { "4", "4", "4" })
					.build())
			.put("K", new ImmutableMultimap.Builder<String, String[]>()
					.put("KS", new String[] { "5", "54", "54" })
					.put("KH", new String[] { "5", "5", "5" })
					.put("K", new String[] { "5", "5", "5" })
					.build())
			.put("L", new ImmutableMultimap.Builder<String, String[]>()
					.put("L", new String[] { "8", "8", "8" })
					.build())
			.put("M", new ImmutableMultimap.Builder<String, String[]>()
					.put("MN", new String[] { "", "66", "66" })
					.put("M", new String[] { "6", "6", "6" })
					.build())
			.put("N", new ImmutableMultimap.Builder<String, String[]>()
					.put("NM", new String[] { "", "66", "66" })
					.put("N", new String[] { "6", "6", "6" })
					.build())
			.put("O", new ImmutableMultimap.Builder<String, String[]>()
					.put("OY", new String[] { "0", "1", "" })
					.put("OJ", new String[] { "0", "1", "" })
					.put("OI", new String[] { "0", "1", "" })
					.put("O", new String[] { "0", "", "" })
					.build())
			.put("Ö", new ImmutableMultimap.Builder<String, String[]>()
					.put("Ö", new String[] { "0", "", "" })
					.build())
			.put("P", new ImmutableMultimap.Builder<String, String[]>()
					.put("PH", new String[] { "7", "7", "7" })
					.put("PF", new String[] { "7", "7", "7" })
					.put("P", new String[] { "7", "7", "7" })
					.build())
			.put("Q", new ImmutableMultimap.Builder<String, String[]>()
					.put("Q", new String[] { "5", "5", "5" })
					.build())
			.put("R", new ImmutableMultimap.Builder<String, String[]>()
					.put("RZ", new String[] { "94", "94", "94" })
					.put("RZ", new String[] { "4", "4", "4" })
					.put("RS", new String[] { "94", "94", "94" })
					.put("RS", new String[] { "4", "4", "4" })
					.put("R", new String[] { "9", "9", "9" })
					.build())
			.put("S", new ImmutableMultimap.Builder<String, String[]>()
					.put("SZT", new String[] { "2", "43", "43" })
					.put("SZD", new String[] { "2", "43", "43" })
					.put("SZCZ", new String[] { "2", "4", "4" })
					.put("SZCS", new String[] { "2", "4", "4" })
					.put("SZ", new String[] { "4", "4", "4" })
					.put("STSH", new String[] { "2", "4", "4" })
					.put("STSCH", new String[] { "2", "4", "4" })
					.put("STRZ", new String[] { "2", "4", "4" })
					.put("STRS", new String[] { "2", "4", "4" })
					.put("STCH", new String[] { "2", "4", "4" })
					.put("ST", new String[] { "2", "43", "43" })
					.put("SHTSH", new String[] { "2", "4", "4" })
					.put("SHTCH", new String[] { "2", "4", "4" })
					.put("SHT", new String[] { "2", "43", "43" })
					.put("SHD", new String[] { "2", "43", "43" })
					.put("SHCH", new String[] { "2", "4", "4" })
					.put("SH", new String[] { "4", "4", "4" })
					.put("SD", new String[] { "2", "43", "43" })
					.put("SCHTSH", new String[] { "2", "4", "4" })
					.put("SCHTSCH", new String[] { "2", "4", "4" })
					.put("SCHTCH", new String[] { "2", "4", "4" })
					.put("SCHT", new String[] { "2", "43", "43" })
					.put("SCHD", new String[] { "2", "43", "43" })
					.put("SCH", new String[] { "4", "4", "4" })
					.put("SC", new String[] { "2", "4", "4" })
					.put("S", new String[] { "4", "4", "4" })
					.build())
			.put("ß", new ImmutableMultimap.Builder<String, String[]>()
					.put("ß", new String[] { "4", "4", "4" })
					.build())
			.put("T", new ImmutableMultimap.Builder<String, String[]>()
					.put("TZS", new String[] { "4", "4", "4" })
					.put("TZ", new String[] { "4", "4", "4" })
					.put("TTZ", new String[] { "4", "4", "4" })
					.put("TTSZ", new String[] { "4", "4", "4" })
					.put("TTSCH", new String[] { "4", "4", "4" })
					.put("TTS", new String[] { "4", "4", "4" })
					.put("TTCH", new String[] { "4", "4", "4" })
					.put("TSZ", new String[] { "4", "4", "4" })
					.put("TSH", new String[] { "4", "4", "4" })
					.put("TSCH", new String[] { "4", "4", "4" })
					.put("TS", new String[] { "4", "4", "4" })
					.put("TRZ", new String[] { "4", "4", "4" })
					.put("TRS", new String[] { "4", "4", "4" })
					.put("TH", new String[] { "3", "3", "3" })
					.put("TCH", new String[] { "4", "4", "4" })
					.put("TC", new String[] { "4", "4", "4" })
					.put("T", new String[] { "3", "3", "3" })
					.build())
			.put("U", new ImmutableMultimap.Builder<String, String[]>()
					.put("UY", new String[] { "0", "1", "" })
					.put("UJ", new String[] { "0", "1", "" })
					.put("UI", new String[] { "0", "1", "" })
					.put("UE", new String[] { "0", "", "" })
					.put("U", new String[] { "0", "", "" })
					.build())
			.put("Ü", new ImmutableMultimap.Builder<String, String[]>()
					.put("Ü", new String[] { "0", "", "" })
					.build())
			.put("V", new ImmutableMultimap.Builder<String, String[]>()
					.put("V", new String[] { "7", "7", "7" })
					.build())
			.put("W", new ImmutableMultimap.Builder<String, String[]>()
					.put("W", new String[] { "7", "7", "7" })
					.build())
			.put("X", new ImmutableMultimap.Builder<String, String[]>()
					.put("X", new String[] { "5", "54", "54" })
					.build())
			.put("Y", new ImmutableMultimap.Builder<String, String[]>()
					.put("Y", new String[] { "1", "", "" })
					.build())
			.put("Z", new ImmutableMultimap.Builder<String, String[]>()
					.put("ZSH", new String[] { "4", "4", "4" })
					.put("ZSCH", new String[] { "4", "4", "4" })
					.put("ZS", new String[] { "4", "4", "4" })
					.put("ZHDZH", new String[] { "2", "4", "4" })
					.put("ZHD", new String[] { "2", "43", "43" })
					.put("ZH", new String[] { "4", "4", "4" })
					.put("ZDZH", new String[] { "2", "4", "4" })
					.put("ZDZ", new String[] { "2", "4", "4" })
					.put("ZD", new String[] { "2", "43", "43" })
					.put("Z", new String[] { "4", "4", "4" })
					.build())
			.build();

	private static final Map<String, String> NARA_SOUNDEX_RULES = new ImmutableMap.Builder<String, String>()
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
	 * Computes the Daitch-Mokotoff Soundex code for a string.
	 * Uses default Daitch-Mokotoff Soundex rules.
	 * <p>
	 * Considers only ASCII letters and any of "ÄÖÜäöüß".
	 * If the string contains other accented letters, you may want to strip the accents first.
	 *
	 * @throws IllegalArgumentException if {@code string} is {@code null}
	 * @throws IllegalArgumentException if {@code string} does not contain at least one letter (see above)
	 */
	public static Set<String> computeDaitchMokotoffSoundexCode(String string) {
		Preconditions.checkArgument(string != null, "The input string must not be null");
		String input = string.replaceAll("[^A-Za-zÄÖÜäöüß]", "").toUpperCase() + "=";
		Preconditions.checkArgument(input.length() > 0, "The input string must contain at least one letter (see JavaDoc for letters being considered)");

		DaitchMokotoffSoundexBuilder builder = new DaitchMokotoffSoundexBuilder();
		int position = 0;

		while (position < (input.length() - 1)) {
			Multimap<String, String[]> rulesForCurrentLetter = DAITCH_MOKOTOFF_SOUNDEX_RULES.get(String.valueOf(input.charAt(position)));

			for (String ruleBase : rulesForCurrentLetter.keySet()) {
				if (input.regionMatches(position, ruleBase, 0, ruleBase.length())) {
					builder.startStep();
					for (String[] currentSounds : rulesForCurrentLetter.get(ruleBase)) {
						builder.offerSounds(currentSounds[(position == 0) ? 0 : ("AEIOUY".indexOf(input.charAt(position + ruleBase.length())) > -1) ? 1 : 2]);
					}

					builder.endStep();
					position += ruleBase.length();
					break;
				}
			}
		}

		return builder.build();
	}

	/**
	 * Computes the Soundex code for a string.
	 * Uses Soundex rules as defined by the U.S. National Archives and Records Administration (NARA).
	 * <p>
	 * Considers only ASCII letters and any of "ÄÖÜäöüß".
	 * If the string contains accented letters, you may want to strip the accents first.
	 *
	 * @throws IllegalArgumentException if {@code string} is {@code null}
	 * @throws IllegalArgumentException if {@code string} does not contain at least one ASCII letter
	 */
	public static String computeNaraSoundexCode(String string) {
		Preconditions.checkArgument(string != null, "The input string must not be null");
		String input = string.replaceAll("[^A-Za-zÄÖÜäöüß]", "").toUpperCase().replace("Ä", "A").replace("Ö", "O").replace("Ü", "U").replace("ß", "SS");
		Preconditions.checkArgument(input.length() > 0, "The input string must contain at least one letter (see JavaDoc for letters being considered)");

		return input.substring(0, 1) + Strings.padEnd(StringUtils.replaceAllUsingRegexRules(input, NARA_SOUNDEX_RULES), 4, '0').substring(1, 4);
	}

}
