package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerTest {

  @Test
  public void bothAreHighCardAndAllValuesLessThan10() throws Exception {
    Poker player1 = createPoker("Player1", "2C 3H 7D 5H 8S");
    Poker player2 = createPoker("Player2", "2C 6H 9D 5H 8S");

    String winner = player1.battle(player2);

    assertThat(winner, is("Player2"));
  }

  @Test
  public void bothAreHighCard() throws Exception {
    Poker player1 = createPoker("Player1", "2C AH 7D 5H 8S");
    Poker player2 = createPoker("Player2", "2C 6H TD 5H 8S");

    String winner = player1.battle(player2);

    assertThat(winner, is("Player1"));
  }

  @Test
  public void onePair_oneHighCard() throws Exception {
    Poker player1 = createPoker("Player1", "2C AH 7D 5H 8S");
    Poker player2 = createPoker("Player2", "2C 6H TD 2H 8S");

    String winner = player1.battle(player2);

    assertThat(winner, is("Player2"));
  }

  private Poker createPoker(String name, String cards) {
    return new Poker(name, cards);
  }
}
