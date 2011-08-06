package org.sellcom.sjees.datetime;

import java.util.Calendar;
import java.util.Date;

import org.sellcom.sjees.lang.archetype.Builder;

import com.google.common.annotations.Beta;

/**
 * Builder making manipulation with date components more comfortable.
 * <p>
 * NOTE: Expect this class to become deprecated after the new Java Date/Time API (JSR 310) is released.
 *
 * @author Petr Zelenka
 */
@Beta
public class DateBuilder implements Builder<Date> {

	private Calendar calendar;


	DateBuilder(Calendar calendar) {
		assert calendar != null;

		this.calendar = (Calendar) calendar.clone();
	}


	/**
	 * Adds the given number of days to the instant represented by this builder.
	 */
	public DateBuilder addDays(int days) {
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return this;
	}

	/**
	 * Adds the given number of hours to the instant represented by this builder.
	 */
	public DateBuilder addHours(int hours) {
		calendar.add(Calendar.HOUR_OF_DAY, hours);
		return this;
	}

	/**
	 * Adds the given number of milliseconds to the instant represented by this builder.
	 */
	public DateBuilder addMilliseconds(int milliseconds) {
		calendar.add(Calendar.MILLISECOND, milliseconds);
		return this;
	}

	/**
	 * Adds the given number of minutes to the instant represented by this builder.
	 */
	public DateBuilder addMinutes(int minutes) {
		calendar.add(Calendar.MINUTE, minutes);
		return this;
	}

	/**
	 * Adds the given number of months to the instant represented by this builder.
	 */
	public DateBuilder addMonths(int months) {
		calendar.add(Calendar.MONTH, months);
		return this;
	}

	/**
	 * Adds the given number of seconds to the instant represented by this builder.
	 */
	public DateBuilder addSeconds(int seconds) {
		calendar.add(Calendar.SECOND, seconds);
		return this;
	}

	/**
	 * Adds the given number of weeks to the instant represented by this builder.
	 */
	public DateBuilder addWeeks(int weeks) {
		calendar.add(Calendar.WEEK_OF_YEAR, weeks);
		return this;
	}

	/**
	 * Adds the given number of years to the instant represented by this builder.
	 */
	public DateBuilder addYears(int years) {
		calendar.add(Calendar.YEAR, years);
		return this;
	}

	@Override
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
	 */
	public DateBuilder withDayOfWeek(int dayOfWeek) {
		calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return this;
	}

	/**
	 * Sets the day of week in month of the instant represented by this builder.
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
	 */
	public DateBuilder withHour(int hour) {
		calendar.set(Calendar.HOUR, hour);
		return this;
	}

	/**
	 * Sets the hour of day of the instant represented by this builder.
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
