/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.module.cxf;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

/**
 * This class was generated by Apache CXF 2.5.1 2012-01-18T22:08:37.809-03:00 Generated source version: 2.5.1
 * 
 */
@WebServiceClient(name = "HolderServiceService", wsdlLocation = "echoHolder.wsdl",
    targetNamespace = "http://cxf.module.runtime.mule.org/")
public class HolderServiceService extends Service {

  public final static URL WSDL_LOCATION;

  public final static QName SERVICE = new QName("http://cxf.module.runtime.mule.org/", "HolderServiceService");
  public final static QName HolderServicePort = new QName("http://cxf.module.runtime.mule.org/", "HolderServicePort");
  static {
    URL url = null;
    try {
      url = new URL("echoHolder.wsdl");
    } catch (MalformedURLException e) {
      java.util.logging.Logger.getLogger(HolderServiceService.class.getName())
          .log(java.util.logging.Level.INFO, "Can not initialize the default wsdl from {0}", "echoHolder.wsdl");
    }
    WSDL_LOCATION = url;
  }

  public HolderServiceService(URL wsdlLocation) {
    super(wsdlLocation, SERVICE);
  }

  public HolderServiceService(URL wsdlLocation, QName serviceName) {
    super(wsdlLocation, serviceName);
  }

  public HolderServiceService() {
    super(WSDL_LOCATION, SERVICE);
  }

  /**
   *
   * @return returns HolderService
   */
  @WebEndpoint(name = "HolderServicePort")
  public HolderService getHolderServicePort() {
    return super.getPort(HolderServicePort, HolderService.class);
  }

  /**
   * 
   * @param features A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy. Supported features not in the
   *        <code>features</code> parameter will have their default values.
   * @return returns HolderService
   */
  @WebEndpoint(name = "HolderServicePort")
  public HolderService getHolderServicePort(WebServiceFeature... features) {
    return super.getPort(HolderServicePort, HolderService.class, features);
  }

}
