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
 * Builder making manipulation with date components more comfortable.
 * <p>
 * NOTE: Expect this class to become deprecated after the new Java Date/Time API (JSR 310) is released.
 *
 * @author Petr Zelenka
 */
@Beta
public class DateBuilder {

	private Calendar calendar;


	DateBuilder(Calendar calendar) {
		assert calendar != null;

		this.calendar = (Calendar) calendar.clone();
	}


	/**
	 * Adds the specified number of days to the instant represented by this builder.
	 */
	public DateBuilder addDays(int days) {
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return this;
	}

	/**
	 * Adds the specified number of hours to the instant represented by this builder.
	 */
	public DateBuilder addHours(int hours) {
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return this;
	}

	/**
	 * Adds the specified number of milliseconds to the instant represented by this builder.
	 */
	public DateBuilder addMilliseconds(int milliseconds) {
		calendar.add(Calendar.MILLISECOND, milliseconds);
		return this;
	}

	/**
	 * Adds the specified number of minutes to the instant represented by this builder.
	 */
	public DateBuilder addMinutes(int minutes) {
		calendar.add(Calendar.MINUTE, minutes);
		return this;
	}

	/**
	 * Adds the specified number of months to the instant represented by this builder.
	 */
	public DateBuilder addMonths(int months) {
		calendar.add(Calendar.MONTH, months);
		return this;
	}

	/**
	 * Adds the specified number of seconds to the instant represented by this builder.
	 */
	public DateBuilder addSeconds(int seconds) {
		calendar.add(Calendar.SECOND, seconds);
		return this;
	}

	/**
	 * Adds the specified number of weeks to the instant represented by this builder.
	 */
	public DateBuilder addWeeks(int weeks) {
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		return this;
	}

	/**
	 * Adds the specified number of years to the instant represented by this builder.
	 */
	public DateBuilder addYears(int years) {
		calendar.add(Calendar.YEAR, years);
		return this;
	}

	/**
	 * Returns the {@link Date} object represented by this builder.
	 */
	public Date build() {
		return calendar.getTime();
	}

	/**
	 * Sets the day of month of the instant represented by this builder.
	 */
	public DateBuilder withDayOfMonth(int dayOfMonth) {
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return this;
	}

	/**
	 * Sets the day of week of the instant represented by this builder.
	 * <p>
	 * The {@code dayOfWeek} parameter takes values {@link Calendar#SUNDAY}, {@link Calendar#MONDAY}, {@link Calendar#TUESDAY}, {@link Calendar#WEDNESDAY}, {@link Calendar#THURSDAY}, {@link Calendar#FRIDAY}, and {@link Calendar#SATURDAY}.
	 */
	public DateBuilder withDayOfWeek(int dayOfWeek) {
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return this;
	}

	/**
	 * Sets the day of week in month of the instant represented by this builder.
	 *
	 * @see Calendar#DAY_OF_WEEK_IN_MONTH
	 */
	public DateBuilder withDayOfWeekInMonth(int dayOfWeekInMonth) {
		calendar.set(Calendar.DAY_OF_WEEK_IN_MONTH, dayOfWeekInMonth);
		return this;
	}

	/**
	 * Sets the day of year of the instant represented by this builder.
	 */
	public DateBuilder withDayOfYear(int dayOfYear) {
		calendar.set(Calendar.DAY_OF_YEAR, dayOfYear);
		return this;
	}

	/**
	 * Sets the hour of the instant represented by this builder.
	 * Uses 12-hour format.
	 * <p>
	 * The {@code amPmIndicator} parameter takes values {@link Calendar#AM} and {@link Calendar#PM}.
	 */
	public DateBuilder withHour(int hour, int amPmIndicator) {
		calendar.set(Calendar.HOUR, hour);
		calendar.set(Calendar.AM_PM, amPmIndicator);
		return this;
	}

	/**
	 * Sets the hour of day of the instant represented by this builder.
	 * Uses 24-hour format.
	 */
	public DateBuilder withHourOfDay(int hourOfDay) {
		calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
		return this;
	}

	/**
	 * Sets the millisecond of the instant represented by this builder.
	 */
	public DateBuilder withMillisecond(int millisecond) {
		calendar.set(Calendar.MILLISECOND, millisecond);
		return this;
	}

	/**
	 * Sets the minute of the instant represented by this builder.
	 */
	public DateBuilder withMinute(int minute) {
		calendar.set(Calendar.MINUTE, minute);
		return this;
	}

	/**
	 * Sets the month of the instant represented by this builder.
	 * <p>
	 * The {@code month} parameter takes values {@link Calendar#JANUARY}, {@link Calendar#FEBRUARY}, {@link Calendar#MARCH}, {@link Calendar#APRIL}, {@link Calendar#MAY}, {@link Calendar#JUNE}, {@link Calendar#JULY}, {@link Calendar#AUGUST}, {@link Calendar#SEPTEMBER}, {@link Calendar#OCTOBER}, {@link Calendar#NOVEMBER}, {@link Calendar#DECEMBER}, and {@link Calendar#UNDECIMBER}.
	 */
	public DateBuilder withMonth(int month) {
		calendar.set(Calendar.MONTH, month);
		return this;
	}

	/**
	 * Sets the second of the instant represented by this builder.
	 */
	public DateBuilder withSecond(int second) {
		calendar.set(Calendar.SECOND, second);
		return this;
	}

	/**
	 * Sets the week of month of the instant represented by this builder.
	 */
	public DateBuilder withWeekOfMonth(int weekOfMonth) {
		calendar.set(Calendar.WEEK_OF_MONTH, weekOfMonth);
		return this;
	}

	/**
	 * Sets the week of year of the instant represented by this builder.
	 */
	public DateBuilder withWeekOfYear(int weekOfYear) {
		calendar.set(Calendar.WEEK_OF_YEAR, weekOfYear);
		return this;
	}

	/**
	 * Sets the year of the instant represented by this builder.
	 */
	public DateBuilder withYear(int year) {
		calendar.set(Calendar.YEAR, year);
		return this;
	}

}
