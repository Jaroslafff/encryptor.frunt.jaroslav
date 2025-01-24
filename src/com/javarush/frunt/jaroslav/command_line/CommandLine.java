package com.javarush.frunt.jaroslav.command_line;

import com.javarush.frunt.jaroslav.enums.CypherMode;
import java.nio.file.Path;

public class CommandLine {

    private CypherMode cypherMode;
    private Path path;
    private int key;

    public CommandLine(String[] args) {
        cypherMode = CypherMode.valueOf(args[0]);
        path = Path.of(args[1]);
        key = Integer.parseInt(args[2]);
    }

    public CypherMode getCypherMode() {
        return cypherMode;
    }

    public Path getPath() {
        return path;
    }

    public int getKey() {
        return key;
    }
}
