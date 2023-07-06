
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.plaf.ColorUIResource;

/**
 * @author Lucero Emmanuel
 */ 

public class App extends JFrame implements ActionListener {// clase principal
    //elementos gráficos
    private JLabel labelR, labelG, labelB, labelC, labelM, labelY, labelK, labelTitulo001, labelTitulo002;
    private JComboBox boxR, boxG, boxB, boxC, boxM, boxY, boxK;
    private JButton buttonRGB, buttonCMYK, buttonLimpiar, buttonDesarrollador;
    private JPanel panelRGB, panelCMYK;
    //apoyo para los elementos gráficos
    private final Color colorGeneral = new Color(255, 255, 255);
    private final Color colorBotones = new Color(240, 240, 240);
    private final Font fuenteTitulo = new Font("Century Gothic", 0, 16);
    private final Font fuenteGeneral = new Font("Century Gothic", 0, 12);
    //elementos para las fórmulas
    private float r, g, b, c, m, y, k, apoyo;
    private int rojo, verde, azul;

    // constructor
    public App() {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(colorGeneral);
        //cambios generales al "programa" 
        UIManager.getLookAndFeelDefaults().put("Panel.background", colorGeneral);
        UIManager.getLookAndFeelDefaults().put("ComboBox.disabledForeground", new Color(75, 75, 75));
        UIManager.getLookAndFeelDefaults().put("ComboBox.background", colorGeneral);
        UIManager.getLookAndFeelDefaults().put("ComboBox.font", fuenteGeneral);
        UIManager.getLookAndFeelDefaults().put("Button.background", colorBotones);
        UIManager.getLookAndFeelDefaults().put("Button.font", fuenteGeneral); 
        UIManager.getLookAndFeelDefaults().put("Label.font", fuenteGeneral); 
        UIManager.getLookAndFeelDefaults().put("OptionPane.background", colorGeneral);
        UIManager.getLookAndFeelDefaults().put("OptionPane.messageFont", fuenteGeneral);  

        labelTitulo001 = new JLabel("CONVERSOR");// ----------------------------------------------labels
        labelTitulo001.setFont(fuenteTitulo);
        labelTitulo001.setBounds(95, 0, 150, 30);
        add(labelTitulo001);

        labelTitulo002 = new JLabel("De Modelos De Colores");
        labelTitulo002.setBounds(58, 20, 300, 30);
        labelTitulo002.setFont(fuenteTitulo);
        add(labelTitulo002);

        labelR = new JLabel("Rojo");// ------------------------------------------------------------
        labelR.setBounds(10, 70, 100, 30);
        add(labelR);

        labelG = new JLabel("Verde");
        labelG.setBounds(10, 100, 100, 30);
        add(labelG);

        labelB = new JLabel("Azul");
        labelB.setBounds(10, 130, 100, 30);
        add(labelB);

        labelC = new JLabel("Cian");
        labelC.setBounds(10, 190, 100, 30);
        add(labelC);

        labelM = new JLabel("Magenta");
        labelM.setBounds(10, 220, 100, 30);
        add(labelM);

        labelY = new JLabel("Amarillo");
        labelY.setBounds(10, 250, 100, 30);
        add(labelY);

        labelK = new JLabel("Negro");
        labelK.setBounds(10, 280, 100, 30);
        add(labelK);

        boxR = rellenarCombo255();// -------------------------------------------combobox
        boxR.setBounds(80, 70, 50, 20);
        add(boxR);

        boxG = rellenarCombo255();
        boxG.setBounds(80, 100, 50, 20);
        add(boxG);

        boxB = rellenarCombo255();
        boxB.setBounds(80, 130, 50, 20);
        add(boxB);

        boxC = rellenarCombo100();
        boxC.setBounds(80, 190, 50, 20);
        add(boxC);

        boxM = rellenarCombo100();
        boxM.setBounds(80, 220, 50, 20);
        add(boxM);

        boxY = rellenarCombo100();
        boxY.setBounds(80, 250, 50, 20);
        add(boxY);

        boxK = rellenarCombo100();
        boxK.setBounds(80, 280, 50, 20);
        add(boxK);

        buttonRGB = new JButton("RGB a CMYK");// --------------------------------------botones
        buttonRGB.setBounds(170, 70, 120, 20);
        buttonRGB.addActionListener(this);
        add(buttonRGB);

        panelRGB = new JPanel();/////////////////////////////////////////////////////////////////////////////
        panelRGB.setBounds(170, 90, 120, 5);
        add(panelRGB);

        buttonCMYK = new JButton("CMYK a RGB");
        buttonCMYK.setBounds(170, 190, 120, 20);
        buttonCMYK.addActionListener(this);
        add(buttonCMYK);

        panelCMYK = new JPanel();/////////////////////////////////////////////////////////////////////////////
        panelCMYK.setBounds(170, 210, 120, 5);
        add(panelCMYK);

        buttonLimpiar = new JButton("Limpiar");
        buttonLimpiar.setBounds(170, 330, 120, 20);
        buttonLimpiar.addActionListener(this);
        add(buttonLimpiar);

        buttonDesarrollador = new JButton("Desarrollador");
        buttonDesarrollador.setBounds(10, 330, 120, 20);
        buttonDesarrollador.addActionListener(this);
        add(buttonDesarrollador);
    }// constructor
    
