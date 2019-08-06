package org.jani;

class Qualifiers {
  static Qualifier highCard() {
    return poker -> true;
  }

  static Qualifier onePair(String model) {
    return poker -> model.equals(poker.buildModel());
  }

}
