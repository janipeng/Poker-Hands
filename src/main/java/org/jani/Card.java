package org.jani;

import java.util.Optional;

import static java.lang.Integer.valueOf;
import static java.util.Arrays.stream;

public class Card implements Comparable<Card>{
  private String suit;
  private int value;

  Card(String card) {
    String[] cardSplit = card.split("");
    this.value = calValue(cardSplit[0]);
    this.suit = cardSplit[1];
  }

  private int calValue(String value) {
    return OfficerCards.findCard(value)
        .map(officerCards -> officerCards.value)
        .orElseGet(() -> valueOf(value));
  }

  @Override
  public int compareTo(Card card) {
    return this.value - card.value;
  }

  int getValue() {
    return value;
  }

  public String getSuit() {
    return suit;
  }

  private enum OfficerCards {
    TEN(10, "T"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K"), ACE(14, "A");

    private String symbol;
    private int value;

    OfficerCards(int value, String symbol) {
      this.value = value;
      this.symbol = symbol;
    }

    public static Optional<OfficerCards> findCard(String value) {
      return stream(OfficerCards.values())
          .filter(officerCard -> officerCard.symbol.equals(value))
          .findFirst();
    }
  }
}
