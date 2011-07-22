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

	/**
	 * Installation directory of the Java Runtime Environment (JRE).
	 */
	public static final String JAVA_HOME_DIRECTORY = System.getProperty("java.home");

	/**
	 * Working directory of the Java Runtime Environment (JRE).
	 */
	public static final String JAVA_WORKING_DIRECTORY = System.getProperty("user.dir");

	/**
	 * System-dependent separator of lines in text files.
	 * <p>
	 * On most UNIX systems, the value of this constant is "\n"; on Microsoft Windows systems, it is "\r\n".
	 */
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");

	/**
	 * System-dependent separator of components in a file path.
	 * <p>
	 * On most UNIX systems, the value of this constant is "/"; on Microsoft Windows systems, it is "\\".
	 */
	public static final String PATH_COMPONENT_SEPARATOR = System.getProperty("file.separator").substring(0, 1);

	/**
	 * System-dependent separator of directories in the PATH environment variable.
	 * <p>
	 * On UNIX systems, the value of this constant is ":"; on Microsoft Windows systems, it is ";".
	 */
	public static final String PATH_SEPARATOR = System.getProperty("path.separator").substring(0, 1);

	/**
	 * Home directory of the current user.
	 */
	public static final String USER_HOME_DIRECTORY = System.getProperty("user.home");


	private FileNameUtils() {
		// Utility class. Not to be instantiated.
	}


	/**
	 * Returns the extension part of the given file name.
	 * Returns an empty string if the file name does not contain an extension.
	 * <p>
	 * Unix hidden files are handled correctly: {@code getExtension(".ssh") == ""}
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
	 * Unix hidden files are handled correctly: {@code getNameWithoutExtension(".ssh") == ".ssh"}
	 *
	 * @throws IllegalArgumentException if {@code fileName} is {@code null} or empty
	 */
	public static String getNameWithoutExtension(String fileName) {
		Preconditions.checkArgument(!Strings.isNullOrEmpty(fileName), "File name cannot be null or empty");

		int positionOfLastDot = fileName.lastIndexOf('.');
		return positionOfLastDot > 0 ? fileName.substring(0, positionOfLastDot) : fileName;
	}

}
