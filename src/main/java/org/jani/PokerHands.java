package org.jani;

import java.util.ArrayList;
import java.util.List;

class PokerHands {

  private final List<Card> cards = new ArrayList<>();

  PokerHands(String input) {
    for (String card : input.split(" ")) {
      this.cards.add(new Card(card));
    }
  }

  String vs(PokerHands pokerHands) {
    return "";
  }
}
