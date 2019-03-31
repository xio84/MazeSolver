//package MazeSolver;

/**Prototype maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517
 */

import java.util.Scanner;

/**
 * MazeSolver
 */
public class MazeSolver {
    
    public static void main(String[] args) {
        Maze M;
        MazeImage I;
        if (args.length > 0){
            args[0] = args[0];
            System.out.println("Process file? [Y]es/[N]o");
            Scanner s = new Scanner(System.in);
            if (s.nextLine().startsWith("Y")){
                FileProcessor.main(args);
            }
            s.close();
            M = new Maze(args[0]);
            M.addDirections();
            M.BFS();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage("BFS");
            M.clear();
            M.ASTAR();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage("A-STAR");
        }
        else{
            System.out.println("Masukkan nama file:");
            Scanner s = new Scanner(System.in);
            String buffer = s.nextLine();
            System.out.println("Process file? [Y]es/[N]o");
            Scanner sx = new Scanner(System.in);
            if (sx.nextLine().startsWith("Y")){
                FileProcessor.main(buffer);
            }
            sx.close();
            M = new Maze(buffer);
            s.close();
            M.addDirections();
            M.BFS();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage("BFS");
            M.clear();
            M.ASTAR();
            //System.out.println(M.data[1][5].Branch.size());
            M.print();
            I = new MazeImage(M);
            I.writeImage("A-STAR");
        }
    }
}