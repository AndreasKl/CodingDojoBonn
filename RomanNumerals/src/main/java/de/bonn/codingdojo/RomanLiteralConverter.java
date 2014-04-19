package de.bonn.codingdojo;

import java.util.ArrayList;
import java.util.List;

public class RomanLiteralConverter {

    private static final List<NumeralToRomanMapping> MAPPINGS;
    static {
        NumeralToRomanMapping I = new NumeralToRomanMapping(1, "I");
        NumeralToRomanMapping V = new NumeralToRomanMapping(5, "V", I);
        NumeralToRomanMapping X = new NumeralToRomanMapping(10, "X", I);
        NumeralToRomanMapping L = new NumeralToRomanMapping(50, "L", X);
        NumeralToRomanMapping C = new NumeralToRomanMapping(100, "C", X);
        NumeralToRomanMapping D = new NumeralToRomanMapping(500, "D", C);
        NumeralToRomanMapping M = new NumeralToRomanMapping(1000, "M", C);
        
        List<NumeralToRomanMapping> mappings = new ArrayList<NumeralToRomanMapping>(7);
        mappings.add(M);
        mappings.add(D);
        mappings.add(C);
        mappings.add(L);
        mappings.add(X);
        mappings.add(V);
        mappings.add(I);
        MAPPINGS = mappings;
    }

    public static String convert(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException("The allowed interval of 1 - 3999 is exceeded.");
        }
        return convertCore(number);
    }

    private static String convertCore(int number) {
        StringBuilder sb = new StringBuilder();
        int remainder = number;
        while (remainder != 0) {
            for (NumeralToRomanMapping mapping : MAPPINGS) {
                if (mapping.canAppend(remainder)) {
                    sb.append(mapping.getRoman());
                    remainder -= mapping.getNumeric();
                    break;
                }

                if (mapping.canPrepend(remainder)) {
                    NumeralToRomanMapping prepend = mapping.getToPrepend();
                    sb.append(prepend.getRoman() + mapping.getRoman());
                    remainder += prepend.getNumeric() - mapping.getNumeric();
                    break;
                }
            }
        }
        return sb.toString();
    }

}
