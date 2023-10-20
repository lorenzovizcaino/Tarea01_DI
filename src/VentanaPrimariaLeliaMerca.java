import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class VentanaPrimariaLeliaMerca extends JFrame {
    File file=new File("image"+File.separator+"logo LeliaMerca.png");
    Image imagen,imagenOriginal;

    public VentanaPrimariaLeliaMerca(){
        setSize(300,600);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("LeliaMerca");
        try {
            imagenOriginal=ImageIO.read(file);
            imagen=imagenOriginal.getScaledInstance(60,30,Image.SCALE_SMOOTH);
            setIconImage(imagen);
        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        LaminaPrimariaLeliaMerca laminaPrimariaLeliaMerca=new LaminaPrimariaLeliaMerca();
        add(laminaPrimariaLeliaMerca);
        setVisible(true);
    }
}
