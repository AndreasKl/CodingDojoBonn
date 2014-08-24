package romannumerals;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumeralConverterTest {

  @Test
  public void convertArabicNumberAndExpectRomanNumber() {
    Assert.assertEquals("I", RomanNumeralConverter.convert(1));
    Assert.assertEquals("II", RomanNumeralConverter.convert(2));
    Assert.assertEquals("III", RomanNumeralConverter.convert(3));
    Assert.assertEquals("IV", RomanNumeralConverter.convert(4));
    Assert.assertEquals("V", RomanNumeralConverter.convert(5));
    Assert.assertEquals("VI", RomanNumeralConverter.convert(6));
    Assert.assertEquals("VII", RomanNumeralConverter.convert(7));
    Assert.assertEquals("VIII", RomanNumeralConverter.convert(8));
    Assert.assertEquals("IX", RomanNumeralConverter.convert(9));
    Assert.assertEquals("X", RomanNumeralConverter.convert(10));
    Assert.assertEquals("XI", RomanNumeralConverter.convert(11));
    Assert.assertEquals("XII", RomanNumeralConverter.convert(12));
    Assert.assertEquals("MMXVI", RomanNumeralConverter.convert(2016));
  }
}
