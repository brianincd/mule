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
import org.mule.runtime.core.api.processor.MessageProcessorChain;
import org.mule.runtime.core.api.processor.Processor;
import org.mule.runtime.core.processor.chain.DefaultMessageProcessorChainBuilder;

import java.util.List;

public abstract class AbstractPolicyChain implements Processor, Initialisable, FlowConstructAware, MuleContextAware
{

    private List<Processor> processors;
    private MessageProcessorChain processorChain;
    private FlowConstruct flowConstruct;
    private MuleContext muleContext;

    public void setProcessors(List<Processor> processors)
    {
        this.processors = processors;
    }

    @Override
    public Event process(Event event) throws MuleException
    {
        Event result = processorChain.process(event);
        return doProcess(result);
    }

    abstract Event doProcess(Event event);

    @Override
    public final void initialise() throws InitialisationException
    {
        initialiseIfNeeded(processors, muleContext, flowConstruct);
        processorChain = new DefaultMessageProcessorChainBuilder().chain(processors).build();
        initialiseIfNeeded(processorChain, muleContext, flowConstruct);
    }

    @Override
    public void setFlowConstruct(FlowConstruct flowConstruct)
    {
        this.flowConstruct = flowConstruct;
    }

    @Override
    public void setMuleContext(MuleContext context)
    {
        this.muleContext = context;
    }
}
