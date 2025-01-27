package com.javarush.frunt.jaroslav;

import com.javarush.frunt.jaroslav.command_line.CommandLine;
import com.javarush.frunt.jaroslav.encryptor.Cypher;
import com.javarush.frunt.jaroslav.enums.CypherMode;
import com.javarush.frunt.jaroslav.file_engine.FileEngine;

public class Main {

    static String originText;
    static String processedText;
    static String decryptedString;

    static Cypher cypher = new Cypher();
    static FileEngine fileEngine = new FileEngine();

    public static void main(String[] args) {

        CommandLine commandLine = new CommandLine(args);

        originText = fileEngine.read(commandLine.getPath());
        processedText = switch (commandLine.getCypherMode()) {
            case ENCRYPT -> cypher.encrypt(originText, commandLine.getKey());
            case DECRYPT -> cypher.decrypt(originText, commandLine.getKey());
            case BRUTE_FORCE -> cypher.bruteForce(originText);
        };
        fileEngine.write(commandLine.getCypherMode(), commandLine.getPath(), processedText);
    }
}
