package com.telran;

import java.util.Optional;

public class MainOptional {

    public static void main(String[] args) {

        String name = readFromFile();

        System.out.println(name.isEmpty() ? "empty" : name);

        Optional.empty();

        // Java -> compilation -> (byte code) JVM
        // Scala ->  (byte code)

        // Option -> Some("abc")
        //        -> None
    }

    static String readFromFile() {
        return "JoHN";
    }

}

