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

public class HttpSource implements Initialisable, MuleContextAware, FlowConstructAware
{

  private HttpSourcePre pre;
  private HttpSourcePost post;
  private FlowConstruct flowConstruct;
  private MuleContext context;

  public HttpSourcePre getPre() {
    return pre;
  }

  public void setPre(HttpSourcePre pre) {
    this.pre = pre;
  }

  public HttpSourcePost getPost() {
    return post;
  }

  public void setPost(HttpSourcePost post) {
    this.post = post;
  }

  @Override
  public void initialise() throws InitialisationException
  {
    if (pre != null)
    {
      initialiseIfNeeded(pre, context, flowConstruct);
    }
    if (post != null)
    {
      initialiseIfNeeded(post, context, flowConstruct);
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
