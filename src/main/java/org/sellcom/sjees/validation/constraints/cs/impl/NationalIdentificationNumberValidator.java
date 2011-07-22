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

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.sellcom.sjees.annotations.NotApi;
import org.sellcom.sjees.text.StringUtils;
import org.sellcom.sjees.validation.constraints.cs.NationalIdentificationNumber;

@NotApi
public class NationalIdentificationNumberValidator implements ConstraintValidator<NationalIdentificationNumber, String> {

	private static final Pattern GENERAL_SYNTAX = Pattern.compile("(\\d{2})(\\d{2})(\\d{2})/?(\\d{3})(\\d?)");


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

		// Validate year of birth if no check digit is present

		Integer checkDigit = Integer.valueOf(StringUtils.firstNonEmpty(matcher.group(5), "-1"));

		Integer yearOfBirth = Integer.valueOf(matcher.group(1));
		yearOfBirth += ((yearOfBirth < 54) && (checkDigit < 0)) ? 1900 : 2000;

		if ((checkDigit < 0) && (yearOfBirth > 1953)) {
			return false;
		}

		// Validate date of birth

		Integer monthOfBirth = Integer.valueOf(matcher.group(2));
		monthOfBirth -= (monthOfBirth > 50) ? 50 : 0;
		monthOfBirth -= (monthOfBirth > 20) ? 20 : 0;

		Integer dayOfBirth = Integer.valueOf(matcher.group(3));
		dayOfBirth -= (dayOfBirth > 50) ? 50 : 0;

		try {
			Calendar calendar = new GregorianCalendar();
			calendar.setLenient(false);
			calendar.set(Calendar.YEAR, yearOfBirth);
			calendar.set(Calendar.MONTH, monthOfBirth - 1); // Months are indexed from 0
			calendar.set(Calendar.DATE, dayOfBirth);
			calendar.getTime();
		} catch (Exception e) {
			return false;
		}

		// Validate check digit

		if (checkDigit > -1) {
			int remainder = Integer.valueOf(value.replaceAll("/", "").substring(0, 9)) % 11;
			remainder = (remainder == 10) ? 0 : remainder;

			if (checkDigit != remainder) {
				return false;
			}
		}

		return true;
	}

}
