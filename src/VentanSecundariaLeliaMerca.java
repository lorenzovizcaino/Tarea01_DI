import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/*
* Esta clase se encarga de generar la ventana de la segunda pantalla de la aplicacion, se genera maximizada y no se
* puede redimensionar
 */
public class VentanSecundariaLeliaMerca extends JFrame {
    File file = new File("image" + File.separator + "logo LeliaMerca.png");
    Image imagen, imagenOriginal;
    LaminaPrimariaLeliaMerca laminaPrimariaLeliaMerca;

    public VentanSecundariaLeliaMerca(int id, LaminaPrimariaLeliaMerca laminaPrimariaLeliaMerca) {
        this.laminaPrimariaLeliaMerca = laminaPrimariaLeliaMerca;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setResizable(false);
        setTitle("LeliaMerca Productos");
        try {
            imagenOriginal = ImageIO.read(file);
            imagen = imagenOriginal.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
            setIconImage(imagen);
        } catch (IOException e) {
            System.out.println("Lo siento, la imagen no se ha encontrado");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        LaminaSecundariaLeliaMerca laminaSecundariaLeliaMerca = new LaminaSecundariaLeliaMerca(id);
        laminaSecundariaLeliaMerca.cancelar.addActionListener(e -> {
            int respuesta = JOptionPane.showConfirmDialog(this, "Si pulsa YES saldra y se eliminara su compra, ¿Seguro que quiere SALIR?", "CANCELAR", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                this.laminaPrimariaLeliaMerca.textFieldUsuario.setText("");
                this.laminaPrimariaLeliaMerca.botonAceptar.setEnabled(false);
                this.dispose();
            }
        });
        add(laminaSecundariaLeliaMerca);
        setVisible(true);
    }
}
