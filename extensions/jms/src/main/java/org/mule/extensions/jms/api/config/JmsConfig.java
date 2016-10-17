/*
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.extensions.jms.api.config;

import org.mule.runtime.extension.api.annotation.Parameter;
import org.mule.runtime.extension.api.annotation.param.Optional;

/**
 * //TODO
 */
public class JmsConfig {

  /**
   * No redelivery. -1 mean infinite re deliveries accepted.
   * Can be overridden at the message source level.
   */
  @Parameter
  @Optional(defaultValue = "0")
  private int maxRedelivery;

  /**
   * AUTO. Mule acks the message only if the flow is finished successfully.
   * MANUAL. This is JMS client ack mode. The user must do the ack manually within the flow.
   * DUPS_OK. JMS message is ack automatically but in a lazy fashion which may lead to duplicates.
   * NONE. Automatically acks the message upon reception.
   * Can be overridden at the message source level.
   * This attribute must be set not defined or defined as NONE if there?s a transcationType configured other than NONE.
   */
  @Parameter
  @Optional(defaultValue = "AUTO")
  private AckMode ackMode;

  /**
   * If by default, topic subscriptions must be made durable or not.
   Can be overridden at the message source level.
   Requires clientId attribute set.
   */
  @Parameter
  @Optional(defaultValue = "false")
  private boolean durableTopicSubscriber;

  /**
   * If by default, the message must be sent using persistency mode.
   * Can be overridden at the operation level.
   */
  @Parameter
  @Optional(defaultValue = "true")
  private boolean persistentDelivery;

  /**
   *
   * Defines the default message priority to use when sending messages
   */
  @Parameter
  @Optional(defaultValue = "4")
  private int priority;

  /**
   * Defines the default time in millis the message will be
   * in the broker before being discarded.
   * This is use when sending messages with mule
   */
  @Parameter
  @Optional(defaultValue = "0")
  private int timeToLive;

  /**
   * Defines if it should be possible or not to consume messages
   * published by this connector connection.
   */
  @Parameter
  @Optional(defaultValue = "false")
  private boolean noLocal;


  /**
   * Defines the default value to use, when producing messages,
   * for disable message id generation in the broker.
   * Depending on the provider it may or may not have effect
   */
  //TODO producer only?
  @Parameter
  @Optional(defaultValue = "false")
  private boolean disableMessageId;

  /**
   *
   * Defines the default value to use, when producing messages,
   * for disable message timestamp generation in the broker.
   * Depending on the provider it may or may not have effect.
   */
  //TODO producer only?
  @Parameter
  @Optional(defaultValue = "false")
  private boolean disableMessageTimestamp;

  public int getMaxRedelivery() {
    return maxRedelivery;
  }

  public AckMode getAckMode() {
    return ackMode;
  }

  public boolean isDurableTopicSubscriber() {
    return durableTopicSubscriber;
  }

  public boolean isPersistentDelivery() {
    return persistentDelivery;
  }

  public int getPriority() {
    return priority;
  }

  public int getTimeToLive() {
    return timeToLive;
  }

  public boolean isNoLocal() {
    return noLocal;
  }

  public boolean isDisableMessageId() {
    return disableMessageId;
  }

  public boolean isDisableMessageTimestamp() {
    return disableMessageTimestamp;
  }

  // publishAsynchronously JMS 2.0

}
