package org.jani;

class Card {
  private String value;
  private String suit;

  Card(String card) {
    String[] cardInfos = card.split("");
    this.value = cardInfos[0];
    this.suit = cardInfos[1];
  }
}
