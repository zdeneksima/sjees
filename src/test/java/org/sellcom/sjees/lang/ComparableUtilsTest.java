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
package org.sellcom.sjees.lang;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.junit.Test;
import org.sellcom.sjees.datetime.DateUtils;

public class ComparableUtilsTest {

	@Test
	public void testMax() {
		assertThat(ComparableUtils.max(1, 2, 3, 4, 5), is(equalTo(5)));
		assertThat(ComparableUtils.max(1L, 2L, 3L, 4L, 5L), is(equalTo(5L)));
		assertThat(ComparableUtils.max(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5)), is(equalTo(BigInteger.valueOf(5))));

		assertThat(ComparableUtils.max(1.0, 2.0, 3.0, 4.0, 5.0), is(closeTo(5.0, 0.001)));
		assertThat(ComparableUtils.max(BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0), BigDecimal.valueOf(3.0), BigDecimal.valueOf(4.0), BigDecimal.valueOf(5.0)), is(equalTo(BigDecimal.valueOf(5.0))));

		Date d1 = DateUtils.builderBasedOnNow().withYear(2001).build();
		Date d2 = DateUtils.builderBasedOnNow().withYear(2002).build();
		Date d3 = DateUtils.builderBasedOnNow().withYear(2003).build();
		Date d4 = DateUtils.builderBasedOnNow().withYear(2004).build();
		Date d5 = DateUtils.builderBasedOnNow().withYear(2005).build();

		assertThat(ComparableUtils.max(d1, d2, d3, d4, d5), is(equalTo(d5)));

		assertThat(ComparableUtils.max("A", "B", "C", "D", "E"), is(equalTo("E")));
	}

	@Test
	public void testMin() {
		assertThat(ComparableUtils.min(1, 2, 3, 4, 5), is(equalTo(1)));
		assertThat(ComparableUtils.min(1L, 2L, 3L, 4L, 5L), is(equalTo(1L)));
		assertThat(ComparableUtils.min(BigInteger.valueOf(1), BigInteger.valueOf(2), BigInteger.valueOf(3), BigInteger.valueOf(4), BigInteger.valueOf(5)), is(equalTo(BigInteger.valueOf(1))));

		assertThat(ComparableUtils.min(1.0, 2.0, 3.0, 4.0, 5.0), is(closeTo(1.0, 0.001)));
		assertThat(ComparableUtils.min(BigDecimal.valueOf(1.0), BigDecimal.valueOf(2.0), BigDecimal.valueOf(3.0), BigDecimal.valueOf(4.0), BigDecimal.valueOf(5.0)), is(equalTo(BigDecimal.valueOf(1.0))));

		Date d1 = DateUtils.builderBasedOnNow().withYear(2001).build();
		Date d2 = DateUtils.builderBasedOnNow().withYear(2002).build();
		Date d3 = DateUtils.builderBasedOnNow().withYear(2003).build();
		Date d4 = DateUtils.builderBasedOnNow().withYear(2004).build();
		Date d5 = DateUtils.builderBasedOnNow().withYear(2005).build();

		assertThat(ComparableUtils.min(d1, d2, d3, d4, d5), is(equalTo(d1)));

		assertThat(ComparableUtils.min("A", "B", "C", "D", "E"), is(equalTo("A")));
	}

}
