package com.javarush.frunt.jaroslav.encryptor;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    public static final String ABC_EN = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final ArrayList<Character> CHAR_LIST_EN = new ArrayList<>(
            Arrays.asList(
                    'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
                    'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
                    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
//                    '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '
            )
    );

    public static final ArrayList<Character> CHAR_LIST_UA = new ArrayList<>(
            Arrays.asList(
                    'а', 'б', 'в', 'г', 'д', 'е'
            )
    );

}
