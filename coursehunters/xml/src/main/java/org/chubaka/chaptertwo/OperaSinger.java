package org.chubaka.chaptertwo;

public class OperaSinger implements ISinger {
    @Override
    public void practice() {
        System.out.println("practice");
    }

    @Override
    public void drink() {

    }

    @Override
    public void sing() {
        System.out.println("sing opera");
    }

    @Override
    public void dancing() {

    }
}
