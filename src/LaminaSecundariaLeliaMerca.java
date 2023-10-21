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
    private File carritoNaranja=new File("image"+File.separator+"carritoNaranjaRedimensionado.png");

    private GBCConstrains gbc=new GBCConstrains();
    private CrearPanelesImagenes crearPanelesImagenes=new CrearPanelesImagenes();

    private JPanel panelProductos1,panelProductos2;
    private JPanel nombreProductos1,nombreProductos2;
    private JPanel desProductos1, desProductos2;
    private JPanel preciosProductos1, preciosProductos2;
    private JPanel comprar1, comprar2,totalCompra;
    private JPanel botonesFinales;

    private TextArea areaCompras=new TextArea(20,5);


    private LogoLeliaMerca logo ;







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
    private String[] arrayNombreProductos1={"Cinco Jotas","Joselito","Casa Oms","Negrini"};
    private String[] arrayNombreProductos2={"Beronia","Elika","Moët & Chandon","Perrier Jouet"};
    private String[] arrayDescripcionProductos1={"<html>Maletín hexagonal con jamón de<br>bellota 100% ibérico.</html>",
                                                 "<html>Selección de embutidos,<br>lomo, chorizo y Salchichón Joselito.</html>",
                                                 "<html>Fuet Casa Oms.</html>",
                                                 "<html>Salchichón con trufa Negrini.</html>"};
    private String[] arrayDescripcionProductos2={"<html>Estuche vino tinto Beronia Gran<br>Reserva 1978 Rioja.</html>",
            "<html>Estuche vinos tintos y blanco<br> monovarietales ecológicos.</html>",
            "<html>Champagne Moët & Chandon Ice<br>Impèrial Mágnum.</html>",
            "<html>Champagne Blanc de Blancs<br>Perrier Jouet.</html>"};

    private String[] arrayPrecios1={"699.00","129.00","4.45","9.95"};
    private String[] arrayPrecios2={"179.00","199.00","175.00","92.50"};





    public LaminaSecundariaLeliaMerca(int id){

       setLayout(new GridBagLayout());
       //setBackground(Color.WHITE);
       panelProductos1=new JPanel();
       panelProductos1.setLayout(new GridLayout(1,4));
       panelProductos1=crearPanelesImagenes.CrearImagenes1(arrayImagenes1,arrayImagenesTexto1);


       nombreProductos1=new JPanel();
       nombreProductos1.setLayout(new GridLayout(1,4));
       nombreProductos1=crearPanelesImagenes.CrearNombresProductos(arrayNombreProductos1);

        desProductos1=new JPanel();
        desProductos1.setLayout(new GridLayout(1,4));
        desProductos1=crearPanelesImagenes.CrearDescripcionProductos(arrayDescripcionProductos1);

        preciosProductos1=new JPanel();
        preciosProductos1.setLayout(new GridLayout(1,4));
        preciosProductos1=crearPanelesImagenes.CrearPrecioProductos(arrayPrecios1);

        comprar1=new JPanel();
        comprar1.setLayout(new GridLayout(1,4));
        comprar1=crearPanelesImagenes.CrearCompras1(carritoNaranja,areaCompras);

       panelProductos2=new JPanel();
       panelProductos2.setLayout(new GridLayout(1,4));
       panelProductos2=crearPanelesImagenes.CrearImagenes2(arrayImagenes2,arrayImagenesTexto2);

        nombreProductos2=new JPanel();
        nombreProductos2.setLayout(new GridLayout(1,4));
        nombreProductos2=crearPanelesImagenes.CrearNombresProductos(arrayNombreProductos2);

        desProductos2=new JPanel();
        desProductos2.setLayout(new GridLayout(1,4));
        desProductos2=crearPanelesImagenes.CrearDescripcionProductos(arrayDescripcionProductos2);

        preciosProductos2=new JPanel();
        preciosProductos2.setLayout(new GridLayout(1,4));
        preciosProductos2=crearPanelesImagenes.CrearPrecioProductos(arrayPrecios2);

        comprar2=new JPanel();
        comprar2.setLayout(new GridLayout(1,4));
        comprar2=crearPanelesImagenes.CrearCompras2(carritoNaranja);

        logo=new LogoLeliaMerca(2);



        totalCompra=new JPanel();
        totalCompra.setLayout(new FlowLayout());
        totalCompra=crearPanelesImagenes.total();

        botonesFinales=new JPanel();
        botonesFinales.setLayout(new GridLayout(1,2,45,0));
        botonesFinales=crearPanelesImagenes.botonesFinales();



       add(panelProductos1,gbc.Constrains(0,0,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));
       add(nombreProductos1,gbc.Constrains(0,1,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));
       add(desProductos1,gbc.Constrains(0,2,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));
        add(preciosProductos1,gbc.Constrains(0,3,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,65,5,5)));
        add(comprar1,gbc.Constrains(0,4,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,65,5,5)));


        add(panelProductos2,gbc.Constrains(0,5,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));

        add(nombreProductos2,gbc.Constrains(0,6,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));
        add(desProductos2,gbc.Constrains(0,7,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,65,5,5)));
        add(preciosProductos2,gbc.Constrains(0,8,1,1,1.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,65,5,5)));
        add(comprar2,gbc.Constrains(0,9,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(0,65,5,5)));


        add(logo,gbc.Constrains(1,0,1,1,1.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(65,80,5,5)));
        add(areaCompras,gbc.Constrains(1,1,1,5,0.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(5,45,5,140)));
        add(totalCompra,gbc.Constrains(1,6,1,1,0.0,0.0,GridBagConstraints.HORIZONTAL,GridBagConstraints.CENTER,new Insets(5,40,5,5)));
        add(botonesFinales,gbc.Constrains(1,8,1,2,0.0,0.0,GridBagConstraints.BOTH,GridBagConstraints.CENTER,new Insets(5,40,5,140)));


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
