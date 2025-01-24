package com.javarush.frunt.jaroslav.encryptor;

public class Cypher {

    public static final String ABC_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final String ABC_UA = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзиіїйклмнопрстуфхцчшщьюя";

    public Cypher() {
    }

    public String encrypt (String text4Cypher, int key, String abc) {
        StringBuilder outputStringBuilder = new StringBuilder();
        if (key < 0) {
            key = (key % abc.length()) +  abc.length();
        }

        for (int i = 0; i < text4Cypher.length(); i++) {
            char actualChar = text4Cypher.charAt(i);
            int inputIndex = abc.indexOf(actualChar);
            if (inputIndex >= 0) {
                int outputIndex = (inputIndex + key) % abc.length();
                actualChar = abc.charAt(outputIndex);
            }
            outputStringBuilder.append(actualChar);
        }
        return outputStringBuilder.toString();
    }

    public String decrypt (String text4Cypher, int key, String abc) {
        return encrypt(text4Cypher, -key, abc);
    }

}
