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
        if (args.length > 0){
            M = new Maze(args[0]);
            M.print();
        }
    }
}