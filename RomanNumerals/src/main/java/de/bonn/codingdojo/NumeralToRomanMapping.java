package de.bonn.codingdojo;

class NumeralToRomanMapping {
    private final int numeric;
    private final String roman;
    private final NumeralToRomanMapping allowedToPrepend;

    public NumeralToRomanMapping(final int numeric, final String roman) {
        this(numeric, roman, null);
    }

    public NumeralToRomanMapping(final int numeric, final String roman, final NumeralToRomanMapping allowedToPrepend) {
        this.numeric = numeric;
        this.roman = roman;
        this.allowedToPrepend = allowedToPrepend;
    }

    public Integer getNumeric() {
        return numeric;
    }

    public String getRoman() {
        return roman;
    }

    public NumeralToRomanMapping getAllowedToPrepend() {
        return allowedToPrepend;
    }
}