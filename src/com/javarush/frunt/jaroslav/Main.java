package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.command_line.CommandLine;
import com.javarush.frunt.jaroslav.constants.Constants;
import com.javarush.frunt.jaroslav.encryptor.Cypher;

public class Main {

    static String originText;
    static String encryptedText;
    static String decryptedText;

    static Cypher cypher = new Cypher();

    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine(args);

        originText = "Test string";
        encryptedText = cypher.encrypt(originText, commandLine.getKey());
        decryptedText = cypher.decrypt(encryptedText, commandLine.getKey());
        System.out.println(originText + "\n" + encryptedText + "\n" + decryptedText);

        originText = Constants.ABC_EN;
        encryptedText = cypher.encrypt(originText, commandLine.getKey());
        decryptedText = cypher.decrypt(encryptedText, commandLine.getKey());
        System.out.println(originText + "\n" + encryptedText + "\n" + decryptedText);

    }

}
