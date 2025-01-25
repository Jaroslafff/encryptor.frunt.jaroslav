package com.javarush.frunt.jaroslav.encryptor;

import com.javarush.frunt.jaroslav.constants.Constants;

public class Cypher {

    public Cypher() {
    }

    public String encrypt (String text4Cypher, int key) {
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

    public String decrypt (String text4Cypher, int key) {
        return encrypt(text4Cypher, -key);
    }

    public void bruteForce(String text) {
        text = text.toUpperCase();
        int part = 1;
        String ABC = Constants.ALPHABETS[part];
        double freq[] = Constants.letterFreq[part];

        double lettersCount[] = new double[freq.length];
//        System.out.println(text);
        System.out.println(text.length() + " " + lettersCount.length);
        for (int i = 0; i < text.length(); i++) {
            char charAt = text.charAt(i);
            int charIndex = ABC.indexOf(charAt);
            if (charIndex >= 0) {
                lettersCount[charIndex] += 1;
            }
        }

        double averageError = 0.0;
        for (int i = 0; i < lettersCount.length; i++) {
            double letter = lettersCount[i] * 100 / text.length();
            double frequency = freq[i];
            double error = letter / frequency;
            averageError += error;
            System.out.println(ABC.charAt(i) + " " + (int)lettersCount[i] + " " + letter + " " + frequency + " " + error);
        }
        System.out.println("averageError - " + averageError / text.length());
    }

}
