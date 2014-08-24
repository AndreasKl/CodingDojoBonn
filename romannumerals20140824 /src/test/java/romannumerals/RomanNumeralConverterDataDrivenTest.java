package romannumerals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanNumeralConverterDataDrivenTest {

  private int number;
  private String expected;

  public RomanNumeralConverterDataDrivenTest(int number, String expected) {
    this.number = number;
    this.expected = expected;
  }

  @Test
  public void convertNumberAndExpectRomanNumeral() {
    Assert.assertEquals(expected, RomanNumeralConverter.convert(number));
  }

  @Parameters(name = "convert {0} => {1}")
  public static Collection<Object[]> expectedConversion() throws Exception {
    List<Object[]> testData = new ArrayList<Object[]>(3999);
    BufferedReader testCases = new BufferedReader(new InputStreamReader(
        ClassLoader.getSystemResourceAsStream("roman.literals"), StandardCharsets.UTF_8));
    String readLine = null;
    while ((readLine = testCases.readLine()) != null) {
      String[] split = readLine.split("\\|");
      testData.add(new Object[] { Integer.parseInt(split[0].trim()), split[1].trim() });
    }
    return testData;
  }
  
}