/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.internal.activemq;

import static org.mule.runtime.core.util.ClassUtils.instanciateClass;
import org.mule.runtime.extension.api.annotation.ExclusiveOptionals;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;

import javax.resource.cci.ConnectionFactory;

/**
 * //TODO
 */
@ExclusiveOptionals
public class AMQConnectionFactoryProvider {

  private static final String ACTIVEMQ_CONNECTION_FACTORY_CLASS = "org.apache.activemq.ActiveMQConnectionFactory";
  private static final String DEFAULT_BROKER_URL = "vm://localhost?broker.persistent=false&broker.useJmx=false";

  @Parameter
  @Optional
  private ConnectionFactory connectionFactory;

  @Parameter
  @Optional(defaultValue = DEFAULT_BROKER_URL) //TODO verify if optional is valid
  private String brokerUrl;


  public ConnectionFactory getConnectionFactory(){

    if (connectionFactory != null) {
      return connectionFactory;
    }

    try {
      this.connectionFactory = (ConnectionFactory) instanciateClass(ACTIVEMQ_CONNECTION_FACTORY_CLASS, brokerUrl);
      return connectionFactory;
    } catch (Exception e) {
      //FIXME handling
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  //TODO forced to have this
  public String getBrokerUrl() {
    return brokerUrl;
  }
}
