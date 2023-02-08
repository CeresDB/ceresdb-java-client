/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.ceresdb.common.util;

import java.util.concurrent.Executor;

import org.junit.Assert;
import org.junit.Test;

public class DirectExecutorTest {

    @Test
    public void selfExecuteTest() {
        final Executor executor = new DirectExecutor("test");
        final Thread t = Thread.currentThread();
        final RefCell<Thread> t2 = new RefCell<>();
        executor.execute(() -> t2.set(Thread.currentThread()));
        Assert.assertSame(t, t2.get());
    }
}
