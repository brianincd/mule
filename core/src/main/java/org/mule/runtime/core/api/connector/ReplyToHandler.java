/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.runtime.core.api.connector;

import org.mule.runtime.core.api.Event;
import org.mule.runtime.core.api.MuleException;
import org.mule.runtime.core.api.message.InternalMessage;
import org.mule.runtime.core.exception.MessagingException;

/**
 * <code>ReplyToHandler</code> is used to handle routing where a replyTo endpointUri is set on the message
 * 
 * @deprecated TODO MULE-10739 Move ReplyToHandler to compatibility module.
 */
@Deprecated
public interface ReplyToHandler {

  Event processReplyTo(Event event, InternalMessage returnMessage, Object replyTo) throws MuleException;

}
