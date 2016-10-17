package org.mule.extensions.jms.api.config;

import javax.jms.Session;

/**
 * AUTO. Mule acks the message only if the flow is finished successfully.
 * MANUAL. This is JMS client ack mode. The user must do the ack manually within the flow.
 * DUPS_OK. JMS message is ack automatically but in a lazy fashion which may lead to duplicates.
 * NONE. Automatically acks the message upon reception.
 * Can be overridden at the message source level.
 * This attribute must be set not defined or defined as NONE if there?s a transcationType configured other than NONE.
 *
 */
public enum AckMode {

  NONE(0), //TODO Review session.transacted
  AUTO(Session.AUTO_ACKNOWLEDGE),
  MANUAL(Session.CLIENT_ACKNOWLEDGE),
  DUPS_OK(Session.DUPS_OK_ACKNOWLEDGE);

  private final int ackMode;

  AckMode(int ackMode) {
    this.ackMode = ackMode;
  }

  public int getAckMode() {
    return ackMode;
  }

}
