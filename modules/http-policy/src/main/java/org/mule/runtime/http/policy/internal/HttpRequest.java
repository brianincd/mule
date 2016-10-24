/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

import static org.mule.runtime.core.api.lifecycle.LifecycleUtils.initialiseIfNeeded;
import org.mule.runtime.core.api.MuleContext;
import org.mule.runtime.core.api.construct.FlowConstruct;
import org.mule.runtime.core.api.construct.FlowConstructAware;
import org.mule.runtime.core.api.context.MuleContextAware;
import org.mule.runtime.core.api.lifecycle.Initialisable;
import org.mule.runtime.core.api.lifecycle.InitialisationException;

public class HttpRequest implements Initialisable, MuleContextAware, FlowConstructAware
{

    private HttpRequestPre pre;
    private HttpRequestPost post;
    private FlowConstruct flowConstruct;
    private MuleContext context;

    public HttpRequestPre getPre()
    {
        return pre;
    }

    public void setPre(HttpRequestPre pre)
    {
        this.pre = pre;
    }

    public HttpRequestPost getPost()
    {
        return post;
    }

    public void setPost(HttpRequestPost post)
    {
        this.post = post;
    }

    @Override
    public void initialise() throws InitialisationException
    {
        initialiseIfNeeded(pre, context, flowConstruct);
        initialiseIfNeeded(post, context, flowConstruct);
    }

    @Override
    public void setFlowConstruct(FlowConstruct flowConstruct)
    {
        this.flowConstruct = flowConstruct;
    }

    @Override
    public void setMuleContext(MuleContext context)
    {
        this.context = context;
    }
}
