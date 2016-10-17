/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.internal;

import org.mule.extensions.jms.api.connection.JmsSpecification;
import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.Optional;

/**
 * //TODO
 */
public class GenericConnectionParameters {

  @ParameterGroup
  @Optional
  private UserCredentials userCredentials;

  @Parameter
  @Optional
  private String clientId;

  @Parameter
  @Optional(defaultValue = "1.1")
  private JmsSpecification specification;

  @Parameter
  @Optional(defaultValue = "0")
  private int cachedSessions;

  public String getClientId() {
    return clientId;
  }

  public JmsSpecification getSpecification() {
    return specification;
  }

  public int getCachedSessions() {
    return cachedSessions;
  }

  public java.util.Optional<UserCredentials> getUserCredentials() {
    return java.util.Optional.ofNullable(userCredentials);
  }
}
