/**Prototype MazeSolver (Main Program)
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517044
 */

import java.util.Scanner;

/**
 * MazeSolver
 */
public class MazeSolver {
    
    public static void main(String[] args) {
		System.out.println("|---------------------------------------------------------------------------------------------|");
		System.out.println("| __   __  _______  _______  _______    _______  _______  ___      __   __  _______  ______   |");
		System.out.println("||  |_|  ||   _   ||       ||       |  |       ||       ||   |    |  | |  ||       ||    _ |  |");
		System.out.println("||       ||  |_|  ||____   ||    ___|  |  _____||   _   ||   |    |  |_|  ||    ___||   | ||  |");
		System.out.println("||       ||       | ____|  ||   |___   | |_____ |  | |  ||   |    |       ||   |___ |   |_||_ |");
		System.out.println("||       ||       || ______||    ___|  |_____  ||  |_|  ||   |___ |       ||    ___||    __  ||");
		System.out.println("|| ||_|| ||   _   || |_____ |   |___    _____| ||       ||       | |     | |   |___ |   |  | ||");
		System.out.println("||_|   |_||__| |__||_______||_______|  |_______||_______||_______|  |___|  |_______||___|  |_||");
		System.out.println("|----------BY: T.Antra Oksidian Tafly 13517020 & Ignatius Timothy Manullang 13517044----------|");
		System.out.println("|---------------------------------------------------------------------------------------------|\n");
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
            I = new MazeImage(M);
            I.writeImage("BFS");
            M.clear();
            M.ASTAR();
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
            I = new MazeImage(M);
            I.writeImage("BFS");
            M.clear();
            M.ASTAR();
            I = new MazeImage(M);
            I.writeImage("A-STAR");
        }
    }
}
