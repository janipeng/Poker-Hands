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

  @Test
  public void onePokerHasThreeOfKing_onePokerHasTwoPairs() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 2D 2H AD 3C");
    Poker pokerB = new Poker("Player 2", "5D 5H 2C 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void bothAreThreeOfAKing() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 2D 2H AD 3C");
    Poker pokerB = new Poker("Player 2", "5D 5H 5C 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void onePokerIsConsecutive_onePokerIsThreeOfAKing() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 4D 5H 6D 3C");
    Poker pokerB = new Poker("Player 2", "5D 5H 5C 2C 9H");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void onePokerIsFlush_onePokerIsStraight() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 4D 5H 6D 3C");
    Poker pokerB = new Poker("Player 2", "3D 8D 5D 2D 9D");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void bothAreFlush() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 4H 5H 6H AH");
    Poker pokerB = new Poker("Player 2", "3D 8D 5D 2D 9D");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void onePokerHasThreeSameValueCardsAndOnePair_onePokerIsAFlush() throws Exception {
    Poker pokerA = new Poker("Player 1", "2H 4H 5H 6H AH");
    Poker pokerB = new Poker("Player 2", "2D 8D 8D 2D 2C");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }

  @Test
  public void bothAreFullOfHouse() throws Exception {
    Poker pokerA = new Poker("Player 1", "5H 5H 5H 6D 6H");
    Poker pokerB = new Poker("Player 2", "2D 8D 8D 2D 2C");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 1 wins."));
  }

  @Test
  public void onePokerIsFourOfAKing_onePokerIsFullOfHouse() throws Exception {
    Poker pokerA = new Poker("Player 1", "5H 5H 5H 6D 6H");
    Poker pokerB = new Poker("Player 2", "2D 8D 2D 2D 2C");

    String result = pokerComparer.compare(pokerA, pokerB);

    assertThat(result, is("Player 2 wins."));
  }
}



