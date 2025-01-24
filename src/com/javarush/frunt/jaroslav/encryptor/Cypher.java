package com.javarush.frunt.jaroslav.encryptor;

public class Cypher {

    private final String ABC_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public Cypher() {
    }

    public String encrypt (String text4Cypher, int key) {
        StringBuilder outputStringBuilder = new StringBuilder();
        if (key < 0) {
            key = (key % ABC_EN.length()) +  ABC_EN.length();
        }

        for (int i = 0; i < text4Cypher.length(); i++) {
            char actualChar = text4Cypher.charAt(i);
            int inputIndex = ABC_EN.indexOf(actualChar);
            if (inputIndex >= 0) {
                int outputIndex = (inputIndex + key) % ABC_EN.length();
                actualChar = ABC_EN.charAt(outputIndex);
            }
            outputStringBuilder.append(actualChar);
        }
        return outputStringBuilder.toString();
    }

    public String decrypt (String text4Cypher, int key) {
        return encrypt(text4Cypher, -key);
    }

}
