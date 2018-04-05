package org.jani;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

class PokerHands implements Comparable<PokerHands> {

  private int rank;
  private List<Card> cards = new ArrayList<>();
  private String name;
  private int rankValue;

  PokerHands(String name, String input) {
    this.name = name;
    cards = stream(input.split(" "))
        .map(Card::new)
        .sorted((o1, o2) -> o2.getValue() - o1.getValue())
        .collect(toList());
    calculateRank();
  }

  private void calculateRank() {
    for (int index = 0; index < cards.size() - 1; index++) {
      if (cards.get(index).getValue() == cards.get(index + 1).getValue()) {
        this.rank = 1;
        this.rankValue = cards.get(index).getValue();
        return;
      }
    }
  }

  @Override
  public int compareTo(PokerHands poker) {
    if (isDiffRank(poker)) {
      return this.rank - poker.rank;
    } else if (rankValue != poker.rankValue){
      return rankValue - poker.rankValue;
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
