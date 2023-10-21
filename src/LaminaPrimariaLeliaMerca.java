import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class LaminaPrimariaLeliaMerca extends JPanel {


    private LogoLeliaMerca logo;
    private JLabel labelNombreUsuario,labelMiCuenta, labelIniciaSesion, labelNuestrosServicios1,labelNuestrosServicios2;
    private JTextField textFieldUsuario;
    private JRadioButton radio1, radio2, radio3;
    private ButtonGroup grupoRadio;
    private JButton botonAceptar;

    private GBCConstrains gbc=new GBCConstrains();
    private Font font17 =new Font("Lucida Sans",Font.BOLD,17);
    private Font font14 =new Font("Lucida Sans",Font.BOLD,14);
    private Font font12 =new Font("Lucida Sans",Font.BOLD,12);

    public LaminaPrimariaLeliaMerca(){
        setLayout(new GridBagLayout());
        setBackground(Color.WHITE);
        labelMiCuenta=new JLabel("M   I       C   U   E   N   T   A");
        labelMiCuenta.setFont(font14);
        labelMiCuenta.setHorizontalAlignment(JLabel.CENTER);
        logo=new LogoLeliaMerca(1);

        labelIniciaSesion=new JLabel("Inicia sesión");
        labelIniciaSesion.setFont(font17);
        labelIniciaSesion.setHorizontalAlignment(JLabel.CENTER);

        labelNuestrosServicios1=new JLabel("Inicia sesión para acceder a todos");
        labelNuestrosServicios1.setHorizontalAlignment(JLabel.CENTER);
        labelNuestrosServicios1.setFont(font12);
        labelNuestrosServicios2=new JLabel("nuestros servicios");
        labelNuestrosServicios2.setHorizontalAlignment(JLabel.CENTER);
        labelNuestrosServicios2.setFont(font12);

        labelNombreUsuario=new JLabel("Cuenta de acceso");
        labelNombreUsuario.setFont(font14);
        //etiqueta.setForeground(Color.white);

        textFieldUsuario =new JTextField(10);
        textFieldUsuario.setFont(font14);
        textFieldUsuario.setPreferredSize(new Dimension(200,30));
        textFieldUsuario.setForeground(Color.GRAY);

        radio1=new JRadioButton("CLIENTE ESPORADICO");
        radio1.setSelected(true);
        radio1.setFont(font14);
        radio1.setBackground(Color.WHITE);
       // radio1.setForeground(Color.WHITE);
        radio2=new JRadioButton("CLIENTE CLUB");
        radio2.setFont(font14);
        radio2.setBackground(Color.WHITE);
       // radio2.setForeground(Color.WHITE);
        radio3=new JRadioButton("CLIENTE PREMIUM");
        radio3.setFont(font14);
        radio3.setBackground(Color.WHITE);
        //radio3.setForeground(Color.WHITE);
        grupoRadio=new ButtonGroup();
        grupoRadio.add(radio1);
        grupoRadio.add(radio2);
        grupoRadio.add(radio3);
        botonAceptar=new JButton("ACEPTAR");
        botonAceptar.setBackground(new Color(212,175,55));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setFont(font17);

        botonAceptar.setBorderPainted(false);
        add(labelMiCuenta,gbc.Constrains(0,0,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,0,25)));

        add(logo,gbc.Constrains(0,1,1,1,0.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(0,25,120,25)));
        add(labelIniciaSesion,gbc.Constrains(0,2,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));
        add(labelNuestrosServicios1,gbc.Constrains(0,3,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,0,25)));
        add(labelNuestrosServicios2,gbc.Constrains(0,4,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,25,10,25)));

        add(labelNombreUsuario,gbc.Constrains(0,5,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));
        add(textFieldUsuario,gbc.Constrains(0,6,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,25,0,25)));
        add(radio1,gbc.Constrains(0,7,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));
        add(radio2,gbc.Constrains(0,8,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));
        add(radio3,gbc.Constrains(0,9,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));
        add(botonAceptar,gbc.Constrains(0,10,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(10,25,10,25)));


        botonAceptar.addActionListener(e->{
            if(radio1.isSelected()) new VentanSecundariaLeliaMerca(1);
            if(radio2.isSelected()) new VentanSecundariaLeliaMerca(2);
            if(radio3.isSelected()) new VentanSecundariaLeliaMerca(3);
        });


    }

}

class LogoLeliaMerca extends JPanel {
    private Image imagen, imagenOriginal;
    private int id=0;
    File file=new File("image"+File.separator+"logo LeliaMerca.png");

    public LogoLeliaMerca(int id) {
        this.id=id;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.WHITE);

        try {
            imagenOriginal= ImageIO.read(file);
            if(id==1){
                setSize(240,95);
                imagen=imagenOriginal.getScaledInstance(220,75,Image.SCALE_SMOOTH);
            }
            if(id==2){
                setSize(360,165);
                setBackground(new Color(238,238,238));
                imagen=imagenOriginal.getScaledInstance(350,119,Image.SCALE_SMOOTH);
            }

        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        g.drawImage(imagen,10,10,null);

    }
}