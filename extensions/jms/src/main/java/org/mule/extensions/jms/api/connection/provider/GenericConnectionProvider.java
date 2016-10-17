/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.api.connection.provider;

import org.mule.extensions.jms.internal.BaseConnectionProvider;
import org.mule.extensions.jms.internal.GenericConnectionParameters;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.ParameterGroup;

import javax.resource.cci.ConnectionFactory;

/**
 * //TODO
 */
@Alias("generic")
public class GenericConnectionProvider extends BaseConnectionProvider {

  @Parameter
  private ConnectionFactory connectionFactory;

  @ParameterGroup
  private GenericConnectionParameters connectionParameters;

  @Override
  public ConnectionFactory getConnectionFactory() {
    return connectionFactory;
  }

}
