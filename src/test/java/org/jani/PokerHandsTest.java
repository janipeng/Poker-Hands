package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerHandsTest {

  @Test
  public void highCardAndAllValuesLessThan10() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Play 1", "2H 3D 5S 4C 6D");
    PokerHands pokerHands2 = new PokerHands("Play 2", "2C 3H 4S 8C 5H");

    int result = pokerHands1.compareTo(pokerHands2);

    assertThat(result, is(-1));
  }

  @Test
  public void highCardAndAllValuesLessThan1() throws Exception {
    PokerHands pokerHands1 = new PokerHands("Play 1", "2H 9D 5S 4C 6D");
    PokerHands pokerHands2 = new PokerHands("Play 2", "2C 3H 4S 8C 5H");

    int result = pokerHands1.compareTo(pokerHands2);

    assertThat(result, is(1));
  }


}


