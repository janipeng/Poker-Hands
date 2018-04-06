package org.jani;

import java.util.List;

import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

class Poker {

  private List<Card> cards;
  private String name;

  Poker(String name, String input) {
    this.name = name;
    this.cards = stream(input.split(" "))
        .map(Card::new)
        .sorted(reverseOrder())
        .collect(toList());
  }

  List<Card> getCards() {
    return cards;
  }

  String getName() {
    return name;
  }
}
