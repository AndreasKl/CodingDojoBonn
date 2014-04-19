package de.bonn.codingdojo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RomanLiteralConverter {

    private static final List<NumeralToRomanMapping> MAPPINGS;
    static {
        List<NumeralToRomanMapping> mappings = new ArrayList<NumeralToRomanMapping>();

        NumeralToRomanMapping I = new NumeralToRomanMapping(1, "I");
        NumeralToRomanMapping V = new NumeralToRomanMapping(5, "V", I);
        NumeralToRomanMapping X = new NumeralToRomanMapping(10, "X", I);
        NumeralToRomanMapping L = new NumeralToRomanMapping(50, "L", X);
        NumeralToRomanMapping C = new NumeralToRomanMapping(100, "C", X);
        NumeralToRomanMapping D = new NumeralToRomanMapping(500, "D", C);
        NumeralToRomanMapping M = new NumeralToRomanMapping(1000, "M", C);

        mappings.add(M);
        mappings.add(D);
        mappings.add(C);
        mappings.add(L);
        mappings.add(X);
        mappings.add(V);
        mappings.add(I);

        MAPPINGS = Collections.unmodifiableList(mappings);
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
        while (true) {
            for (NumeralToRomanMapping mapping : MAPPINGS) {
                if (isAppend(remainder, mapping)) {
                    remainder -= mapping.getNumeric();
                    sb.append(mapping.getRoman());
                    break;
                }

                if (isPrepend(remainder, mapping)) {
                    NumeralToRomanMapping prepend = mapping.getAllowedToPrepend();
                    remainder += prepend.getNumeric() - mapping.getNumeric();
                    sb.append(prepend.getRoman() + mapping.getRoman());
                    break;
                }

            }

            if (remainder == 0) {
                return sb.toString();
            }
        }
    }

    private static boolean isAppend(int remainder, NumeralToRomanMapping mapping) {
        return mapping.getNumeric() <= remainder;
    }

    private static boolean isPrepend(int remainder, NumeralToRomanMapping mapping) {
        return mapping.getAllowedToPrepend() != null
                && mapping.getNumeric() - mapping.getAllowedToPrepend().getNumeric() <= remainder;
    }

}
