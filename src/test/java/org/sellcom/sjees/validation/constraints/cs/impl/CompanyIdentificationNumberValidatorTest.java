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
package org.sellcom.sjees.validation.constraints.cs.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class CompanyIdentificationNumberValidatorTest {

	private CompanyIdentificationNumberValidator validator;


	@Before
	public void setUp() {
		validator = new CompanyIdentificationNumberValidator();
	}

	@Test
	public void testIsValid() {
		assertTrue(validator.isValid("00001350", null)); // Československá obchodní banka, a.s.
		assertTrue(validator.isValid("00177041", null)); // ŠKODA AUTO, a.s.
		assertTrue(validator.isValid("00514152", null)); // Budějovický Budvar, n.p.
		assertTrue(validator.isValid("25317075", null)); // STUDENT AGENCY, s.r.o.
		assertTrue(validator.isValid("25733591", null)); // E.ON Česká republika, s.r.o.
		assertTrue(validator.isValid("25788001", null)); // Vodafone Czech Republic, a.s.
		assertTrue(validator.isValid("27082440", null)); // Alza.cz, a.s.
		assertTrue(validator.isValid("28080301", null)); // Intelis, s.r.o.
		assertTrue(validator.isValid("28244532", null)); // Letiště Praha, a.s.
		assertTrue(validator.isValid("44268050", null)); // Baťa, a.s.
		assertTrue(validator.isValid("45244782", null)); // Česká spořitelna, a.s.
		assertTrue(validator.isValid("45274649", null)); // ČEZ, a.s.
		assertTrue(validator.isValid("45317054", null)); // Komerční banka, a.s.
		assertTrue(validator.isValid("45357366", null)); // Plzeňský Prazdroj, a.s.
		assertTrue(validator.isValid("45795908", null)); // České aerolinie, a.s.
		assertTrue(validator.isValid("47114983", null)); // Česká pošta, s.p.
		assertTrue(validator.isValid("49240901", null)); // Raiffeisenbank, a.s.
		assertTrue(validator.isValid("60193336", null)); // Telefónica Czech Republic, a.s.
		assertTrue(validator.isValid("60193913", null)); // Pražská energetika, a.s.
		assertTrue(validator.isValid("63473291", null)); // Globus ČR, k.s.
		assertTrue(validator.isValid("70994226", null)); // České dráhy, a.s.
	}

}
