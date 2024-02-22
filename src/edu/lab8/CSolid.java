package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public abstract class CSolid {
    protected int Mass;
    abstract double momentOfInertial();
    abstract void getData(JTable tab);
    abstract void showData(JTable tab, DefaultTableModel mod);
}
