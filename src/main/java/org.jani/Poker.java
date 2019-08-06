package org.jani;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.Arrays.stream;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static org.jani.Rank.findRank;

public class Poker implements Comparable<Poker>{
  private static final String SPACE = " ";
  private final String name;
  private final List<Card> cards;

  Poker(String name, String input) {
    this.name = name;
    this.cards = stream(input.split(SPACE))
        .map(Card::new)
        .sorted(reverseOrder())
        .collect(toList());
  }

  String battle(Poker poker) {
    return winner(poker);
  }

  private String winner(Poker poker) {
    return this.compareTo(poker) > 0 ? this.name : poker.name;
  }

  @Override
  public int compareTo(Poker poker) {
    int compareResult = findRank(this).compareTo(findRank(poker));
    return isSameRank(compareResult) ? compareHighCard(poker) : compareResult;
  }

  private boolean isSameRank(int compareResult) {
    return compareResult == 0;
  }

  private int compareHighCard(Poker poker) {
    return range(0, 5)
        .map(operand -> cards.get(operand).compareTo(poker.cards.get(operand)))
        .filter(cardCompareResult -> cardCompareResult != 0)
        .findFirst()
        .orElse(0);
  }

  List<Card> getCards() {
    return cards;
  }

  String buildModel() {
    Map<Integer, Integer> counts = new HashMap<>();
    this.cards.forEach(card -> {
      Integer count = counts.get(card.getValue());
      counts.put(card.getValue(), Optional.ofNullable(count).orElse(0) + 1);
    });
    return counts.values().stream().sorted(reverseOrder()).map(String::valueOf).collect(joining(SPACE));
  }

}
