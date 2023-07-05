import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.plaf.ColorUIResource;

public class App extends JFrame implements ActionListener {
    private JLabel labelR, labelG, labelB, labelC, labelM, labelY, labelK, labelTitulo001, labelTitulo002;
    private JComboBox boxR, boxG, boxB, boxC, boxM, boxY, boxK;
    private JButton buttonRGB, buttonCMYK, buttonLimpiar, buttonDesarrollador;
    private JPanel panelRGB, panelCMYK;
    private float r, g, b, c, m, y, k, apoyo;
    private int rojo, verde, azul;

    public App() {// constructor
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));

        labelTitulo001 = new JLabel("CONVERSOR");// ----------------------------------------------labels
        labelTitulo001.setFont(new Font("Century Gothic", 0, 16));
        labelTitulo001.setBounds(95, 0, 150, 30);
        add(labelTitulo001);

        labelTitulo002 = new JLabel("De Modelos De Colores");
        labelTitulo002.setBounds(58, 20, 300, 30);
        labelTitulo002.setFont(new Font("Century Gothic", 0, 16));
        add(labelTitulo002);

        labelR = new JLabel("Rojo");// ------------------------------------------------------------
        labelR.setFont(new Font("Century Gothic", 0, 12));
        labelR.setBounds(10, 70, 100, 30);
        add(labelR);

        labelG = new JLabel("Verde");
        labelG.setFont(new Font("Century Gothic", 0, 12));
        labelG.setBounds(10, 100, 100, 30);
        add(labelG);

        labelB = new JLabel("Azul");
        labelB.setFont(new Font("Century Gothic", 0, 12));
        labelB.setBounds(10, 130, 100, 30);
        add(labelB);

        labelC = new JLabel("Cian");
        labelC.setFont(new Font("Century Gothic", 0, 12));
        labelC.setBounds(10, 190, 100, 30);
        add(labelC);

        labelM = new JLabel("Magenta");
        labelM.setFont(new Font("Century Gothic", 0, 12));
        labelM.setBounds(10, 220, 100, 30);
        add(labelM);

        labelY = new JLabel("Amarillo");
        labelY.setFont(new Font("Century Gothic", 0, 12));
        labelY.setBounds(10, 250, 100, 30);
        add(labelY);

        labelK = new JLabel("Negro");
        labelK.setFont(new Font("Century Gothic", 0, 12));
        labelK.setBounds(10, 280, 100, 30);
        add(labelK);

        boxR = new JComboBox();// -------------------------------------------combobox
        for (int e = 0; e <= 255; e++) {
            boxR.addItem(e);
        }
        boxR.setBounds(80, 70, 50, 20);
        boxR.setBackground(new Color(255, 255, 255));
        boxR.setFont(new Font("Century Gothic", 0, 12));
        add(boxR);

        boxG = new JComboBox();
        for (int e = 0; e <= 255; e++) {
            boxG.addItem(e);
        }
        boxG.setBounds(80, 100, 50, 20);
        boxG.setBackground(new Color(255, 255, 255));
        boxG.setFont(new Font("Century Gothic", 0, 12));
        add(boxG);

        boxB = new JComboBox();
        for (int e = 0; e <= 255; e++) {
            boxB.addItem(e);
        }
        boxB.setBounds(80, 130, 50, 20);
        boxB.setBackground(new Color(255, 255, 255));
        boxB.setFont(new Font("Century Gothic", 0, 12));
        add(boxB);

        boxC = new JComboBox();
        for (int e = 0; e <= 100; e++) {
            boxC.addItem(e);
        }
        boxC.setBounds(80, 190, 50, 20);
        boxC.setBackground(new Color(255, 255, 255));
        boxC.setFont(new Font("Century Gothic", 0, 12));
        add(boxC);

        boxM = new JComboBox();
        for (int e = 0; e <= 100; e++) {
            boxM.addItem(e);
        }
        boxM.setBounds(80, 220, 50, 20);
        boxM.setBackground(new Color(255, 255, 255));
        boxM.setFont(new Font("Century Gothic", 0, 12));
        add(boxM);

        boxY = new JComboBox();
        for (int e = 0; e <= 100; e++) {
            boxY.addItem(e);
        }
        boxY.setBounds(80, 250, 50, 20);
        boxY.setBackground(new Color(255, 255, 255));
        boxY.setFont(new Font("Century Gothic", 0, 12));
        add(boxY);

        boxK = new JComboBox();
        for (int e = 0; e <= 100; e++) {
            boxK.addItem(e);
        }
        boxK.setBounds(80, 280, 50, 20);
        boxK.setBackground(new Color(255, 255, 255));
        boxK.setFont(new Font("Century Gothic", 0, 12));
        add(boxK);

        buttonRGB = new JButton("RGB a CMYK");// --------------------------------------botones
        buttonRGB.setBounds(170, 70, 120, 20);
        buttonRGB.setBackground(new Color(240, 240, 240));
        buttonRGB.setFont(new Font("Century Gothic", 0, 12));
        buttonRGB.addActionListener(this);
        add(buttonRGB);

        panelRGB = new JPanel();/////////////////////////////////////////////////////////////////////////////
        panelRGB.setBounds(170, 90, 120, 5);
        panelRGB.setBackground(new Color(255, 255, 255));
        add(panelRGB);

        buttonCMYK = new JButton("CMYK a RGB");
        buttonCMYK.setBounds(170, 190, 120, 20);
        buttonCMYK.setBackground(new Color(240, 240, 240));
        buttonCMYK.setFont(new Font("Century Gothic", 0, 12));
        buttonCMYK.addActionListener(this);
        add(buttonCMYK);

        panelCMYK = new JPanel();/////////////////////////////////////////////////////////////////////////////
        panelCMYK.setBounds(170, 210, 120, 5);
        panelCMYK.setBackground(new Color(255, 255, 255));
        add(panelCMYK);

        buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.setBounds(170, 330, 120, 20);
        buttonLimpiar.setBackground(new Color(240, 240, 240));
        buttonLimpiar.setFont(new Font("Century Gothic", 0, 12));
        buttonLimpiar.addActionListener(this);
        add(buttonLimpiar);

        buttonDesarrollador = new JButton("Desarrollador");
        buttonDesarrollador.setBounds(10, 330, 120, 20);
        buttonDesarrollador.setBackground(new Color(240, 240, 240));
        buttonDesarrollador.setFont(new Font("Century Gothic", 0, 12));
        buttonDesarrollador.addActionListener(this);
        add(buttonDesarrollador);
    }// constructor

    public int redondear(float a) {
        int e = 0;
        e = Math.round(a * 100);
        return e;
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRGB) {
            // consigo los colores ingresados
            r = Float.parseFloat(boxR.getSelectedItem().toString());
            g = Float.parseFloat(boxG.getSelectedItem().toString());
            b = Float.parseFloat(boxB.getSelectedItem().toString());

            rojo = (int) r;
            verde = (int) g;
            azul = (int) b;

            apoyo = Math.max(r / 255, Math.max(g / 255, b / 255));

            k = 1 - apoyo;
            c = (1 - (r / 255) - k) / (1 - k);
            m = (1 - (g / 255) - k) / (1 - k);
            y = (1 - (b / 255) - k) / (1 - k);

            boxC.setSelectedIndex(redondear(c));
            boxM.setSelectedIndex(redondear(m));
            boxY.setSelectedIndex(redondear(y));
            boxK.setSelectedIndex(redondear(k));

            buttonCMYK.setEnabled(false);
            panelRGB.setBackground(new Color(rojo, verde, azul));

        } // RGB

        if (e.getSource() == buttonCMYK) {
            c = Float.parseFloat(boxC.getSelectedItem().toString()) / 100;
            m = Float.parseFloat(boxM.getSelectedItem().toString()) / 100;
            y = Float.parseFloat(boxY.getSelectedItem().toString()) / 100;
            k = Float.parseFloat(boxK.getSelectedItem().toString()) / 100;

            r = (c * k + 1 - k - c) * 255;
            g = (m * k + 1 - k - m) * 255;
            b = (y * k + 1 - k - y) * 255;

            rojo = redondear(r) / 100;
            verde = redondear(g) / 100;
            azul = redondear(b) / 100;

            boxR.setSelectedIndex(rojo);
            boxG.setSelectedIndex(verde);
            boxB.setSelectedIndex(azul);

            buttonRGB.setEnabled(false);
            panelCMYK.setBackground(new Color(rojo, verde, azul));

        } // CMYK

        if (e.getSource() == buttonLimpiar) {
            boxR.setSelectedIndex(0);
            boxG.setSelectedIndex(0);
            boxB.setSelectedIndex(0);
            boxC.setSelectedIndex(0);
            boxM.setSelectedIndex(0);
            boxY.setSelectedIndex(0);
            boxK.setSelectedIndex(0);
            buttonRGB.setEnabled(true);
            buttonCMYK.setEnabled(true);
            panelRGB.setBackground(new Color(255, 255, 255));
            panelCMYK.setBackground(new Color(255, 255, 255));
        } // botón limpiar

        if (e.getSource() == buttonDesarrollador) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", new ColorUIResource(255, 255, 255));
            UI.put("Panel.background", new ColorUIResource(255, 255, 255));
            JOptionPane.showMessageDialog(null, "Lucero Emmanuel\n"
                    + "D.R., Diciembre de 2020\n"
                    + "VERSION 1.1", "Dessarrollador", 1);
        }

    }// action event

    public static void main(String ars[]) {
        App conver = new App();
        conver.setVisible(true);
        conver.setBounds(0, 0, 315, 410);
        conver.setLocationRelativeTo(null);
        conver.setResizable(false);
        conver.setTitle("C.O.N.V.E.R.S.O.R.");
    }// método main

}// clase principal
