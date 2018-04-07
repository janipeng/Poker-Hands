package org.jani;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static org.jani.QualityBuilder.byModel;

public enum Rank {
  HIGH_CARD(byModel("1 1 1 1 1")),
  ONE_PAIR(byModel("2 1 1 1"));

  private Qualifier qualifier;

  Rank(Qualifier qualifier) {
    this.qualifier = qualifier;
  }

  public static Rank getRank(Poker poker) {
    return Arrays.stream(Rank.values()).sorted(Comparator.reverseOrder()).filter(new Predicate<Rank>() {
      @Override
      public boolean test(Rank rank) {
        return rank.qualifier.qualify(poker);
      }
    }).findFirst().orElse(HIGH_CARD);
  }
}
