import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Map extends JPanel {
	private String mapIMG = "map1.jpg";
	private Image image;
        
        public Map() {
            //ImageIcon ii = new ImageIcon(this.getClass().getResource(craft));
            //ImageIcon mapImg = ImageIO.read(new File("map1.jpg"));
            image = Toolkit.getDefaultToolkit().createImage(mapIMG);
        }
        public Image getImage() {
            return image;
        }
        
}


