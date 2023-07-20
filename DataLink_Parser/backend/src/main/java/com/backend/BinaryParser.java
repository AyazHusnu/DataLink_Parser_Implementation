package com.backend;

public class BinaryParser {

    public short binaryToUnsignedShort(String binaryData) {
        short decimalValue = 0;
        short power = 0;

        for (int i = binaryData.length() - 1; i >= 0; i--) {
            char bit = binaryData.charAt(i);
            if (bit == '1') {
                decimalValue += Math.pow(2, power);
            }
            power++;
        }

        return decimalValue;
    }

    public short binaryToUnsignedByte(String binaryData) {
        short decimalValue = 0;
        short power = 0;

        for (int i = binaryData.length() - 1; i >= 0; i--) {
            char bit = binaryData.charAt(i);
            if (bit == '1') {
                decimalValue += Math.pow(2, power);
            }
            power++;
        }

        return decimalValue;
    }

    public short binaryToSignedShort(String binaryData) {
        short decimalValue = 0;
        int helperValue = 0;

        if (binaryData.charAt(0) == '1') {
            helperValue = (int) Math.pow(2, binaryData.length() - 1);
        }

        decimalValue = (short) (helperValue + binaryToUnsignedShort(binaryData.substring(1, binaryData.length() + 1)));

        return decimalValue;
    }
}
