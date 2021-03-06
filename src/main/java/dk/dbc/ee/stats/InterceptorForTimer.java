/*
 * Copyright (C) 2018 DBC A/S (http://dbc.dk/)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package dk.dbc.ee.stats;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.AroundTimeout;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author Source (source (at) dbc.dk)
 */
@Interceptor
@Priority(Interceptor.Priority.LIBRARY_BEFORE + 10)
@Timed
public class InterceptorForTimer {

    @Inject
    MetricReporter reporter;

    @AroundInvoke
    @AroundTimeout
    public Object aroundInvoke(InvocationContext ic) throws Exception {
        return reporter.invoke(ic.getMethod(), ic);
    }

}
