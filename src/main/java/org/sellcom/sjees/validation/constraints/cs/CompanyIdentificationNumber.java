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
package org.sellcom.sjees.validation.constraints.cs;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.sellcom.sjees.validation.constraints.cs.impl.CompanyIdentificationNumberValidator;

import com.google.common.annotations.Beta;

/**
 * Requires the annotated element to be a valid company identification number ("identifikační číslo") used in Czech Republic.
 * <p>
 * The annotated element must be of type {@code String}.
 *
 * @author Petr Zelenka
 */
@Documented @Beta
@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CompanyIdentificationNumberValidator.class)
public @interface CompanyIdentificationNumber {

	Class<?>[] groups() default {};

	String message() default "{org.sellcom.sjees.validation.constraints.cs.CompanyIdentificationNumber.message}";

	Class<? extends Payload>[] payload() default {};

	@Documented
	@Target({ ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.PARAMETER })
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		CompanyIdentificationNumber[] value();
	}

}
