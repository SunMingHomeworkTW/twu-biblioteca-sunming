package com.twu.biblioteca.controller;

import java.util.Scanner;

public class InputReader {
    private Scanner scanner = new Scanner(System.in);

    public String read() {
        String input = scanner.next();
        return input;
    }
}
