package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class CSphere extends CSolid{

    protected int R;

    public CSphere(int Mass, int R) {
        this.Mass = Mass;
        this.R = R;
    }

    @Override
    double momentOfInertial() {
        return 0.4 * Mass * R * R;
    }



    @Override
    void getData(JTable tab) {
        try {
            Mass = parsePositiveInt(tab.getValueAt(0, 1).toString());
            R = parsePositiveInt(tab.getValueAt(1, 1).toString());
        } catch (NumberFormatException e) {
            showErrorMessage("Błąd: Wprowadzone dane nie są liczbami całkowitymi.");
        } catch (IllegalArgumentException e) {
            showErrorMessage("Błąd: Wprowadzone liczby muszą być dodatnie.");
        }
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
        mod.setRowCount(2);
        tab.setValueAt("Masa", 0, 0);
        tab.setValueAt(Mass, 0, 1);
        tab.setValueAt("Promień", 1, 0);
        tab.setValueAt(R, 1, 1);
    }
}
