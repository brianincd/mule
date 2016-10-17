/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.api.connection.factory;

import org.mule.extensions.jms.api.connection.LookupJndiDestination;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSException;

/**
 * //TODO
 */
public class JndiConnectionFactory implements ConnectionFactory {

  @Parameter
  @Optional(defaultValue = "NEVER")
  private LookupJndiDestination lookupDestination;

  @Parameter
  @Optional //TODO
  private String providerUrl;

  @Override
  public Connection createConnection() throws JMSException {
    return null;
  }

  @Override
  public Connection createConnection(String s, String s1) throws JMSException {
    return null;
  }

  @Override
  public JMSContext createContext() {
    return null;
  }

  @Override
  public JMSContext createContext(String s, String s1) {
    return null;
  }

  @Override
  public JMSContext createContext(String s, String s1, int i) {
    return null;
  }

  @Override
  public JMSContext createContext(int i) {
    return null;
  }
}
