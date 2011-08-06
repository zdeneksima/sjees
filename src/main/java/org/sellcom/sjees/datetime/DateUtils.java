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
package org.sellcom.sjees.datetime;

import java.util.Calendar;
import java.util.Date;

import com.google.common.annotations.Beta;

/**
 * Utility class containing methods implementing common operations with {@code Date}s.
 * <p>
 * NOTE: Expect this class to become deprecated after the new Java Date/Time API (JSR 310) is released.
 *
 * @author Petr Zelenka
 */
@Beta
public class DateUtils {

	private DateUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns a {@link DateBuilder} representing the epoch instant.
	 */
	public static DateBuilder builderBasedOnEpoch() {
		return new DateBuilder(toCalendar(0));
	}

	/**
	 * Returns a {@link DateBuilder} representing the given instant.
	 */
	public static DateBuilder builderBasedOnInstant(Date instant) {
		return new DateBuilder(toCalendar(instant));
	}

	/**
	 * Returns a {@link DateBuilder} representing the current instant.
	 */
	public static DateBuilder builderBasedOnNow() {
		return new DateBuilder(Calendar.getInstance());
	}


	private static Calendar toCalendar(long millisecondsFromEpoch) {
		Calendar result = Calendar.getInstance();
		result.setTimeInMillis(millisecondsFromEpoch);
		return result;
	}

	private static Calendar toCalendar(Date instant) {
		Calendar result = Calendar.getInstance();
		result.setTime(instant);
		return result;
	}

}
