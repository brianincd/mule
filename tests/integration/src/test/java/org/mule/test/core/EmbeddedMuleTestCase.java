/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.test.core;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.mule.runtime.config.spring.SpringXmlConfigurationBuilder;
import org.mule.runtime.core.api.MuleContext;
import org.mule.runtime.core.api.config.ConfigurationException;
import org.mule.runtime.core.api.context.MuleContextFactory;
import org.mule.runtime.core.api.registry.RegistrationException;
import org.mule.runtime.core.context.DefaultMuleContextFactory;
import org.mule.tck.SingleThreadSchedulerService;
import org.mule.tck.junit4.AbstractMuleTestCase;

import org.junit.Test;

public class EmbeddedMuleTestCase extends AbstractMuleTestCase {

  @Test
  public void testStartup() throws Exception {
    SpringXmlConfigurationBuilder builder = new SpringXmlConfigurationBuilder("org/mule/test/spring/mule-root-test.xml") {

      @Override
      public void configure(MuleContext muleContext) throws ConfigurationException {
        super.configure(muleContext);
        try {
          muleContext.getRegistry().registerObject("SingleThreadSchedulerService", new SingleThreadSchedulerService());
        } catch (RegistrationException e) {
          throw new ConfigurationException(e);
        }
      }
    };
    MuleContextFactory muleContextFactory = new DefaultMuleContextFactory();
    MuleContext context = muleContextFactory.createMuleContext(builder);
    // MuleContext must be started explicitly after MULE-1988
    assertFalse(context.isStarted());
    context.start();
    assertTrue(context.isStarted());

    context.dispose();
  }
}
