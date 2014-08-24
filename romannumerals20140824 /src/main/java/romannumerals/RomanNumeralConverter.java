package romannumerals;

import java.util.LinkedHashMap;
import java.util.Map;

public class RomanNumeralConverter {
  private static Map<Integer, String> sMappings = new LinkedHashMap<Integer, String>();

  static {
    sMappings.put(1000, "M");
    sMappings.put(900, "CM");
    sMappings.put(500, "D");
    sMappings.put(400, "CD");
    sMappings.put(100, "C");
    sMappings.put(90, "XC");
    sMappings.put(50, "L");
    sMappings.put(40, "XL");
    sMappings.put(10, "X");
    sMappings.put(9, "IX");
    sMappings.put(5, "V");
    sMappings.put(4, "IV");
    sMappings.put(1, "I");
  }

  public static String convert(int number) {
    for (int arab : sMappings.keySet()) {
      int diff = number - arab;
      if (diff >= 0) {
        return sMappings.get(arab) + convert(diff);
      }
    }
    return "";
  }
}
