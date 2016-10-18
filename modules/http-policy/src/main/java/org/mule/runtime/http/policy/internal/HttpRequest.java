/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.http.policy.internal;

public class HttpRequest
{

    private HttpRequestPre pre;
    private HttpRequestPost post;

    public HttpRequestPre getPre()
    {
        return pre;
    }

    public void setPre(HttpRequestPre pre)
    {
        this.pre = pre;
    }

    public HttpRequestPost getPost()
    {
        return post;
    }

    public void setPost(HttpRequestPost post)
    {
        this.post = post;
    }
}
