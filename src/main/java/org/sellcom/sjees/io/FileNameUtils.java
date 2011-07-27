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

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * Utility class containing methods implementing common operations with {@code File} names.
 *
 * @author Petr Zelenka
 */
@Beta
public class FileNameUtils {

	private FileNameUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns the extension part of the given file name.
	 * Returns an empty string if the file name does not contain an extension.
	 * <p>
	 * <b>NOTE:</b> The file name passed to this function must not contain any path delimiting characters.
	 * This contract is not enforced in any way and the responsibility to adhere to it is left solely on the user.
	 * If not satisfied, the function may provide incorrect results or fail otherwise without further notice.
	 * <p>
	 * Unix hidden files are handled correctly: {@code getExtension(".gitignore") == ""}
	 *
	 * @throws IllegalArgumentException if {@code fileName} is {@code null} or empty
	 */
	public static String getExtension(String fileName) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "File name cannot be null or empty");

		int positionOfLastDot = fileName.lastIndexOf('.');
		return positionOfLastDot > 0 ? fileName.substring(positionOfLastDot + 1) : "";
	}

	/**
	 * Returns the name part of the given file name.
	 * <p>
	 * <b>NOTE:</b> The file name passed to this function must not contain any path delimiting characters.
	 * This contract is not enforced in any way and the responsibility to adhere to it is left solely on the user.
	 * If not satisfied, the function may provide incorrect results or fail otherwise without further notice.
	 * <p>
	 * Unix hidden files are handled correctly: {@code getNameWithoutExtension(".gitignore") == ".gitignore"}
	 *
	 * @throws IllegalArgumentException if {@code fileName} is {@code null} or empty
	 */
	public static String getNameWithoutExtension(String fileName) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "File name cannot be null or empty");

		int positionOfLastDot = fileName.lastIndexOf('.');
		return positionOfLastDot > 0 ? fileName.substring(0, positionOfLastDot) : fileName;
	}

}
