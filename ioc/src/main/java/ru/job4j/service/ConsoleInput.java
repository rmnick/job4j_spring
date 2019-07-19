package ru.job4j.service;

import java.util.Scanner;

public class ConsoleInput implements IInput {
    private final Scanner sc = new Scanner(System.in);

    @Override
    public String answer() {
        return sc.nextLine();
    }
}
