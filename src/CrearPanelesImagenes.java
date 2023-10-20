import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearPanelesImagenes extends JPanel {

    JLabel [] imagenes1 =new JLabel[4];
    JLabel [] imagenes2 =new JLabel[4];
    JLabel [] nombres1 =new JLabel[4];
    private Font font17 =new Font("Lucida Sans",Font.BOLD,17);
    private Font font14 =new Font("Lucida Sans",Font.BOLD,14);
    private Font font12 =new Font("Lucida Sans",Font.BOLD,12);

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


    public JPanel CrearNombresProductos(String[] arrayNombreProductos) {
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

    public JPanel CrearPrecioProductos(String[] arrayPrecios) {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< nombres1.length; i++){
            nombres1[i]=new JLabel(arrayPrecios[i]);
            nombres1[i].setHorizontalAlignment(JLabel.LEFT);
            nombres1[i].setFont(font17);
            panel.add(nombres1[i]);
        }
        return panel;
    }
}




