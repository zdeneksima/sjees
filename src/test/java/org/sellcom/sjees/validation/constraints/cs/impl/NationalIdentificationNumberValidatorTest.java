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

public class NationalIdentificationNumberValidatorTest {

	private NationalIdentificationNumberValidator validator;


	@Before
	public void setUp() {
		validator = new NationalIdentificationNumberValidator();
	}

	@Test
	public void testIsValid() {
		assertTrue(validator.isValid("780123/3540", null));
		assertTrue(validator.isValid("053113/5099", null));
		assertTrue(validator.isValid("068118/6066", null));
	}

}
