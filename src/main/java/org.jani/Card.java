package org.jani;

import static java.lang.Integer.parseInt;
import static org.jani.Face.findFace;

public class Card implements Comparable<Card>{
  private final int value;

  Card(String card) {
    this.value = valueOf(card);
  }

  private int valueOf(String card) {
    final String value = card.substring(0, 1);
    return findFace(value)
        .map(Face::getValue)
        .orElseGet(() -> parseInt(value));
  }

  @Override
  public int compareTo(Card card) {
    return value - card.value;
  }

  public int getValue() {
    return value;
  }
}
