package de.bonn.codingdojo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class RomanLiteralConverterParameterizedTest {

    private int number;
    private String expected;

    @Parameters(name= "convert {0} => {1}")
    public static Collection<Object[]> expectedConversion() throws Exception {
        List<Object[]> testData = new ArrayList<Object[]>(3999);
        BufferedReader testCases = new BufferedReader(new InputStreamReader(
                ClassLoader.getSystemResourceAsStream("roman.literals"), "UTF-8"));
        String readLine = null;
        while ((readLine = testCases.readLine()) != null) {
            String[] split = readLine.split("\\|");
            testData.add(new Object[] { Integer.parseInt(split[0].trim()), split[1].trim() });
        }
        return testData;
    }

    public RomanLiteralConverterParameterizedTest(int number, String expected){
        this.number = number;
        this.expected = expected;
    }
   
    @Test
    public void convertNumberAndExpectRomanLiteral() {
        Assert.assertEquals(expected, RomanLiteralConverter.convert(number));
    }

}
