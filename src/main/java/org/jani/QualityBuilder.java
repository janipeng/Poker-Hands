package org.jani;

public class QualityBuilder {
  public static Qualifier byModel(String model) {
    return poker -> poker.model().equals(model);
  }
}
