import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class VentanSecundariaLeliaMerca extends JFrame {
    File file=new File("image"+File.separator+"logo LeliaMerca.png");
    Image imagen,imagenOriginal;

    public VentanSecundariaLeliaMerca(int id){


        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);

        setTitle("LeliaMerca Productos");
        try {
            imagenOriginal= ImageIO.read(file);
            imagen=imagenOriginal.getScaledInstance(60,30,Image.SCALE_SMOOTH);
            setIconImage(imagen);
        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LaminaSecundariaLeliaMerca laminaSecundariaLeliaMerca=new LaminaSecundariaLeliaMerca(id);
        add(laminaSecundariaLeliaMerca);
        setVisible(true);
    }
}
