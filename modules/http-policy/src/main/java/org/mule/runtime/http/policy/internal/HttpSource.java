/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

public class HttpSource {

  private HttpSourcePre pre;
  private HttpSourcePost post;

  public HttpSourcePre getPre() {
    return pre;
  }

  public void setPre(HttpSourcePre pre) {
    this.pre = pre;
  }

  public HttpSourcePost getPost() {
    return post;
  }

  public void setPost(HttpSourcePost post) {
    this.post = post;
  }

}