    //MÉTODOS         MÉTODOS         MÉTODOS         MÉTODOS         MÉTODOS
    //para redondea
    public int redondear(float a) {
        int e = 0;
        e = Math.round(a * 100);
        return e;
    }
    
    //para habilitar botones ++++++++++++++++++++++++++++++++++++++++
    public void habilitarRGB(boolean condicion){
        boxR.setEnabled(condicion);
        boxG.setEnabled(condicion);
        boxB.setEnabled(condicion);
    }
    public void habilitarCMYK(boolean condicion){
        boxC.setEnabled(condicion);
        boxM.setEnabled(condicion);
        boxY.setEnabled(condicion);
        boxK.setEnabled(condicion);
    }

    public JComboBox rellenarCombo255(){
        JComboBox  miCombo = new JComboBox();
        for(int e = 0; e <=255; e++){
            miCombo.addItem(e);
        }
        return miCombo;
    }

    public JComboBox rellenarCombo100(){
        JComboBox  miCombo = new JComboBox();
        for(int e = 0; e <=100; e++){
            miCombo.addItem(e);
        }
        return miCombo;
    }

    //ACCIONES PARA LOS BOTONES ++++++++++++++++++++++++++++++++++++++++    
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
            
            //resultados después de precionar el botón
            buttonCMYK.setEnabled(false);
            habilitarCMYK(false);// deshabilita los otros combos
            panelRGB.setBackground(new Color (rojo, verde, azul));
        } // RGB

        if (e.getSource() == buttonCMYK) {            
            //se consiguen los valores del color ingresado
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

            //resultados después de precionar el botón
            buttonRGB.setEnabled(false);
            habilitarRGB(false);// deshabilita los otros combos
            panelCMYK.setBackground(new Color (rojo, verde, azul)); 
        } // CMYK

        if (e.getSource() == buttonLimpiar) {
            habilitarCMYK(true);
            habilitarRGB(true);
            boxR.setSelectedIndex(0);
            boxG.setSelectedIndex(0);
            boxB.setSelectedIndex(0);
            boxC.setSelectedIndex(0);
            boxM.setSelectedIndex(0);
            boxY.setSelectedIndex(0);
            boxK.setSelectedIndex(0);
            buttonRGB.setEnabled(true);
            buttonCMYK.setEnabled(true);
            panelRGB.setBackground(colorGeneral);
            panelCMYK.setBackground(colorGeneral);
        } // botón limpiar

        if (e.getSource() == buttonDesarrollador) {
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
