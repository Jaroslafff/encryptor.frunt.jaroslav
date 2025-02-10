package com.javarush.frunt.jaroslav.file_engine;

import com.javarush.frunt.jaroslav.enums.CypherMode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileEngine {

    private final String ENCRYPTED = "[ENCRYPTED]";
    private final String DECRYPTED = "[DECRYPTED]";

    public FileEngine() {
    }

    public String read(Path path) {
        String text = "";
        try {
            text = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text;
    }

    public Path write(CypherMode mode, Path path, String text) {
        path = alterPath(mode, path);
        try {
            return Files.writeString(path, text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Path alterPath(CypherMode mode, Path path) {
        String pathString = path.toString();
        int index = pathString.lastIndexOf('.');
        String fileName = pathString.substring(0, index);
        String fileExt = pathString.substring(index, pathString.length());

        pathString = switch (mode) {
            case ENCRYPT -> fileName + ENCRYPTED + fileExt;
            case DECRYPT -> fileName + DECRYPTED + fileExt;
            case BRUTE_FORCE -> fileName + DECRYPTED + fileExt;
        };
        return Path.of(pathString);
    }
}
