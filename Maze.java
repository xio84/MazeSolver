/**Prototype maze
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Maze
 */
public class Maze {
    int[][] wall;
    char[][] visited; ///0=not visited, 1=visited, 2=path
    int n,m;
    int xstart;
    int ystart;
    int xend;
    int yend;

    Maze(String file){
        xstart = -1; ystart = -1;

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
            wall = new int[i][j];
            visited = new char[i][j];
            for(int x=0; x<i; x++){
                for (int y=0; y<j; y++){
                    wall[x][y] = Integer.parseInt(buffers.get(x)[y]);
                    visited[x][y] = '0';
                    if (((x==0||x==n-1)^(y==0||y==m)) && wall[x][y]==0){
                        if (xstart==-1 && ystart==-1){
                            xstart = x;
                            ystart = y;
                        }
                        else{
                            xend=x;
                            yend=y;
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
                if (wall[x][y] == 1){
                    System.out.print(wall[x][y] + " ");
                }
                else{
                    System.out.print(visited[x][y] + " ");
                }
            }
            System.out.print("\n");
        }
    }
    
}