package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.command_line.CommandLine;
import com.javarush.frunt.jaroslav.constants.Constants;
import com.javarush.frunt.jaroslav.encryptor.Cypher;
import com.javarush.frunt.jaroslav.file_engine.FileEngine;

public class Main {

    static String originText;
    static String encryptedString;
    static String decryptedString;

    static Cypher cypher = new Cypher();
    static FileEngine fileEngine = new FileEngine();

    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine(args);

//        originText = fileEngine.read(commandLine.getPath());
//        encryptedText = cypher.encrypt(originText, commandLine.getKey());
//        Path pathEncrypted = fileEngine.write(commandLine.getCypherMode(), commandLine.getPath(), encryptedText);
//
//        originText = "";
//        encryptedText = "";
//        encryptedText = fileEngine.read(pathEncrypted);
//        originText = cypher.decrypt(encryptedText, commandLine.getKey());
//        fileEngine.write(CypherMode.DECRYPT, commandLine.getPath(), originText);

        cypher(Constants.ALPHABETS[0] + Constants.ALPHABETS[1], commandLine.getKey());
        for (int key = -50; key < 50; key++) {
            cypher(originText = Constants.ALPHABETS[0], key);
        }

    }

    static void cypher(String originString, int key) {
        encryptedString = cypher.encrypt(originString, key);
        decryptedString = cypher.decrypt(encryptedString, key);
//        System.out.println("\n" + originString + "\n" + encryptedString + "\n" + decryptedString);
        System.out.println(encryptedString + " " + decryptedString);
    }

}
