package romannumerals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanNumeralConverterTest {
  private int toConvert;
  private String converted;

  public RomanNumeralConverterTest(int toConvert, String converted) {
    this.toConvert = toConvert;
    this.converted = converted;
  }

  @Parameters(name = "{index}: convert {0} => {1}")
  public static Iterable<Object[]> provideTestData() {
    List<Object[]> testData = new ArrayList<Object[]>();
    testData.add(new Object[] { 1, "I" });
    testData.add(new Object[] { 2, "II" });
    testData.add(new Object[] { 3, "III" });
    testData.add(new Object[] { 4, "IV" });
    testData.add(new Object[] { 5, "V" });
    testData.add(new Object[] { 6, "VI" });
    testData.add(new Object[] { 7, "VII" });
    testData.add(new Object[] { 8, "VIII" });
    testData.add(new Object[] { 9, "IX" });
    testData.add(new Object[] { 10, "X" });
    testData.add(new Object[] { 11, "XI" });
    testData.add(new Object[] { 12, "XII" });
    testData.add(new Object[] { 2016, "MMXVI" });
    return testData;
  }

  @Test
  public void convertArabicNumberAndExpectRomanNumber() {
    Assert.assertEquals(converted, RomanNumeralConverter.convert(toConvert));
  }
}
