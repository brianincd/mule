/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.internal;

import org.mule.extensions.jms.api.connection.JmsConnection;
import org.mule.runtime.api.connection.ConnectionException;
import org.mule.runtime.api.connection.ConnectionProvider;
import org.mule.runtime.api.connection.ConnectionValidationResult;

import javax.resource.cci.ConnectionFactory;

/**
 * //TODO
 */
public abstract class BaseConnectionProvider implements ConnectionProvider<JmsConnection>{

  @Override
  public JmsConnection connect() throws ConnectionException {
    return null;
  }

  @Override
  public void disconnect(JmsConnection connection) {

  }

  @Override
  public ConnectionValidationResult validate(JmsConnection connection) {
    return null;
  }

  public abstract ConnectionFactory getConnectionFactory();
}
