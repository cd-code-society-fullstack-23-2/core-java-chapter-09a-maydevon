package com.codedifferently.partA;

public class Challenge {
    public String formatPhoneNumber(int[] digits) {

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
                digits[0], digits[1], digits[2],
                digits[3], digits[4], digits[5],
                digits[6], digits[7], digits[8], digits[9]
        );
    }
}
