import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/*
* Se crea la lamina de la primera pantalla de la aplicacion, la cual esta configurada de tal manera que
* no nos deja pulsar el borton ACEPTAR sino se ha introducido ningun usuario por defecto el tipo de cliente
* elegido es el "Esporadico".

 */
public class LaminaPrimariaLeliaMerca extends JPanel {

    private LogoLeliaMerca logo;
    private JLabel labelNombreUsuario, labelMiCuenta, labelIniciaSesion, labelNuestrosServicios1, labelNuestrosServicios2;
    protected JTextField textFieldUsuario;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup grupoRadio;
    protected JButton botonAceptar;

    private GBCConstrains gbc = new GBCConstrains();
    private Font font17 = new Font("Lucida Sans", Font.BOLD, 17);
    private Font font14 = new Font("Lucida Sans", Font.BOLD, 14);
    private Font font12 = new Font("Lucida Sans", Font.BOLD, 12);
    public LaminaPrimariaLeliaMerca() {
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        labelMiCuenta = new JLabel("M   I       C   U   E   N   T   A");
        labelMiCuenta.setFont(font14);
        labelMiCuenta.setHorizontalAlignment(JLabel.CENTER);
        logo = new LogoLeliaMerca(0);
        labelIniciaSesion = new JLabel("Inicia sesión");
        labelIniciaSesion.setFont(font17);
        labelIniciaSesion.setHorizontalAlignment(JLabel.CENTER);
        labelNuestrosServicios1 = new JLabel("Inicia sesión para acceder a todos");
        labelNuestrosServicios1.setHorizontalAlignment(JLabel.CENTER);
        labelNuestrosServicios1.setFont(font12);
        labelNuestrosServicios2 = new JLabel("nuestros servicios");
        labelNuestrosServicios2.setHorizontalAlignment(JLabel.CENTER);
        labelNuestrosServicios2.setFont(font12);
        labelNombreUsuario = new JLabel("Cuenta de acceso");
        labelNombreUsuario.setFont(font14);
        textFieldUsuario = new JTextField(10);
        textFieldUsuario.setFont(font14);
        textFieldUsuario.setPreferredSize(new Dimension(200, 30));
        textFieldUsuario.setForeground(Color.GRAY);
        radio1 = new JRadioButton("CLIENTE ESPORADICO");
        radio1.setSelected(true);
        radio1.setFont(font14);
        radio1.setBackground(Color.WHITE);
        radio2 = new JRadioButton("CLIENTE CLUB");
        radio2.setFont(font14);
        radio2.setBackground(Color.WHITE);
        radio3 = new JRadioButton("CLIENTE PREMIUM");
        radio3.setFont(font14);
        radio3.setBackground(Color.WHITE);
        grupoRadio = new ButtonGroup();
        grupoRadio.add(radio1);
        grupoRadio.add(radio2);
        grupoRadio.add(radio3);
        botonAceptar = new JButton("ACEPTAR");
        botonAceptar.setEnabled(false);
        botonAceptar.setBackground(new Color(212, 175, 55));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setFont(font17);
        botonAceptar.setBorderPainted(false);
        add(labelMiCuenta, gbc.Constrains(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 0, 25)));

        add(logo, gbc.Constrains(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.BOTH, GridBagConstraints.CENTER, new Insets(0, 25, 120, 25)));
        add(labelIniciaSesion, gbc.Constrains(0, 2, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));
        add(labelNuestrosServicios1, gbc.Constrains(0, 3, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 0, 25)));
        add(labelNuestrosServicios2, gbc.Constrains(0, 4, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 25, 10, 25)));

        add(labelNombreUsuario, gbc.Constrains(0, 5, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));
        add(textFieldUsuario, gbc.Constrains(0, 6, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(0, 25, 0, 25)));
        add(radio1, gbc.Constrains(0, 7, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));
        add(radio2, gbc.Constrains(0, 8, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));
        add(radio3, gbc.Constrains(0, 9, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));
        add(botonAceptar, gbc.Constrains(0, 10, 1, 1, 1.0, 0.0, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, new Insets(10, 25, 10, 25)));


        botonAceptar.addActionListener(e -> {
            if (radio1.isSelected()) new VentanSecundariaLeliaMerca(1, this);
            if (radio2.isSelected()) new VentanSecundariaLeliaMerca(2, this);
            if (radio3.isSelected()) new VentanSecundariaLeliaMerca(3, this);
        });

        textFieldUsuario.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                botonAceptar.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });


    }

}


/*
*La clase LogoLeliaMerca se encarga de cargar los diferentes logos del supermercado que se utilizan durante
* la ejecucion de la aplicacion
 */

class LogoLeliaMerca extends JPanel {
    private Image imagen, imagenOriginal, imagenEsporadico, imagenClub, imagenPremium;
    private int id = 0;
    File file = new File("image" + File.separator + "logo LeliaMerca.png");
    File fileEsporadico = new File("image" + File.separator + "logo LeliaMerca_esporadico.png");
    File fileClub = new File("image" + File.separator + "logo LeliaMerca_club.png");
    File filePremium = new File("image" + File.separator + "logo LeliaMerca_premium.png");

    public LogoLeliaMerca(int id) {
        this.id = id;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        try {
            imagenOriginal = ImageIO.read(file);
            imagenEsporadico = ImageIO.read(fileEsporadico);
            imagenClub = ImageIO.read(fileClub);
            imagenPremium = ImageIO.read(filePremium);
            if (id == 0) {
                setSize(240, 95);
                imagen = imagenOriginal.getScaledInstance(220, 75, Image.SCALE_SMOOTH);
            }
            if (id == 1) {
                setSize(360, 165);
                setBackground(new Color(238, 238, 238));
                imagen = imagenEsporadico.getScaledInstance(350, 119, Image.SCALE_SMOOTH);
            }
            if (id == 2) {
                setSize(360, 165);
                setBackground(new Color(238, 238, 238));
                imagen = imagenClub.getScaledInstance(350, 119, Image.SCALE_SMOOTH);
            }
            if (id == 3) {
                setSize(360, 165);
                setBackground(new Color(238, 238, 238));
                imagen = imagenPremium.getScaledInstance(350, 119, Image.SCALE_SMOOTH);
            }

        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        g.drawImage(imagen, 10, 10, null);

    }
}