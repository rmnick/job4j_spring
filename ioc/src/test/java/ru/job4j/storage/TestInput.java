package ru.job4j.storage;

import ru.job4j.service.IInput;

import java.util.List;

public class TestInput implements IInput {
    private List<String> answers;
    private int position = 0;

    public TestInput(List<String> answers) {
        this.answers = answers;
    }

    @Override
    public String answer() {
        return answers.get(position++);
    }
}
