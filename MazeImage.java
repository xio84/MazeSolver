/**Prototype maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517
 */

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Color;

/**
 * Maze
 */
public class MazeImage {
    ///Dimension
    int h = 320;
    int w = 640;

    ///Create buffered image
    BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    ///Objek file
    File f = null;

    ///Koonstanta warna
    final Color white = new Color(255,255,255);
    final Color black = new Color(0,0,0);
    final Color red = new Color(255,20,20);
    final Color green = new Color(20,255,80);
}