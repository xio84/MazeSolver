
/**Prototype maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * MazeSolver
 */
public class MazeSolver {
    
    public static void main(String[] args) {
        Maze M;
        MazeImage I;
        if (args.length > 0){
            M = new Maze(args[0]);
            M.addDirections();
            M.BFS();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage();
        }
        else{
            System.out.println("Masukkan nama file:");
            Scanner s = new Scanner(System.in);
            M = new Maze(s.nextLine());
        }
    }
}