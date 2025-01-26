package com.javarush.frunt.jaroslav.encryptor;

import com.javarush.frunt.jaroslav.constants.Constants;

import java.util.Arrays;

public class Cypher {

    public Cypher() {
    }

    public String encrypt(String text4Cypher, int key) {
        StringBuilder outputStringBuilder = new StringBuilder();

        for (int i = 0; i < text4Cypher.length(); i++) {
            char actualChar = text4Cypher.charAt(i);

            for (String ABC : Constants.ALPHABETS) {
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

    public int bruteForce(String encryptedText) {
        final int KEYS_COUNT = 26;
        int bestKey = 0;
        double bestFreqError = Double.MAX_VALUE;
        for (int key = 0; key < KEYS_COUNT; key++) {
            String decryptedText = decrypt(encryptedText, key);
            double freqError = textFrequencyError(decryptedText);
            if (freqError < bestFreqError) {
                bestFreqError = freqError;
                bestKey = key;
            }
//            System.out.println(" key - " + " " + key + " " + "\t freqError - " + " " + freqError);
        }
        return bestKey;
    }

    private double textFrequencyError(String text) {
        text = text.toUpperCase();
        double bestError = Double.MAX_VALUE;
        for (int alphabet = 0; alphabet < Constants.ALPHABETS.length; alphabet++) {
            double averageError = alphabetAverageError(text, alphabet);
        System.out.println("averageError - " + averageError);
            if (averageError < bestError) bestError = averageError;
        }
        return bestError;
    }

    private static double alphabetAverageError(String text, int alphabet) {
        String ABC = Constants.ALPHABETS[alphabet];
        double letterFreq[] = Constants.letterFreq[alphabet];

        double textLetterFreq[] = new double[letterFreq.length];
        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            int charIndex = ABC.indexOf(charAt);
            if (charIndex >= 0) {
                textLetterFreq[charIndex]++;
            }
        }

        double averageError = 0.0;
        for (int i = 0; i < textLetterFreq.length; i++) {
            double letter = textLetterFreq[i] * 100 / text.length();
            double frequency = letterFreq[i];
            double error = letter / frequency;
            averageError += error;
//            System.out.println(ABC.charAt(i) + " " + (int) textLetterFreq[i] + " " + letter + " " + frequency + " " + error);
        }
        averageError /= textLetterFreq.length;
        if (averageError < 0.1) averageError = Double.MAX_VALUE;
        return averageError;
    }

}
