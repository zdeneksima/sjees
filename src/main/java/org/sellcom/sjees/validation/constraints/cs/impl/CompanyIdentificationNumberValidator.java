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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sellcom.sjees.annotations.NotApi;
import org.sellcom.sjees.validation.constraints.cs.NationalIdentificationNumber;

@NotApi
public class CompanyIdentificationNumberValidator implements ConstraintValidator<NationalIdentificationNumber, String> {

	private static final Pattern GENERAL_SYNTAX = Pattern.compile("(\\d{8})");


	@Override
	public void initialize(NationalIdentificationNumber constraint) {
		// Nothing to do.
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value == null) {
			return true;
		}

		// Validate general syntax

		Matcher matcher = GENERAL_SYNTAX.matcher(value);

		if (!matcher.matches()) {
			return false;
		}

		// Validate check digit

		int checkDigit = Integer.valueOf(value.charAt(7) - '0');
		int checkSum = 0;

		for (int i = 0; i < 7; i++) {
			checkSum += Integer.valueOf(value.charAt(i) - '0') * (8 - i);
		}
		checkSum = checkSum % 11;

		int remainder = 11 - checkSum;
		remainder = ((checkSum == 0) || (checkSum == 10)) ? 1 : remainder;
		remainder = (checkSum == 1) ? 0 : remainder;

		return checkDigit == remainder;
	}

}
