import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CrearPanelesImagenes extends JPanel {

    JLabel [] etiquetas1 =new JLabel[4];
    JLabel [] etiquetas2 =new JLabel[4];
    public JPanel Crear1(ImageIcon[] arrayImagenes, ImageIcon[] arrayImagenesTexto1) {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< etiquetas1.length; i++){
            etiquetas1[i]=new JLabel(arrayImagenes[i]);
            panel.add(etiquetas1[i]);
            int finalI = i;
            int finalI1 = i;
            etiquetas1[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    etiquetas1[finalI1].setIcon(arrayImagenesTexto1[finalI]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    etiquetas1[finalI].setIcon(arrayImagenes[finalI]);
                }
            });
        }
        return panel;
    }

    public JPanel Crear2(ImageIcon[] arrayImagenes, ImageIcon[] arrayImagenesTexto1) {
        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1,4));
        for(int i = 0; i< etiquetas2.length; i++){
            etiquetas2[i]=new JLabel(arrayImagenes[i]);
            panel.add(etiquetas2[i]);
            int finalI = i;
            int finalI1 = i;
            etiquetas2[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    etiquetas2[finalI1].setIcon(arrayImagenesTexto1[finalI]);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    etiquetas2[finalI].setIcon(arrayImagenes[finalI]);
                }
            });
        }
        return panel;
    }



}




