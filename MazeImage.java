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
    int h;
    int w;
    int ph;
    int pw;

    ///Create buffered image
    BufferedImage img;

    ///Objek file
    File f = null;

    ///Koonstanta warna
    final Color white = new Color(255,255,255);
    final Color black = new Color(0,0,0);
    final Color red = new Color(255,20,20);
    final Color green = new Color(20,255,80);

    MazeImage(Maze M){
        int x1,y1;
        w = M.m*10;
        h = M.n*10;
        img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        ph = w/M.m;
        pw = h/M.n;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                x1 = y/pw; y1 = x/ph;
                if (x1 >= M.n) {
                    System.out.println(x1);
                    x1=M.n-1;
                }
                if (y1 >= M.m) {
                    System.out.println(y1);
                    y1=M.m-1;
                }
                if (M.data[x1][y1].wall == 1) {
                    img.setRGB(x, y, black.getRGB());
                } else {
                    if (M.data[x1][y1].visited == '0') {
                        img.setRGB(x, y, white.getRGB());
                    } else {
                        if (M.data[x1][y1].visited == 'x') {
                            img.setRGB(x, y, red.getRGB());
                        } else {
                            img.setRGB(x, y, green.getRGB());
                        }
                    }
                }
            }
        }
    }

    public void writeImage(){
        try {
            f = new File("Output.png");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e){
            System.out.println("error making image");
        }
    }

    public void writeImage(String filename){
        try {
            f = new File(filename + ".png");
            ImageIO.write(img, "png", f);
        }
        catch (IOException e){
            System.out.println("error making image");
        }
    }
}