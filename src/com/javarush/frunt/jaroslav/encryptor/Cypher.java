package com.javarush.frunt.jaroslav.encryptor;

public class Cypher {

    private final String ABC_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public Cypher() {
    }

    public String encrypt (String text4Cypher, int key) {
        if (key < 0) key = (key % Constants.ABC_EN.length()) +  Constants.ABC_EN.length();
        StringBuilder outputStringBuilder = new StringBuilder();

        for (int i = 0; i < text4Cypher.length(); i++) {
            char actualChar = text4Cypher.charAt(i);
            int inputIndex = Constants.ABC_EN.indexOf(actualChar);
            if (inputIndex >= 0) {
                int outputIndex = (inputIndex + key) % Constants.ABC_EN.length();
                actualChar = Constants.ABC_EN.charAt(outputIndex);
            }
            outputStringBuilder.append(actualChar);
        }
        return outputStringBuilder.toString();
    }

    public String decrypt (String text4Cypher, int key) {
        return encrypt(text4Cypher, -key);
    }

}
