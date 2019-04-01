/**Prototype Maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517044
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.lang.Math;

/**
 * Maze
 */
public class Maze {
    Cell data[][];
    int n,m;
    Cell start;
    Cell end;

    Maze(String file){
        start = new Cell();

        File filename = new File(file);

        Scanner scan = null;

        ///Size
        int i,j;

        ///Buffers
        String[] sbuffer;
        ArrayList<String[]> buffers = new ArrayList<String[]>();

        try {
            scan = new Scanner(filename);

            i=0;
            sbuffer=scan.nextLine().split(" ");
            buffers.add(sbuffer);
            j = sbuffer.length;
            m=j;
            i++;
            
            while(scan.hasNextLine()){
                sbuffer=scan.nextLine().split(" ");
                buffers.add(sbuffer);
                i++;
            }
            n=i;

            ///Print to maze variable
            data = new Cell[i][j];
            for(int x=0; x<i; x++){
                for (int y=0; y<j; y++){
                    data[x][y] = new Cell(Integer.parseInt(buffers.get(x)[y]),x,y);
                    if (((x==0||x==n-1)^(y==0||y==m-1)) && data[x][y].wall==0){
                        if (start.wall == -1){
                            start = data[x][y];
                        }
                        else{
                            end = data[x][y];
                        }
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void print(){
        for(int x=0; x<n; x++){
            for (int y=0; y<m; y++){
                if (data[x][y].wall == 1){
                    System.out.print(data[x][y].wall + " ");
                }
                else{
                    System.out.print(data[x][y].visited + " ");
                }
            }
            System.out.print("\n");
        }
    }

    void clear(){
        for(int x=0; x<n; x++){
            for (int y=0; y<m; y++){
                data[x][y].visited = '0';
            }
        }
    }

    void addDirections(){
        for(int x=0; x<n; x++){
            for (int y=0; y<m; y++){
                if (data[x][y].wall == 1){
                }
                else{
                    if (x>0){
                        if (data[x-1][y].wall==0){
                            data[x][y].AddB(data[x-1][y]);
                        }
                    }
                    if (x<n-1){
                        if (data[x+1][y].wall==0){
                            data[x][y].AddB(data[x+1][y]);
                        }
                    }
                    if (y>0){
                        if (data[x][y-1].wall==0){
                            data[x][y].AddB(data[x][y-1]);
                        }
                    }
                    if (y<m-1){
                        if (data[x][y+1].wall==0){
                            data[x][y].AddB(data[x][y+1]);
                        }
                    }
                }
                data[x][y].h=Math.abs(end.pos.x-x)+Math.abs(end.pos.y-y);
            }
        }
    }
    
    @SuppressWarnings("unchecked")
    void BFS(){
        Cell pos = start;
        pos.visited = 'S';
        Queue<Stack<Cell>> Q = new LinkedList<Stack<Cell>>();
        Stack<Cell> Buffer = new Stack<Cell>();
        Stack<Cell> Buffer2 = new Stack<Cell>();
        Buffer.push(pos);
        Q.offer(Buffer);
        while (Q.size()>0 && !Buffer.contains(end)){
            Buffer = Q.poll();
            pos = Buffer.peek();
            if (!pos.equals(end)){
                for(Cell c : pos.Branch){
                    if (!Buffer.contains(c)){
                        c.visited = 'x';
                        Buffer.push(c);
                        Buffer2 = (Stack<Cell>) Buffer.clone();
                        Q.offer(Buffer2);
                        Buffer.pop();
                    }
                }
            }
            else{
                System.out.println("Found!");
                Q.offer(Buffer);
            }
        }
        if (Buffer.contains(end)){ ///ketemu end
            while(Buffer.size()>0){
                pos = Buffer.pop();
                pos.visited = 'v';
            }
        }
        else{
            System.out.println("Not Found!");
        }
    }

    void ASTAR(){
        Cell pos = start;
        pos.visited = 'S';
        PriorityQueue<Path> Q = new PriorityQueue<>();
        Path Buffer = new Path();
        Path Buffer2 = new Path();
        System.out.println("Heuristic is Manhattan length (x+y)");
        Buffer.push(pos);
        Q.offer(Buffer);
        while (Q.size()>0 && !Buffer.contains(end)){
            Buffer = Q.poll();
            pos = Buffer.peek();
            if (!pos.equals(end)){
                for(Cell c : pos.Branch){
                    if (!Buffer.contains(c)){
                        c.visited = 'x';
                        Buffer.push(c);
                        Buffer2 = Buffer.copy();
                        Q.offer(Buffer2);
                        Buffer.pop();
                    }
                }
            }
            else{
                System.out.println("Found!");
                Q.offer(Buffer);
            }
        }
        if (Buffer.contains(end)){ ///ketemu end
            System.out.println("Cost of A-Star : " + Buffer.getF());
            while(Buffer.size()>0){
                pos = Buffer.pop();
                pos.visited = 'v';
            }
        }
        else{
            System.out.println("Not Found!");
        }
    }
}
