package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerHandsTest {

  @Test
  public void highCardAndAllValuesLessThan10() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Player 1", "2H 3D 5S 4C 6D");
    PokerHands pokerHands2 = new PokerHands("Player 2", "2C 3H 4S 8C 5H");

    String result = pokerHands1.battle(pokerHands2);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void highCardAndAllValuesLessThan10_sameValues() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Player 1", "2H 3D 5S 4C 6D");
    PokerHands pokerHands2 = new PokerHands("Player 2", "2C 3H 5S 4C 6H");

    String result = pokerHands1.battle(pokerHands2);

    assertThat(result, is("Nobody wins."));
  }

  @Test
  public void onePokerHasAPair() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Player 1", "2H 3D 5S 2C 6D");
    PokerHands pokerHands2 = new PokerHands("Player 2", "2C 3H 5S 4C 8H");

    String result = pokerHands1.battle(pokerHands2);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void eachPokerHasAPair() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Player 1", "2H 3D 5S 5C 6D");
    PokerHands pokerHands2 = new PokerHands("Player 2", "2C 3H 5S 3C 8H");

    String result = pokerHands1.battle(pokerHands2);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void onePokerHasTwoPairs_otherHasAPair() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Player 1", "2H 3D 2S 3C 6D");
    PokerHands pokerHands2 = new PokerHands("Player 2", "2C 3H 5S 8C 8H");

    String result = pokerHands1.battle(pokerHands2);

    assertThat(result, is("Player 1 wins."));
  }
}


