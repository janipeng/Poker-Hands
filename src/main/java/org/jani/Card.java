package org.jani;

import static java.lang.Integer.parseInt;

class Card implements Comparable<Card> {
  private String value;
  private String suit;

  Card(String card) {
    String[] cardInfos = card.split("");
    this.value = cardInfos[0];
    this.suit = cardInfos[1];
  }

  int getValue() {
    return parseInt(value);
  }

  @Override
  public int compareTo(Card o) {
    return this.getValue() - o.getValue();
  }
}
