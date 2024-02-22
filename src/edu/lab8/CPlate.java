package edu.lab8;

public class CPlate extends CSphere{

    public CPlate(int mass, int R) {
        super(mass, R);
    }

    @Override
    double momentOfInertial() {
        return (double) (Mass * R * R) /2;
    }
}
