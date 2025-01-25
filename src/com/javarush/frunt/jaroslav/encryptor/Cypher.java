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

}
