package org.jani;

import java.util.function.IntUnaryOperator;

import static java.util.Optional.ofNullable;
import static java.util.stream.IntStream.range;

class PokerComparer {

  private static final String WINS = " wins.";
  private static final String DRAW = "It is a draw.";

  String compare(Poker pokerA, Poker pokerB) {
    int result = pokerA.getRank().compareTo(pokerB.getRank());
    if (result == 0) {
      result = range(0, 5)
          .map(compareByCard(pokerA, pokerB))
          .filter(compareResult -> compareResult != 0)
          .findFirst()
          .orElse(0);
    }

    return ofNullable(winner(pokerA, pokerB, result))
        .map(name -> name + WINS)
        .orElse(DRAW);
  }

  private String winner(Poker pokerA, Poker pokerB, int result) {
    if (result > 0) {
      return pokerA.getName();
    }
    if (result < 0) {
      return pokerB.getName();
    }
    return null;
  }

  private IntUnaryOperator compareByCard(Poker pokerA, Poker pokerB) {
    return index -> pokerA.getCards().get(index)
        .compareTo(pokerB.getCards().get(index));
  }
}
