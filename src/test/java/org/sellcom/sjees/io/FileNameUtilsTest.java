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
package org.sellcom.sjees.io;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class FileNameUtilsTest {

	@Test
	public void testGetExtension() {
		assertThat(FileNameUtils.getExtension("FileNameUtils.java"), is(equalTo("java")));
		assertThat(FileNameUtils.getExtension(".gitignore"), is(equalTo("")));
		assertThat(FileNameUtils.getExtension("LICENSE"), is(equalTo("")));
		assertThat(FileNameUtils.getExtension("org.eclipse.core.runtime.prefs"), is(equalTo("prefs")));
	}

	@Test
	public void testGetName() {
		assertThat(FileNameUtils.getNameWithoutExtension("FileNameUtils.java"), is(equalTo("FileNameUtils")));
		assertThat(FileNameUtils.getNameWithoutExtension(".gitignore"), is(equalTo(".gitignore")));
		assertThat(FileNameUtils.getNameWithoutExtension("LICENSE"), is(equalTo("LICENSE")));
		assertThat(FileNameUtils.getNameWithoutExtension("org.eclipse.core.runtime.prefs"), is(equalTo("org.eclipse.core.runtime")));
	}

}
