package de.bonn.codingdojo;

class NumeralToRomanMapping {
    
    private final int numeric;
    private final String roman;
    private final NumeralToRomanMapping toPrepend;
    private final int allowedToPrependNumeric;

    public NumeralToRomanMapping(final int numeric, final String roman) {
        this(numeric, roman, null);
    }

    public NumeralToRomanMapping(final int numeric, final String roman, final NumeralToRomanMapping toPrepend) {
        this.numeric = numeric;
        this.roman = roman;
        this.toPrepend = toPrepend;
        if (toPrepend != null) {
            this.allowedToPrependNumeric = numeric - toPrepend.getNumeric();
        } else {
            this.allowedToPrependNumeric = Integer.MAX_VALUE;
        }    
    }

    public Integer getNumeric() {
        return numeric;
    }

    public String getRoman() {
        return roman;
    }

    public NumeralToRomanMapping getToPrepend() {
        return toPrepend;
    }
    
    public boolean canAppend(int remainder) {
        return numeric <= remainder;
    }

    public boolean canPrepend(int remainder) {
        return allowedToPrependNumeric <= remainder;
    }
    
}