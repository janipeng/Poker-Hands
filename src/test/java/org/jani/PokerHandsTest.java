package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerHandsTest {

  @Test
  public void highCardAndAllValuesLessThan10() throws Exception {
    PokerHands pokerHands1 = new PokerHands("2H 3D 5S 4C 6D");
    PokerHands pokerHands2 = new PokerHands("2C 3H 4S 8C 5H");

    String result = pokerHands1.vs(pokerHands2);

    assertThat(result, is("2C 3H 4S 8C 5H wins"));
  }
}
