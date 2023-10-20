import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class LaminaSecundariaLeliaMerca extends JPanel {
    private File cincoJotas=new File("image"+File.separator+"cincoJotas.png");
    private File cincoJotasTexto=new File("image"+File.separator+"cincoJotasTexto.png");
    private File joselito=new File("image"+File.separator+"Joselito.png");
    private File joselitoTexto=new File("image"+File.separator+"JoselitoTexto.png");
    private File fuetOms=new File("image"+File.separator+"fuetCasaOms.png");
    private File fuetOmsTexto=new File("image"+File.separator+"fuetCasaOmsTexto.png");
    private File negrini=new File("image"+File.separator+"Negrini.png");
    private File negriniTexto=new File("image"+File.separator+"NegriniTexto.png");
    private File beronia=new File("image"+File.separator+"BeroniaGranReserva.png");
    private File beroniaTexto=new File("image"+File.separator+"BeroniaGranReservaTexto.png");
    private File elika=new File("image"+File.separator+"elikaMaletin.png");
    private File elikaTexto=new File("image"+File.separator+"elikaMaletinTexto.png");
    private File moet=new File("image"+File.separator+"MoetIceImperial.png");
    private File moetTexto=new File("image"+File.separator+"MoetIceImperialTexto.png");
    private File perrierJouet=new File("image"+File.separator+"perrierJouet.png");
    private File perrierJouetTexto=new File("image"+File.separator+"perrierJouetTexto.png");

    private GBCConstrains gbc=new GBCConstrains();
    private CrearPanelesImagenes crearPanelesImagenes=new CrearPanelesImagenes();

    JPanel panelProductos1,panelProductos2,panelProductos3;
    JPanel desProductos1, desProductos2, desProductos3;





    private JLabel labelCincoJotas, labelJoselito,labelFuetOms,labelNegrini;
    private JLabel descripcionCincoJotas, descripcionJoselito, descripcionFuetOms, descripcionNegrini;

    private ImageIcon iconCincoJotas=TransformarImagen(cincoJotas);
    private ImageIcon iconCincoJotasTexto=TransformarImagen(cincoJotasTexto);
    private ImageIcon iconJoselito=TransformarImagen(joselito);
    private ImageIcon iconJoselitoTexto=TransformarImagen(joselitoTexto);
    private ImageIcon iconFuetOms=TransformarImagen(fuetOms);
    private ImageIcon iconFuetOmsTexto=TransformarImagen(fuetOmsTexto);
    private ImageIcon iconNegrini=TransformarImagen(negrini);
    private ImageIcon iconNegriniTexto=TransformarImagen(negriniTexto);


    private ImageIcon iconBeronia=TransformarImagen(beronia);
    private ImageIcon iconBeroniaTexto=TransformarImagen(beroniaTexto);
    private ImageIcon iconElika=TransformarImagen(elika);
    private ImageIcon iconElikaTexto=TransformarImagen(elikaTexto);
    private ImageIcon iconMoet=TransformarImagen(moet);
    private ImageIcon iconMoetTexto=TransformarImagen(moetTexto);
    private ImageIcon iconPerrier=TransformarImagen(perrierJouet);
    private ImageIcon iconPerrierTexto=TransformarImagen(perrierJouetTexto);
    private ImageIcon[] arrayImagenes1={iconCincoJotas,iconJoselito,iconFuetOms,iconNegrini};
    private ImageIcon[] arrayImagenes2={iconBeronia,iconElika,iconMoet,iconPerrier};
    private ImageIcon[] arrayImagenesTexto1={iconCincoJotasTexto,iconJoselitoTexto,iconFuetOmsTexto,iconNegriniTexto};
    private ImageIcon[] arrayImagenesTexto2={iconBeroniaTexto,iconElikaTexto,iconMoetTexto,iconPerrierTexto};



    public LaminaSecundariaLeliaMerca(int id){

       setLayout(new GridBagLayout());
       panelProductos1=new JPanel();
       panelProductos1.setLayout(new GridLayout(1,4));
       panelProductos1=crearPanelesImagenes.Crear1(arrayImagenes1,arrayImagenesTexto1);

       panelProductos2=new JPanel();
       panelProductos2.setLayout(new GridLayout(1,4));
       panelProductos2=crearPanelesImagenes.Crear2(arrayImagenes2,arrayImagenesTexto2);

       desProductos1=new JPanel();
       desProductos1.setLayout(new GridLayout(1,4));
       descripcionCincoJotas=new JLabel("Maletín hexagonal con jamón de bellota 100% ibérico Edición Gourmet Cinco Jotas");


       add(panelProductos1,gbc.Constrains(0,0,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,5,5,5)));
       add(panelProductos2,gbc.Constrains(0,1,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,5,5,5)));


    }



    private ImageIcon TransformarImagen(File imagen) {
        Toolkit toolkit=Toolkit.getDefaultToolkit();
        Dimension screenSize=toolkit.getScreenSize();
        double ancho=screenSize.width/7.68;
        double alto=screenSize.height/4.32;
        ImageIcon imageIcon;
        try {
            imageIcon=new ImageIcon(ImageIO.read(imagen).getScaledInstance((int) ancho, (int) alto,Image.SCALE_SMOOTH));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageIcon;
    }


}
