/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

import org.mule.runtime.core.api.Event;
import org.mule.runtime.core.api.MuleException;
import org.mule.runtime.core.config.ComponentIdentifier;
import org.mule.runtime.core.policy.OperationPolicy;
import org.mule.runtime.core.policy.OperationPolicyInstance;

public class HttpProxyPolicy implements OperationPolicy
{

    private HttpRequest request;
    private HttpSource source;

    public HttpRequest getRequest()
    {
        return request;
    }

    public void setRequest(HttpRequest request)
    {
        this.request = request;
    }

    public HttpSource getSource()
    {
        return source;
    }

    public void setSource(HttpSource source)
    {
        this.source = source;
    }

    @Override
    public boolean appliesToSource(ComponentIdentifier sourceIdentifier)
    {
        return sourceIdentifier.toString().equals("http:listener");
    }

    @Override
    public boolean appliesToOperation(ComponentIdentifier operationIdentifier)
    {
        return operationIdentifier.toString().equals("http:requesrt");
    }

    @Override
    public OperationPolicyInstance createSourcePolicyInstance(ComponentIdentifier operationIdentifier)
    {
        return new OperationPolicyInstance()
        {
            @Override
            public Event processSourcePre(Event sourceEvent) throws MuleException
            {
                return source.getPre().process(sourceEvent);
            }

            @Override
            public Event processSourcePost(Event flowResultEvent) throws MuleException
            {
                return source.getPost().process(flowResultEvent);
            }

            @Override
            public Event processOperationPre(Event eventBeforeOperation) throws MuleException
            {
                return request.getPre().process(eventBeforeOperation);
            }

            @Override
            public Event processOperationPost(Event eventAfterOperation) throws MuleException
            {
                return request.getPost().process(eventAfterOperation);
            }

            @Override
            public OperationPolicy getOperationPolicy()
            {
                //TODO the inner class should not serialize the parent instance, we need to refactor this
                return HttpProxyPolicy.this;
            }
        };
    }
}
