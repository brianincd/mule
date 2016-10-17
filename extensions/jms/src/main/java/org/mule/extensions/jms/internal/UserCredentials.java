/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.internal;

import org.mule.runtime.extension.api.annotation.Parameter;

/**
 * //TODO
 */
public class UserCredentials {

  @Parameter
  private String username;

  @Parameter
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

}
