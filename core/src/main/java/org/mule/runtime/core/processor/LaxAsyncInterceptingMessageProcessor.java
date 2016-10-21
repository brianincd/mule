/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.core.processor;

import org.mule.runtime.core.api.Event;
import org.mule.runtime.core.api.MuleException;
import org.mule.runtime.core.api.scheduler.SchedulerService;

public class LaxAsyncInterceptingMessageProcessor extends AsyncInterceptingMessageProcessor {

  public LaxAsyncInterceptingMessageProcessor(SchedulerService schedulerService) {
    super(schedulerService);
  }

  @Override
  protected boolean isProcessAsync(Event event) throws MuleException {
    return doThreading && canProcessAsync(event);
  }

}
