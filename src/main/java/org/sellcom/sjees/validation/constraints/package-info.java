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

/**
 * Constraints for JSR-303: Bean Validation.
 * <p>
 * All constraints define an internal annotation named {@code List}
 * that may be used to define several instances of that constraint on
 * the same element.
 * <p>
 * All constraints consider {@code null} elements to be valid.
 *
 * @author Petr Zelenka
 */
package org.sellcom.sjees.validation.constraints;
