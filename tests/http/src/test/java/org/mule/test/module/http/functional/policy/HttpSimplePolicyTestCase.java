/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.test.module.http.functional.policy;

import org.mule.tck.junit4.rule.DynamicPort;
import org.mule.test.module.http.functional.AbstractHttpTestCase;

import org.junit.Rule;
import org.junit.Test;

public class HttpSimplePolicyTestCase extends AbstractHttpTestCase
{

    @Rule
    public DynamicPort proxyPort = new DynamicPort("proxyPort");

    @Rule
    public DynamicPort httpPort = new DynamicPort("httpPort");

    @Override
    protected String getConfigFile()
    {
        return "http-policy-config.xml";
    }

    @Test
    public void test()
    {

    }
}
