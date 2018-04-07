package org.jani;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Poker {

  private static final String SPACE = " ";
  private Rank rank;
  private List<Card> cards;
  private String name;
  private Map<Integer, Integer> counts = new HashMap<>();

  Poker(String name, String input) {
    this.name = name;
    this.cards = stream(input.split(SPACE))
        .map(buildCard())
        .sorted(reverseOrder())
        .collect(toList());
    this.rank = calculateRank();
  }

  private Function<String, Card> buildCard() {
    return cardStr -> {
      Card card = new Card(cardStr);
      buildCardCounts(card);
      return card;
    };
  }

  private void buildCardCounts(Card card) {
    counts.put(card.getValue(),
        ofNullable(counts.get(card.getValue())).orElse(0) + 1);
  }

  private Rank calculateRank() {
    return Rank.getRank(this);
  }

  List<Card> getCards() {
    return cards;
  }

  String getName() {
    return name;
  }

  String model() {
    return this.counts
        .values()
        .stream()
        .sorted(reverseOrder())
        .map(String::valueOf)
        .collect(joining(SPACE));
  }

  Rank getRank() {
    return rank;
  }
}
