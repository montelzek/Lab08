package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CPipe extends CCylinder{
    protected int r;

    public CPipe(int mass, int R, int r) {
        super(mass, R);
        this.r = r;
    }

    @Override
    double momentOfInertial() {
        return (double) (Mass * (R * R + r * r)) /2;
    }

    @Override
    void getData(JTable tab) {
        try {
            Mass = parsePositiveInt(tab.getValueAt(0, 1).toString());
            R = parsePositiveInt(tab.getValueAt(1, 1).toString());
            r = parsePositiveInt(tab.getValueAt(2, 1).toString());
        } catch (NumberFormatException e) {
            showErrorMessage("Błąd: Wprowadzone dane nie są liczbami całkowitymi.");
        } catch (IllegalArgumentException e) {
            showErrorMessage("Błąd: Wprowadzone liczby muszą być dodatnie.");
        }
    }

    @Override
    void showData(JTable tab, DefaultTableModel mod) {
        mod.setRowCount(3);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Mass, 0,1);
        tab.setValueAt("Promień zewnętrzny", 1, 0);
        tab.setValueAt(R, 1, 1);
        tab.setValueAt("Promień wewnętrzny", 2, 0);
        tab.setValueAt(r, 2, 1);
    }
}
