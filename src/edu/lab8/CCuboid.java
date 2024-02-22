package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class CCuboid extends CSolid{
    protected int a;
    protected int b;

    public CCuboid(int mass, int a, int b) {
        this.Mass = mass;
        this.a = a;
        this.b = b;
    }

    @Override
    double momentOfInertial() {
        return (double) (Mass * (a * a + b * b)) /12;
    }

    @Override
    void getData(JTable tab) {

        try {
            Mass = parsePositiveInt(tab.getValueAt(0,1).toString());
            a = parsePositiveInt(tab.getValueAt(1,1).toString());
            b = parsePositiveInt(tab.getValueAt(2,1).toString());
        } catch (NumberFormatException e) {
            showErrorMessage("Błąd: Wprowadzone dane nie są liczbami całkowitymi.");
        } catch (IllegalArgumentException e) {
            showErrorMessage("Błąd: Wprowadzone liczby muszą być dodatnie.");
        }
//            Mass = Integer.parseInt(tab.getValueAt(0,1).toString());
//            a = Integer.parseInt(tab.getValueAt(1,1).toString());
//            b = Integer.parseInt(tab.getValueAt(2,1).toString());
    }

    public int parsePositiveInt(String str) throws NumberFormatException, IllegalArgumentException {
        int value = Integer.parseInt(str);
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }


    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Błąd", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    void showData(JTable tab, DefaultTableModel mod) {
        mod.setRowCount(3);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Mass, 0,1);
        tab.setValueAt("Długość", 1, 0);
        tab.setValueAt(a, 1, 1);
        tab.setValueAt("Szerokość", 2, 0);
        tab.setValueAt(b, 2, 1);
    }
}
