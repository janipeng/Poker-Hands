package org.jani;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Predicate;

public enum Face {
  T(10, "T"),
  JACK(11, "J"),
  QUEEN(12, "Q"),
  KING(13, "K"),
  ACE(14, "A");

  private final int value;
  private final String sybmol;

  Face(int value, String symbol) {
    this.value = value;
    this.sybmol = symbol;
  }

  public static Optional<Face> findFace(String substring) {
    return Arrays.stream(values()).filter(new Predicate<Face>() {
      @Override
      public boolean test(Face face) {
        return substring.equals(face.sybmol);
      }
    }).findFirst();
  }

  public int getValue() {
    return value;
  }
}
