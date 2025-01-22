package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.encryptor.Constants;

public class Main {


    public static void main(String[] args) {
//        System.out.println(Constants.CHAR_LIST_EN + " " + Constants.CHAR_LIST_EN.size());

        int key = 1;
        String string0 = "Test string";
        String string1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String string0e = encrypt(string0, key);
        String string0d = encrypt(string0e, -key);
        System.out.println(string0 + "\n" + string0e + "\n" + string0d);

        String string1e = encrypt(string1, key);
        String string1d = encrypt(string1e, -key);
        System.out.println(string1 + "\n" + string1e + "\n" + string1d);

//        printString(string0);
//
//        printChars(32, 128);
//        printChars(1040, 1104);
//        System.out.println((int) 'Ґ'+ " " + (int) 'ґ');
//
//        System.out.println((int) 'А' + " " + (int) 'Я' + " " + (int) 'а'+ " " + (int) 'я');
    }

    public static String encrypt (String inputString, int key) {
        if (key < 0) key = (key % Constants.ABC_EN.length()) +  Constants.ABC_EN.length();
        StringBuilder outputStringBuilder = new StringBuilder();

        for (int i = 0; i < inputString.length(); i++) {
            char actualChar = inputString.charAt(i);
            int inputIndex = Constants.ABC_EN.indexOf(actualChar);
            if (inputIndex >= 0) {
                int outputIndex = (inputIndex + key) % Constants.ABC_EN.length();
                actualChar = Constants.ABC_EN.charAt(outputIndex);
            }
            outputStringBuilder.append(actualChar);
        }
        return outputStringBuilder.toString();
    }

    public static void printChars (int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.print((char) i + "");
        }
        System.out.println();
    }

    public static void printString (String string) {
        for (int i = 0; i < string.length(); i++) {
            System.out.print(string.charAt(i) + " ");
        }
        System.out.println();
    }
}
