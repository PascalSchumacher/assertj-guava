/**
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 *
 * Copyright 2012-2015 the original author or authors.
 */
package org.assertj.guava.api;

import static org.assertj.core.util.FailureMessages.actualIsNull;
import static org.assertj.guava.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.base.Optional;

public class OptionalAssert_extractingCharSequence_Test extends BaseTest {

  @Test
  public void should_fail_if_actual_is_null() {
	// given
	Optional<String> actual = null;
	// expect
	expectException(AssertionError.class, actualIsNull());
	// when
	assertThat(actual).extractingCharSequence();
  }

  @Test
  public void should_fail_when_optional_contains_nothing() {
	// given
	final Optional<String> testedOptional = Optional.absent();
	// expect
	expectException(AssertionError.class,
	                "Expecting Optional to contain a non-null instance but contained nothing (absent Optional)");
	// when
	assertThat(testedOptional).extractingCharSequence();
  }

  @Test
  public void should_pass_when_actual_contains_a_value() {
	// given
	final Optional<String> testedOptional = Optional.of("Test");
	// when
	assertThat(testedOptional).extractingCharSequence().isEqualTo("Test");
	// then pass
  }

  @Test
  public void should_not_pass_when_actual_contains_other_than_charSequence() {
	// given
	final Optional<? extends Number> testedOptional = Optional.of(12L);
	// expect
	expectException(AssertionError.class, "");
	// when
	assertThat(testedOptional).extractingCharSequence();
	// then pass
  }
}
