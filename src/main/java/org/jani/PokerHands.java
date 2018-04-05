package org.jani;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

class PokerHands implements Comparable<PokerHands> {

  private int rank;
  private List<Card> cards = new ArrayList<>();
  private String name;

  PokerHands(String name, String input) {
    this.name = name;
    cards = stream(input.split(" "))
        .map(Card::new)
        .sorted()
        .collect(toList());
    this.rank = calculateRank();
  }

  private int calculateRank() {
    for (int index = 0; index < cards.size() - 1; index++) {
      if (cards.get(index).getValue() == cards.get(index + 1).getValue()) {
        return 1;
      }
    }
    return 0;
  }

  @Override
  public int compareTo(PokerHands poker) {
    if (isDiffRank(poker)) {
      return this.rank - poker.rank;
    }
    return range(0, 5)
        .map(index -> cards.get(index).compareTo(poker.cards.get(index)))
        .filter(integer -> integer != 0)
        .findFirst().orElse(0);
  }

  private boolean isDiffRank(PokerHands poker) {
    return this.rank != poker.rank;
  }

  public String battle(PokerHands poker) {
    return ofNullable(winner(poker))
        .orElse("Nobody")
        .concat(" wins.");
  }

  private String winner(PokerHands poker) {
    int compareResult = this.compareTo(poker);
    if (compareResult > 0) {
      return this.name;
    }
    if (compareResult < 0) {
      return poker.name;
    }
    return null;
  }
}
