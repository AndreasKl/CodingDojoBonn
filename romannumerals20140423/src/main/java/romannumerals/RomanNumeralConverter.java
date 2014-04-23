package romannumerals;

import java.util.ArrayList;
import java.util.List;

public class RomanNumeralConverter
{
  private static class ArabicToRoman
  {
    private final int worth;
    private final String name;
    private final ArabicToRoman prepend;

    ArabicToRoman(int worth, String name, ArabicToRoman prepend) {
      this.worth = worth;
      this.name = name;
      this.prepend = prepend;
    }

    int getWorth() {
      return worth;
    }

    String getName() {
      return name;
    }

    boolean hasPrepend() {
      return prepend != null;
    }

    ArabicToRoman getPrepend() {
      return prepend;
    }
  }

  private final static List<ArabicToRoman> MAPPINGS = new ArrayList<ArabicToRoman>();
  static {
    ArabicToRoman I = new ArabicToRoman(1, "I", null);
    ArabicToRoman X = new ArabicToRoman(10, "X", I);
    ArabicToRoman C = new ArabicToRoman(100, "C", X);

    MAPPINGS.add(new ArabicToRoman(1000, "M", C));
    MAPPINGS.add(new ArabicToRoman(500, "D", C));
    MAPPINGS.add(C);
    MAPPINGS.add(new ArabicToRoman(50, "L", X));
    MAPPINGS.add(X);
    MAPPINGS.add(new ArabicToRoman(5, "V", I));
    MAPPINGS.add(I);
  }

  public static String convert(int number) {
    int remainder = number;
    StringBuilder sb = new StringBuilder();

    for (ArabicToRoman entry : MAPPINGS) {
      while (canAppend(remainder, entry)) {
        sb.append(entry.getName());
        remainder -= entry.getWorth();
      }

      while (canPrepend(remainder, entry)) {
        sb.append(entry.getPrepend().getName() + entry.getName());
        remainder -= entry.getWorth() - entry.getPrepend().getWorth();
      }
    }
    return sb.toString();
  }

  private static boolean canAppend(int remainder, ArabicToRoman entry) {
    return remainder >= entry.getWorth();
  }

  private static boolean canPrepend(int remainder, ArabicToRoman entry) {
    if (!entry.hasPrepend()) {
      return false;
    }
    return remainder >= entry.getWorth() - entry.getPrepend().getWorth();
  }
}
