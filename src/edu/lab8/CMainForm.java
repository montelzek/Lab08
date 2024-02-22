package edu.lab8;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;            // czy ten

public class CMainForm<solids> extends JFrame {
    private JComboBox<String> comboBox1;
    private JButton obliczObjętośćButton;
    private JTable table1;
    private JPanel picturePanel;
    private JLabel resultLabel;
    private JPanel mainPanel;
    private DefaultTableModel model;
    private CSolid[] solids;

    public CMainForm(String title) throws HeadlessException {

        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);

        this.addWindowListener(new WindowAdapter() {

            public void windowOpened(WindowEvent we) {
                frameOpened();
            }
        });

        comboBox1.addActionListener(actionEvent -> comboBoxActionPerformed());
        obliczObjętośćButton.addActionListener(actionEvent -> calculateActionPerformed());

        solids = new CSolid[6];

        solids[0] = new CSphere(1, 2);

        solids[1] = new CPlate(3, 4);

        solids[2] = new CCone(5, 6);

        solids[3] = new CCylinder(2, 3);

        solids[4] = new CPipe(2, 4, 1);

        solids[5] = new CCuboid(4, 1, 2);
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        picturePanel = new CPaintPanel();
    }

    private void frameOpened() {
        String[] n = {"Nazwa", "Wartość"};
        model = new DefaultTableModel(null, n);
        table1.setModel(model);
        table1.putClientProperty("terminateEditOnFocusLost", Boolean.TRUE);
        comboBox1.setSelectedIndex(0);
        calculateActionPerformed();
    }

    private void comboBoxActionPerformed() {
        int idx = comboBox1.getSelectedIndex();
        String s = String.format("/resource/%d.png", idx + 1);
        URL imageURL = CMainForm.class.getResource(s);
        if (imageURL != null) {
            ImageIcon im = new ImageIcon(imageURL);
            ((CPaintPanel) picturePanel).AssignRys(im.getImage());
        }
        picturePanel.repaint();
        solids[idx].showData(table1, model);
        calculateActionPerformed();
    }

    private void calculateActionPerformed() {
        int idx = comboBox1.getSelectedIndex();
        solids[idx].getData(table1);
        resultLabel.setText(String.format("I = %8.3f", solids[idx].momentOfInertial()));

    }

}
