package org.jani;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

class PokerHands implements Comparable<PokerHands> {

  private List<Card> cards = new ArrayList<>();
  private String name;

  PokerHands(String name, String input) {
    this.name = name;
    cards = stream(input.split(" "))
        .map(Card::new)
        .sorted()
        .collect(toList());
  }

  @Override
  public int compareTo(PokerHands o) {
    return IntStream.range(0, 5)
        .map(index -> cards.get(index).compareTo(o.cards.get(index)))
        .filter(integer -> integer != 0)
        .findFirst().orElse(0);
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
