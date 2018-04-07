package org.jani;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerTest {

  private PokerComparer pokerComparer = new PokerComparer();

  @Test
  public void allHighCard_player1Wins() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 3H AD 9C");
    Poker pokerB = new Poker("Player 2", "3D 7H QC 2C 8H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void allHighCard_player2Wins() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 3H JD 9C");
    Poker pokerB = new Poker("Player 2", "3D 7H QC 2C 8H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void allHighCard_draw() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 3H JD 9C");
    Poker pokerB = new Poker("Player 2", "2D 5H JC 3C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("It is a draw."));
  }

  @Test
  public void onePair_oneHighCard() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 3H AD 9C");
    Poker pokerB = new Poker("Player 2", "2D 5H JC 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void twoDiffPokerWithPair() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 5D 2H AD 9C");
    Poker pokerB = new Poker("Player 2", "5D 5H JC 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void oneTwoPairs_oneAPair() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 3D 2H AD 3C");
    Poker pokerB = new Poker("Player 2", "5D 5H JC 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void bothTwoPairs() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 3D 2H AD 3C");
    Poker pokerB = new Poker("Player 2", "5D 5H 2C 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }
}


