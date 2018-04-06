package org.jani;

import static java.util.stream.IntStream.range;

public class PokerComparer {
  public String compare(Poker pokerA, Poker pokerB) {
    int result =
        range(0, 5)
            .map(operand -> pokerA.getCards().get(operand)
                .compareTo(pokerB.getCards().get(operand)))
            .filter(value -> value != 0)
            .findFirst()
            .orElse(0);
      
    if (result > 0) {
      return pokerA.getName() + " wins.";
    }
    if (result < 0) {
      return pokerB.getName() + " wins.";
    }
    return "It is a draw.";
  }
}
