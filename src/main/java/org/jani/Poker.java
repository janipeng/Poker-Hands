package org.jani;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.toList;

public class Poker {

  private List<Card> cards;
  private String name;

  public Poker(String name, String input) {
    this.name = name;
    cards = Arrays.stream(input.split(" ")).map(new Function<String, Card>() {
      @Override
      public Card apply(String card) {
        return new Card(card);
      }
    }).sorted(reverseOrder()).collect(toList());
  }

  public List<Card> getCards() {
    return cards;
  }

  public String getName() {
    return name;
  }
}
