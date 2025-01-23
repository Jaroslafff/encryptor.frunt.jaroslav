package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.encryptor.Cypher;
import com.javarush.frunt.jaroslav.encryptor.Mode;

import java.nio.file.Path;

public class Main {

    static Mode mode;
    static Path path;
    static int key;
    static String originText;
    static String encryptedText;
    static String decryptedText;

    static Cypher cypher = new Cypher();

    public static void main(String[] args) {

        argsCheck(args);

        originText = "Test string";
        encryptedText = cypher.encrypt(originText, key);
        decryptedText = cypher.decrypt(encryptedText, key);
        System.out.println(originText + "\n" + encryptedText + "\n" + decryptedText);

        originText = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        encryptedText = cypher.encrypt(originText, key);
        decryptedText = cypher.decrypt(encryptedText, key);
        System.out.println(originText + "\n" + encryptedText + "\n" + decryptedText);

    }

    static void argsCheck(String[] args) {  // TODO: Handle Exceptions
        mode = Mode.valueOf(args[0].toUpperCase());
        path = Path.of(args[1]);
        key = Integer.parseInt(args[2]);
    }

}
