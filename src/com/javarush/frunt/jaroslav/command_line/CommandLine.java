package com.javarush.frunt.jaroslav.command_line;

import com.javarush.frunt.jaroslav.enums.CypherMode;
import java.nio.file.Path;

public class CommandLine {

    private CypherMode cypherMode;
    private Path path;
    private int key;

    public CommandLine(String[] args) {
        if (args.length > 0 ) {
            obtainCypherMode (args[0]);
        }
        if (args.length > 1) {
            obtainPath (args[1]);
        }
        if (args.length > 2 && cypherMode == CypherMode.ENCRYPT || cypherMode == CypherMode.DECRYPT) {
            obtainKey (args[2]);
        }
    }

    private void obtainCypherMode(String arg) {
        cypherMode = CypherMode.valueOf(arg);
    }

    private void obtainPath(String arg) {
        path = Path.of(arg);
    }

    private void obtainKey(String arg) {
        key = Integer.parseInt(arg);
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
