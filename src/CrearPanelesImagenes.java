import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class CrearPanelesImagenes extends JPanel {

    private JLabel [] imagenes1 =new JLabel[4];
    private JLabel [] imagenes2 =new JLabel[4];
    private  JLabel [] nombres1 =new JLabel[4];
    private JSpinner [] spiner1;
    private JSpinner [] spiner2;
    private JLabel etiquetaTotalCompra;
    private TextField fieldtotal;
    protected JButton comprar, cancelar;
    private Font font24 =new Font("Lucida Sans",Font.BOLD,24);
    private Font font19 =new Font("Lucida Sans",Font.BOLD,19);
    private Font font17 =new Font("Lucida Sans",Font.BOLD,17);
    private Font font14 =new Font("Lucida Sans",Font.BOLD,14);
    private Font font12 =new Font("Lucida Sans",Font.BOLD,12);
    private String[] arrayPrecios1 =new String[4];
    private String[] arrayPrecios2=new String[4];
    private String[] nombreProductos1=new String[4];
    private String[] nombreProductos2=new String[4];
    private double total=0.0;
    private String  valorFormateadoTotal;





    public JPanel CrearImagenes1(ImageIcon[] arrayImagenes, ImageIcon[] arrayImagenesTexto1) {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< imagenes1.length; i++){
            imagenes1[i]=new JLabel(arrayImagenes[i]);
            imagenes1[i].setHorizontalAlignment(JLabel.LEFT);
            panel.add(imagenes1[i]);
            int finalI = i;
            int finalI1 = i;
            imagenes1[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    imagenes1[finalI1].setIcon(arrayImagenesTexto1[finalI]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    imagenes1[finalI].setIcon(arrayImagenes[finalI]);
                }
            });
        }
        return panel;
    }

    public JPanel CrearImagenes2(ImageIcon[] arrayImagenes, ImageIcon[] arrayImagenesTexto1) {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< imagenes2.length; i++){
            imagenes2[i]=new JLabel(arrayImagenes[i]);
            imagenes2[i].setHorizontalAlignment(JLabel.LEFT);
            panel.add(imagenes2[i]);
            int finalI = i;
            int finalI1 = i;
            imagenes2[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    imagenes2[finalI1].setIcon(arrayImagenesTexto1[finalI]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    imagenes2[finalI].setIcon(arrayImagenes[finalI]);
                }
            });
        }
        return panel;
    }


    public JPanel CrearNombresProductos1(String[] arrayNombreProductos) {
        nombreProductos1=PonerEspacios(arrayNombreProductos);

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayNombreProductos[i]);
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font17);
            panel.add(nombres1[i]);
        }
        return panel;
    }

    private String[] PonerEspacios(String[] arrayNombreProductos) {
        String []array=new String[arrayNombreProductos.length];
        int longitud=25;
        for (int i=0;i<array.length;i++){
            if(arrayNombreProductos[i].length()<longitud){
                int espaciosFaltantes = longitud - arrayNombreProductos[i].length();
                StringBuilder stringBuilder = new StringBuilder(arrayNombreProductos[i]);
                for (int j = 0; j < espaciosFaltantes; j++) {
                    stringBuilder.append(".");
                }
                array[i] = stringBuilder.toString();
                System.out.println(array[i]);

            }
        }
        return array;
    }

    public JPanel CrearNombresProductos2(String[] arrayNombreProductos) {
        nombreProductos2=PonerEspacios(arrayNombreProductos);
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayNombreProductos[i]);
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font17);
            panel.add(nombres1[i]);
        }
        return panel;
    }
    public JPanel CrearDescripcionProductos(String[] arrayDescripcionProductos) {

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayDescripcionProductos[i]);
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font12);
            panel.add(nombres1[i]);
        }
        return panel;
    }

    public JPanel CrearPrecioProductos1(String[] arrayPrecios) {
        arrayPrecios1 =arrayPrecios;
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayPrecios[i]+" €");
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font17);
            panel.add(nombres1[i]);
        }
        return panel;
    }

    public JPanel CrearPrecioProductos2(String[] arrayPrecios) {
        arrayPrecios2 =arrayPrecios;
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayPrecios[i]+" €");
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font17);
            panel.add(nombres1[i]);
        }
        return panel;
    }

    public JPanel CrearCompras1(File carrito, TextArea areaCompras) {
        JPanel panel=new JPanel();

        panel.setLayout(new GridLayout(1,4));

        spiner1=new JSpinner[4];
        JButton [] botonCarrito=new JButton[4];
        ImageIcon carro;
        try {
             carro= new ImageIcon(ImageIO.read(carrito));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<4;i++){
            FlowLayout layout = new FlowLayout();
            layout.setAlignment(FlowLayout.LEFT);
            layout.setHgap(40);
            JPanel panel2=new JPanel();
            panel2.setLayout(layout);

            spiner1[i]=new JSpinner(new SpinnerNumberModel(0,0,9,1));
            spiner1[i].setPreferredSize(new Dimension(50,40));
            spiner1[i].setFont(font17);
            botonCarrito[i]=new JButton(carro);
            panel2.add(spiner1[i]);
            panel2.add(botonCarrito[i]);
            panel.add(panel2);
            int finalI = i;

            botonCarrito[i].addActionListener(e->{
                total=0.0;
                areaCompras.setText("");

                for(int k=0;k<4;k++){
                    if((int)spiner1[k].getValue()>0){
                        DecimalFormat formato = new DecimalFormat("#,##0.00");
                        String valorFormateado = formato.format(Double.parseDouble(arrayPrecios1[k])*(int)spiner1[k].getValue());
                        int anchoTotal = 8;
                        valorFormateado = String.format("%" + anchoTotal + "s", valorFormateado);
                        total+=Double.parseDouble(arrayPrecios1[k])*(int)spiner1[k].getValue();
                        valorFormateadoTotal=formato.format(total);
                        valorFormateadoTotal = String.format("%" + anchoTotal + "s", valorFormateadoTotal);
                        fieldtotal.setText(valorFormateadoTotal+"€");
                        areaCompras.setText(areaCompras.getText()+"\n\t"+spiner1[k].getValue()+" x "+nombreProductos1[k]+valorFormateado+"€");
                    }

                }
                for(int k=0;k<4;k++){
                    if((int)spiner2[k].getValue()>0){
                        DecimalFormat formato = new DecimalFormat("#,##0.00");
                        String valorFormateado = formato.format(Double.parseDouble(arrayPrecios2[k])*(int)spiner2[k].getValue());
                        int anchoTotal = 8;
                        valorFormateado = String.format("%" + anchoTotal + "s", valorFormateado);
                        total+=Double.parseDouble(arrayPrecios2[k])*(int)spiner2[k].getValue();
                        valorFormateadoTotal=formato.format(total);
                        valorFormateadoTotal = String.format("%" + anchoTotal + "s", valorFormateadoTotal);
                        fieldtotal.setText(valorFormateadoTotal+"€");
                        areaCompras.setText(areaCompras.getText()+"\n\t"+spiner2[k].getValue()+" x "+nombreProductos2[k]+valorFormateado+"€");
                    }

                }



            });

        }


        return panel;

    }

    public JPanel CrearCompras2(File carrito, TextArea areaCompras) {
        JPanel panel=new JPanel();

        panel.setLayout(new GridLayout(1,4));

        spiner2=new JSpinner[4];
        JButton [] botonCarrito=new JButton[4];
        ImageIcon carro;
        try {
            carro= new ImageIcon(ImageIO.read(carrito));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for(int i=0;i<4;i++){
            FlowLayout layout = new FlowLayout();
            layout.setAlignment(FlowLayout.LEFT);
            layout.setHgap(40);
            JPanel panel2=new JPanel();
            panel2.setLayout(layout);

            spiner2[i]=new JSpinner(new SpinnerNumberModel(0,0,9,1));
            spiner2[i].setPreferredSize(new Dimension(50,40));
            spiner2[i].setFont(font17);

            botonCarrito[i]=new JButton(carro);
            panel2.add(spiner2[i]);
            panel2.add(botonCarrito[i]);
            panel.add(panel2);
            int finalI = i;

            botonCarrito[i].addActionListener(e->{
                total=0.0;
                areaCompras.setText("");

                for(int k=0;k<4;k++){
                    if((int)spiner1[k].getValue()>0){
                        DecimalFormat formato = new DecimalFormat("#,##0.00");
                        String valorFormateado = formato.format(Double.parseDouble(arrayPrecios1[k])*(int)spiner1[k].getValue());
                        int anchoTotal = 8;
                        valorFormateado = String.format("%" + anchoTotal + "s", valorFormateado);
                        total+=Double.parseDouble(arrayPrecios1[k])*(int)spiner1[k].getValue();
                        valorFormateadoTotal=formato.format(total);
                        valorFormateadoTotal = String.format("%" + anchoTotal + "s", valorFormateadoTotal);
                        fieldtotal.setText(valorFormateadoTotal+"€");
                        areaCompras.setText(areaCompras.getText()+"\n\t"+spiner1[k].getValue()+" x "+nombreProductos1[k]+valorFormateado+"€");
                    }

                }
                for(int k=0;k<4;k++){
                    if((int)spiner2[k].getValue()>0){
                        DecimalFormat formato = new DecimalFormat("#,##0.00");
                        String valorFormateado = formato.format(Double.parseDouble(arrayPrecios2[k])*(int)spiner2[k].getValue());

                        int anchoTotal = 8;
                        valorFormateado = String.format("%" + anchoTotal + "s", valorFormateado);
                        total+=Double.parseDouble(arrayPrecios2[k])*(int)spiner2[k].getValue();
                        valorFormateadoTotal=formato.format(total);
                        valorFormateadoTotal = String.format("%" + anchoTotal + "s", valorFormateadoTotal);
                        fieldtotal.setText(valorFormateadoTotal+"€");
                        areaCompras.setText(areaCompras.getText()+"\n\t"+spiner2[k].getValue()+" x "+nombreProductos2[k]+valorFormateado+"€");
                    }

                }



            });

        }
        return panel;
    }

    public JPanel total() {
        FlowLayout layout = new FlowLayout();
        layout.setAlignment(FlowLayout.CENTER);
       layout.setHgap(40);
        JPanel panel=new JPanel();
        panel.setLayout(layout);

        etiquetaTotalCompra=new JLabel("TOTAL COMPRA");
        etiquetaTotalCompra.setFont(font19);
        fieldtotal=new TextField(10);
        fieldtotal.setPreferredSize(new Dimension(70,40));
        fieldtotal.setFont(font19);
        panel.add(etiquetaTotalCompra);
        panel.add(fieldtotal);
        return panel;

    }

    public JPanel botonesFinales() {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,2,45,0));
        comprar=new JButton("Comprar");
        comprar.setFont(font24);
        comprar.setBackground(new Color(212,175,55));
        comprar.setForeground(Color.WHITE);
        comprar.setBorder(new LineBorder(new Color(73,134,52),2));
        cancelar=new JButton("Cancelar");
        cancelar.setFont(font24);
        cancelar.setBackground(new Color(212,175,55));
        cancelar.setForeground(Color.WHITE);
        cancelar.setBorder(new LineBorder(new Color(73,134,52),2));
        comprar.addActionListener(e->{
            JOptionPane.showMessageDialog(this,"El Valor total de su compra es: "+valorFormateadoTotal+" €","Finalizando Compra",JOptionPane.INFORMATION_MESSAGE);
        });
        panel.add(comprar);
        panel.add(cancelar);
        return panel;

    }
}




