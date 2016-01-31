/*
 * Copyright (C) 2013-2016 terasoluna.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.terasoluna.gfw.common.date.jodatime;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Test;

public class DefaultJodaTimeDateFactoryTest {

    @Test
    public void testNewDateTime() {

        JodaTimeDateFactory factory = new DefaultJodaTimeDateFactory();

        long currentTimeMillis = System.currentTimeMillis();
        DateTimeUtils.setCurrentMillisFixed(currentTimeMillis);

        try {
            DateTime result = factory.newDateTime();

            assertThat(result.getMillis(), is(currentTimeMillis));

        } finally {
            DateTimeUtils.setCurrentMillisSystem();
        }

    }

}