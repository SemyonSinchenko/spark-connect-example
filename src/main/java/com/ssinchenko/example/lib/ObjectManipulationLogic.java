package com.ssinchenko.example.lib;


/**
 * This class represents the case when we want to create regular classes and objects on the JVM and
 * manipulate them.
 */
public class ObjectManipulationLogic {
  private String strParameter;
  private Long longParameter;

  public ObjectManipulationLogic(String strParameter, Long longParameter) {
    this.strParameter = strParameter;
    this.longParameter = longParameter;
  }

  public String getStrParameter() {
    return strParameter;
  }

  public void setStrParameter(String strParameter) {
    this.strParameter = strParameter;
  }

  public Long getLongParameter() {
    return longParameter;
  }

  public void setLongParameter(Long longParameter) {
    this.longParameter = longParameter;
  }

  @Override
  public String toString() {
    return "ObjectManipulationLogic{"
        + "strParameter='"
        + strParameter
        + '\''
        + ", longParameter="
        + longParameter
        + '}';
  }
}
