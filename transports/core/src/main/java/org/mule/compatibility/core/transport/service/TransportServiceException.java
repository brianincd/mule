/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.compatibility.core.transport.service;

import org.mule.runtime.core.config.i18n.I18nMessage;

/**
 * <code>TransportServiceException</code> is thrown if a ProviderServicedescriptor has a service error set. This is usually
 * because the endpoint/connector cannot be created from a service descriptor
 * 
 */

public class TransportServiceException extends TransportFactoryException {

  /**
   * Serial version
   */
  private static final long serialVersionUID = 5377271625492627661L;

  /**
   * @param message the exception message
   */
  public TransportServiceException(I18nMessage message) {
    super(message);
  }

  /**
   * @param message the exception message
   * @param cause the exception that cause this exception to be thrown
   */
  public TransportServiceException(I18nMessage message, Throwable cause) {
    super(message, cause);
  }
}
