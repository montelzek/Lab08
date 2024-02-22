package edu.lab8;

public class CCone extends CSphere{
    public CCone(int mass, int R) {
        super(mass, R);
    }

    @Override
    double momentOfInertial() {
        return (double) (3 * Mass * R * R) /10;
    }
}
