package org.jani;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;

public enum Rank {
  HIGH_CARD(Qualifiers.highCard()),
  PAIR(Qualifiers.onePair("2 1 1 1"));

  private Qualifier qualifier;

  Rank(Qualifier qualifier) {
    this.qualifier = qualifier;
  }

  public static Rank findRank(Poker poker) {
    return stream(values())
        .sorted(reverseOrder())
        .filter(rank -> rank.qualifier.qualified(poker))
        .findFirst()
        .orElse(HIGH_CARD);
  }
}
