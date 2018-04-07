package org.jani;

import static java.util.Arrays.stream;

class QualityBuilder {
  static Qualifier byModel(String model) {
    return poker -> poker.model().equals(model);
  }

  static Qualifier consecutive() {
    return qualifierGroup(
        byModel("1 1 1 1 1"),
        poker -> poker.differenceValue() == poker.getCards().size() - 1);
  }

  private static Qualifier qualifierGroup(Qualifier... qualifierList) {
    return poker ->
        stream(qualifierList)
            .allMatch(qualifier -> qualifier.qualify(poker));
  }
}
