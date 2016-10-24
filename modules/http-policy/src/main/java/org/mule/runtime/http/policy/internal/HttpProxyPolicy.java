/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

import static org.mule.runtime.core.api.lifecycle.LifecycleUtils.initialiseIfNeeded;
import org.mule.runtime.core.api.Event;
import org.mule.runtime.core.api.MuleContext;
import org.mule.runtime.core.api.MuleException;
import org.mule.runtime.core.api.construct.FlowConstruct;
import org.mule.runtime.core.api.construct.FlowConstructAware;
import org.mule.runtime.core.api.context.MuleContextAware;
import org.mule.runtime.core.api.lifecycle.Initialisable;
import org.mule.runtime.core.api.lifecycle.InitialisationException;
import org.mule.runtime.core.api.lifecycle.LifecycleUtils;
import org.mule.runtime.core.config.ComponentIdentifier;
import org.mule.runtime.core.policy.OperationPolicy;
import org.mule.runtime.core.policy.OperationPolicyInstance;

public class HttpProxyPolicy implements OperationPolicy, Initialisable, MuleContextAware, FlowConstructAware
{

    private HttpRequest request;
    private HttpSource source;
    private FlowConstruct flowConstruct;
    private MuleContext context;

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
        return sourceIdentifier.toString().equals("httpn:listener");
    }

    @Override
    public boolean appliesToOperation(ComponentIdentifier operationIdentifier)
    {
        return operationIdentifier.toString().equals("httpn:request");
    }

    @Override
    public OperationPolicyInstance createSourcePolicyInstance(ComponentIdentifier operationIdentifier)
    {
        return new OperationPolicyInstance()
        {
            Event attachedEvent;

            @Override
            public Event processSourcePre(Event sourceEvent) throws MuleException
            {
                if (source != null && source.getPre() != null)
                {
                    return source.getPre().process(sourceEvent);
                }
                return sourceEvent;
            }

            @Override
            public Event processOperationPre(Event eventBeforeOperation) throws MuleException
            {
                if (request != null && request.getPre() != null)
                {
                    return request.getPre().process(eventBeforeOperation);
                }
                return eventBeforeOperation;
            }

            @Override
            public OperationPolicy getOperationPolicy()
            {
                //TODO the inner class should not serialize the parent instance, we need to refactor this
                return HttpProxyPolicy.this;
            }

            @Override
            public void attachEvent(Event policyResultEvent)
            {
                this.attachedEvent = policyResultEvent;
            }

            @Override
            public Event getAttachedEvent()
            {
                return attachedEvent;
            }
        };
    }

    @Override
    public void initialise() throws InitialisationException
    {
        if (source != null)
        {
            initialiseIfNeeded(source, context, flowConstruct);
        }
        if (request != null)
        {
            initialiseIfNeeded(request, context, flowConstruct);
        }
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
