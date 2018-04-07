package org.jani;

class QualityBuilder {
  static Qualifier byModel(String model) {
    return poker -> poker.model().equals(model);
  }
}
