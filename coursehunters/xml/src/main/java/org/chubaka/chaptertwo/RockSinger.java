package org.chubaka.chaptertwo;

public class RockSinger implements ISinger {
    @Override
    public void practice() {

    }

    @Override
    public void drink() {
        System.out.println("drink");
    }

    @Override
    public void sing() {
        System.out.println("rock ballad");
    }

    @Override
    public void dancing() {
        System.out.println("drunk dancing");
    }
}
