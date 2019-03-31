/**Prototype maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517
 */

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;


/**
 * Cell
 */
public class Cell {
    int wall;
    char visited;
    Set<Cell> Branch;
    Point pos;
    int h; ///heuristic

    public Cell(){
        wall=-1;
        visited='?';
    }
    
    public Cell(int w, int x, int y){
        wall=w;
        pos = new Point(x,y);
        visited='0';
        Branch = new HashSet<>();
        h=0;
    }

    public void AddB(Cell c){
        Branch.add(c);
    }
}