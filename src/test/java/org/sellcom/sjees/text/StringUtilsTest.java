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

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testCapitalize() {
		assertThat(StringUtils.capitalize("afrikanischer elefant"), is(equalTo("Afrikanischer Elefant")));
		assertThat(StringUtils.capitalize("eisbär"), is(equalTo("Eisbär")));
		assertThat(StringUtils.capitalize("flusspferd"), is(equalTo("Flusspferd")));
		assertThat(StringUtils.capitalize("großer ameisenbär"), is(equalTo("Großer Ameisenbär")));
		assertThat(StringUtils.capitalize("weißhandgibbon"), is(equalTo("Weißhandgibbon")));
		assertThat(StringUtils.capitalize("kronenkranich"), is(equalTo("Kronenkranich")));
		assertThat(StringUtils.capitalize("weißStirnSpint"), is(equalTo("WeißStirnSpint")));
		assertThat(StringUtils.capitalize("griechische landschildkröte"), is(equalTo("Griechische Landschildkröte")));
		assertThat(StringUtils.capitalize("schrecklicher giftfrosch"), is(equalTo("Schrecklicher Giftfrosch")));
		assertThat(StringUtils.capitalize("koi-karpfen"), is(equalTo("Koi-Karpfen")));
	}

	@Test
	public void testFirstNonEmpty() {
		assertThat(StringUtils.firstNonEmpty("An", "der", "schönen", "blauen", "Donau"), is(equalTo("An")));
		assertThat(StringUtils.firstNonEmpty("", "", "Wiener", "Waltzer"), is(equalTo("Wiener")));
	}

	@Test
	public void testIsBlank() {
		assertThat(StringUtils.isBlank("Haus des Meeres"), is(equalTo(false)));
		assertThat(StringUtils.isBlank(""), is(equalTo(true)));
		assertThat(StringUtils.isBlank("\t \r\n"), is(equalTo(true)));
	}

	@Test
	public void testReplaceAllUsingRegexRules() {
		// Extensively tested in NaraSoundexTest (method is used in StringSimilarityUtils.computeNaraSoundexCode())
	}

	@Test
	public void testUncapitalize() {
		assertThat(StringUtils.uncapitalize("Afrikanischer Elefant"), is(equalTo("afrikanischer elefant")));
		assertThat(StringUtils.uncapitalize("Eisbär"), is(equalTo("eisbär")));
		assertThat(StringUtils.uncapitalize("Flusspferd"), is(equalTo("flusspferd")));
		assertThat(StringUtils.uncapitalize("Großer Ameisenbär"), is(equalTo("großer ameisenbär")));
		assertThat(StringUtils.uncapitalize("Weißhandgibbon"), is(equalTo("weißhandgibbon")));
		assertThat(StringUtils.uncapitalize("Kronenkranich"), is(equalTo("kronenkranich")));
		assertThat(StringUtils.uncapitalize("WeißStirnSpint"), is(equalTo("weißStirnSpint")));
		assertThat(StringUtils.uncapitalize("Griechische Landschildkröte"), is(equalTo("griechische landschildkröte")));
		assertThat(StringUtils.uncapitalize("Schrecklicher Giftfrosch"), is(equalTo("schrecklicher giftfrosch")));
		assertThat(StringUtils.uncapitalize("Koi-Karpfen"), is(equalTo("koi-karpfen")));
	}

}
