package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerTest {

  @Test
  public void allHighCard() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 3H AD 9C");
    Poker pokerB = new Poker("Player 2", "3D 7H QC 2C 8H");
    PokerComparer pokerComparer = new PokerComparer();

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }
}
