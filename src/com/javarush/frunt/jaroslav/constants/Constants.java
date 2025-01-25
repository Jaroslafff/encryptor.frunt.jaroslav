package com.javarush.frunt.jaroslav.constants;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    public static final String[] ALPHABETS = {"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz",
            "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯабвгґдеєжзиіїйклмнопрстуфхцчшщьюя"};
    public static final double[][] letterFreq = {{8.2, 1.5, 2.8, 4.3, 12.7, 2.2, 2.0, 6.1, 7.0, 0.15, 0.77, 4.0, 2.4, 6.7, 7.5, 1.9, 0.095, 6.0, 6.3, 9.1, 2.8, 0.98, 2.4, 0.15, 2.0, 0.074},
            {6.4, 1.3, 4.6, 1.3, 0.01, 2.7, 4.2, 0.5, 0.7, 2.0, 5.5, 4.4, 1.0, 0.9, 3.3, 2.7, 2.9, 6.8, 8.6, 2.5, 4.3, 3.7, 4.5, 2.7, 0.3, 1.1, 1.0, 1.1, 0.5, 0.4, 1.6, 0.8, 1.9}};


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
