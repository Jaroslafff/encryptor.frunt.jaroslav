package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.command_line.CommandLine;
import com.javarush.frunt.jaroslav.constants.Constants;
import com.javarush.frunt.jaroslav.encryptor.Cypher;
import com.javarush.frunt.jaroslav.enums.CypherMode;
import com.javarush.frunt.jaroslav.file_engine.FileEngine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    static String abc = Cypher.ABC_UA;
    static String originText;
    static String encryptedText;
    static String decryptedText;

    static Cypher cypher = new Cypher();
    static FileEngine fileEngine = new FileEngine();

    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine(args);

        originText = fileEngine.read(commandLine.getPath());
        encryptedText = cypher.encrypt(originText, commandLine.getKey(), abc);
        Path pathEncrypted = fileEngine.write(commandLine.getCypherMode(), commandLine.getPath(), encryptedText);

        originText = "";
        encryptedText = "";
        encryptedText = fileEngine.read(pathEncrypted);
        originText = cypher.decrypt(encryptedText, commandLine.getKey(), abc);
        fileEngine.write(CypherMode.DECRYPT, commandLine.getPath(), originText);

        originText = "Test string";
        encryptedText = cypher.encrypt(originText, commandLine.getKey(), abc);
        decryptedText = cypher.decrypt(encryptedText, commandLine.getKey(), abc);
        System.out.println("\n" + originText + "\n" + encryptedText + "\n" + decryptedText);

        originText = Constants.ABC_EN;
        encryptedText = cypher.encrypt(originText, commandLine.getKey(), abc);
        decryptedText = cypher.decrypt(encryptedText, commandLine.getKey(), abc);
        System.out.println("\n" + originText + "\n" + encryptedText + "\n" + decryptedText);

    }

}
