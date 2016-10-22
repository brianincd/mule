/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.tck;

import org.mule.runtime.core.api.scheduler.Scheduler;
import org.mule.runtime.core.api.scheduler.SchedulerService;


public class SingleThreadSchedulerService implements SchedulerService {

  private Scheduler scheduler = new SingleThreadScheduler();

  public SingleThreadSchedulerService() {
    System.out.println("");
  }

  @Override
  public String getName() {
    return "SingleThreadSchedulerService";
  }

  @Override
  public Scheduler cpuLightScheduler() {
    return scheduler;
  }

  @Override
  public Scheduler ioScheduler() {
    return scheduler;
  }

  @Override
  public Scheduler computationScheduler() {
    return scheduler;
  }

}
