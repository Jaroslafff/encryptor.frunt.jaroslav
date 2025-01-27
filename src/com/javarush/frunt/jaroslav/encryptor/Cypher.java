package com.javarush.frunt.jaroslav.encryptor;

import com.javarush.frunt.jaroslav.constants.Constants;

public class Cypher {

    public Cypher() {
    }

    public String encrypt(String text4Cypher, int key) {
        StringBuilder outputStringBuilder = new StringBuilder();
        for (int i = 0; i < text4Cypher.length(); i++) {
            char actualChar = text4Cypher.charAt(i);
            for (String ABC : Constants.ABCS) {
                int actualCharAbcIndex = ABC.indexOf(actualChar);
                if (actualCharAbcIndex >= 0) {
                    int outputIndex = (actualCharAbcIndex + key) % ABC.length();
                    if (outputIndex < 0) outputIndex += ABC.length();
                    actualChar = ABC.charAt(outputIndex);
                }
            }
            outputStringBuilder.append(actualChar);
        }
        return outputStringBuilder.toString();
    }

    public String decrypt(String text4Cypher, int key) {
        return encrypt(text4Cypher, -key);
    }

    public String bruteForce(String encryptedText) {
        int abcIndex = alphabetRecognize(encryptedText);
        int keysCount = Constants.ABCS[abcIndex].length() / 2;
        int bestKey = 0;
        double bestFreqError = Double.MAX_VALUE;
        for (int key = 0; key < keysCount; key++) {
            String decryptedText = decrypt(encryptedText, key);
            double freqError = textFrequencyError(decryptedText, abcIndex);
            if (freqError < bestFreqError) {
                bestFreqError = freqError;
                bestKey = key;
            }
        }
        return decrypt(encryptedText, bestKey);
    }

    private int alphabetRecognize(String encryptedText) {
        int ukrCharset = 1000;
        int engAbc = 0;
        int ukrAbc = 1;
        int engLetters = 0;
        int ukrLetters = 0;
        for (int i = 0; i < encryptedText.length(); i++) {
            char charAt = encryptedText.charAt(i);
            if (charAt >= 'A' && charAt <= 'z') engLetters++;
            if (charAt > ukrCharset) ukrLetters++;
        }
        if (engLetters > ukrLetters) return engAbc;
        else return ukrAbc;
    }

    private double textFrequencyError(String encryptedText, int abcIndex) {
        encryptedText = encryptedText.toUpperCase();
        String abc = Constants.ABCS[abcIndex];
        double textLettersFreq[] = new double[abc.length() / 2];
        for (int i = 0; i < encryptedText.length(); i++) {
            char charAt = encryptedText.charAt(i);
            int charIndex = abc.indexOf(charAt);
            if (charIndex >= 0) {
                textLettersFreq[charIndex]++;
            }
        }

        double averageError = 0.0;
        double bestError = Double.MAX_VALUE;
        double lettersFrequency[] = Constants.LETTER_FREQUENCY[abcIndex];
        for (int i = 0; i < textLettersFreq.length; i++) {
            double letter = textLettersFreq[i] * 100 / encryptedText.length();
            double frequency = lettersFrequency[i];
            double error = letter / frequency;
            averageError += error;
        }
        averageError /= textLettersFreq.length;
        if (averageError < 0.1) averageError = Double.MAX_VALUE;
        if (averageError < bestError) bestError = averageError;
        return bestError;
    }
}
