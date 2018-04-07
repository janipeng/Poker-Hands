package org.jani;

import static java.util.Arrays.stream;
import static java.util.Comparator.reverseOrder;
import static org.jani.QualityBuilder.byModel;

public enum Rank {
  HIGH_CARD(byModel("1 1 1 1 1")),
  ONE_PAIR(byModel("2 1 1 1")),
  TWO_PAIR(byModel("2 2 1"));

  private Qualifier qualifier;

  Rank(Qualifier qualifier) {
    this.qualifier = qualifier;
  }

  public static Rank getRank(Poker poker) {
    return stream(Rank.values())
        .sorted(reverseOrder())
        .filter(rank -> rank.qualifier.qualify(poker))
        .findFirst()
        .orElse(HIGH_CARD);
  }
  }
