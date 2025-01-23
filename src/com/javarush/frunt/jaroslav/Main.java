package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.encryptor.Constants;
import com.javarush.frunt.jaroslav.encryptor.Cypher;

public class Main {

    static Cypher cypher = new Cypher();

    public static void main(String[] args) {

        int key = 1;
        String string0 = "Test string";
        String string1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        String string0e = cypher.encrypt(string0, key);
        String string0d = cypher.decrypt(string0e, key);
        System.out.println(string0 + "\n" + string0e + "\n" + string0d);

        String string1e = cypher.encrypt(string1, key);
        String string1d = cypher.encrypt(string1e, key);
        System.out.println(string1 + "\n" + string1e + "\n" + string1d);

    }

}
