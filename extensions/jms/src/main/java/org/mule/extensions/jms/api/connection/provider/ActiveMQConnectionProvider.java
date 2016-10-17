/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.api.connection.provider;

import org.mule.extensions.jms.api.connection.JmsSpecification;
import org.mule.extensions.jms.internal.BaseConnectionProvider;
import org.mule.extensions.jms.internal.GenericConnectionParameters;
import org.mule.extensions.jms.internal.activemq.AMQConnectionFactoryProvider;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.Optional;

import javax.resource.cci.ConnectionFactory;

/**
 * //TODO
 */
@Alias("active-mq")
public class ActiveMQConnectionProvider extends BaseConnectionProvider {

  @ParameterGroup
  private GenericConnectionParameters connectionParameters;

  @ParameterGroup
  private AMQConnectionFactoryProvider connectionFactoryProvider;

  @Parameter
  @Optional(defaultValue = "false")
  private boolean enableXA;

  @Override
  public ConnectionFactory getConnectionFactory() {
    return connectionFactoryProvider.getConnectionFactory();
  }

  public boolean isEnableXA() {
    return enableXA;
  }

  public String getClientId() {
    return connectionParameters.getClientId();
  }

  public JmsSpecification getSpecification() {
    return connectionParameters.getSpecification();
  }

  public int getCachedSessions() {
    return connectionParameters.getCachedSessions();
  }

  public String getUsername() {
    return connectionParameters.getUserCredentials()
      .map(creds -> creds.getUsername())
      .orElse("");
  }

  public String getPassword() {
    return connectionParameters.getUserCredentials()
      .map(creds -> creds.getPassword())
      .orElse("");
  }

  public String getBrokerUrl(){
    return connectionFactoryProvider.getBrokerUrl();
  }

}
