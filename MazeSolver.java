
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
            System.out.println("Process file? [Y]es/[N]o");
            Scanner s = new Scanner(System.in);
            if (s.next().startsWith("Y") || s.next().startsWith("y")){
                FileProcessor.main(args);
            }
            M = new Maze(args[0]);
            M.addDirections();
            M.BFS();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage("BFS");
        }
        else{
            System.out.println("Masukkan nama file:");
            Scanner s = new Scanner(System.in);
            System.out.println("Process file? [Y]es/[N]o");
            Scanner sx = new Scanner(System.in);
            if (sx.next().startsWith("Y") || sx.next().startsWith("y")){
                FileProcessor.main(s.nextLine());
            }
            M = new Maze(s.nextLine());
            M.addDirections();
            M.BFS();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage();
        }
    }
}