package org.mule.extensions.jms.api.connection;

/**
 * //TODO
 */
public enum JmsSpecification {
  JMS_1_0_2b("1.0.2b"),
  JMS_1_1("1.1"),
  JMS_2_0("2.0");

  private final String name;

  private JmsSpecification(String s) {
    name = s;
  }

  @Override
  public String toString(){
    return name;
  }
}
