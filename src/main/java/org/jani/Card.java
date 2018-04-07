package org.jani;

import java.util.Optional;

import static java.lang.Integer.valueOf;
import static java.util.Arrays.stream;

public class Card implements Comparable<Card>{
  private int value;

  Card(String card) {
    this.value = calValue(card.split("")[0]);
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
