package org.sellcom.sjees.datetime;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class DateBuilderTest {

	@Test
	public void test() {
		Date d1 = DateUtils.builderBasedOnEpoch()
				.withYear(2011)
				.withMonth(Calendar.JULY)
				.withDayOfMonth(19)
				.withHourOfDay(11)
				.withMinute(2)
				.withSecond(5)
				.withMillisecond(330)
				.build();

		Calendar c1 = DateUtils.toCalendar(d1);

		assertThat(c1.get(Calendar.YEAR), is(equalTo(2011)));
		assertThat(c1.get(Calendar.MONTH), is(equalTo(Calendar.JULY)));
		assertThat(c1.get(Calendar.DAY_OF_YEAR), is(equalTo(200)));
		assertThat(c1.get(Calendar.DAY_OF_MONTH), is(equalTo(19)));
		assertThat(c1.get(Calendar.DAY_OF_WEEK), is(equalTo(Calendar.TUESDAY)));
		assertThat(c1.get(Calendar.HOUR_OF_DAY), is(equalTo(11)));
		assertThat(c1.get(Calendar.HOUR), is(equalTo(11)));
		assertThat(c1.get(Calendar.AM_PM), is(equalTo(Calendar.AM)));
		assertThat(c1.get(Calendar.MINUTE), is(equalTo(2)));
		assertThat(c1.get(Calendar.SECOND), is(equalTo(5)));
		assertThat(c1.get(Calendar.MILLISECOND), is(equalTo(330)));

		Date d2 = DateUtils.builderBasedOnInstant(d1)
				.addYears(1)
				.addMonths(2)
				.addDays(-8)
				.addHours(6)
				.addMinutes(-5)
				.addSeconds(0)
				.addMilliseconds(-130)
				.build();

		Calendar c2 = DateUtils.toCalendar(d2);

		assertThat(c2.get(Calendar.YEAR), is(equalTo(2012)));
		assertThat(c2.get(Calendar.MONTH), is(equalTo(Calendar.SEPTEMBER)));
		assertThat(c2.get(Calendar.DAY_OF_YEAR), is(equalTo(255)));
		assertThat(c2.get(Calendar.DAY_OF_MONTH), is(equalTo(11)));
		assertThat(c2.get(Calendar.DAY_OF_WEEK), is(equalTo(Calendar.TUESDAY)));
		assertThat(c2.get(Calendar.HOUR_OF_DAY), is(equalTo(16)));
		assertThat(c2.get(Calendar.HOUR), is(equalTo(4)));
		assertThat(c2.get(Calendar.AM_PM), is(equalTo(Calendar.PM)));
		assertThat(c2.get(Calendar.MINUTE), is(equalTo(57)));
		assertThat(c2.get(Calendar.SECOND), is(equalTo(5)));
		assertThat(c2.get(Calendar.MILLISECOND), is(equalTo(200)));
	}

}
