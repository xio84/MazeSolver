package MazeSolver;

import java.util.Objects;
import java.util.Stack;

/**Prototype Path
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517044
 */

 /**
  * Path
  */
 public class Path implements Comparable<Path> {
    private Stack<Cell> data;
    private int f;///cost

    Path(){
        data = new Stack<Cell>();
        f=0;
    }

    Path(Cell c){
        data = new Stack<Cell>();
        data.push(c);
        f=data.size()+c.h;
    }

    void push(Cell c){
        data.push(c);
        f=data.size()+c.h;
    }

    Cell peek(){
        return data.peek();
    }

    Cell pop(){
        Cell c=data.pop();
        if(data.size()>0){
            f=data.size()+data.peek().h;
        }
        else{
            f=0;
        }
        return c;
    }

    boolean contains(Cell c){
        return data.contains(c);
    }

    int size(){
        return data.size();
    }

    @SuppressWarnings("unchecked")
    Path copy(){
        Path P = new Path();
        P.data = (Stack<Cell>) data.clone();
        P.f=f;
        return P;
    }
     
    int getF(){
        return f;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Path x = (Path) o;
        return Integer.compare(f, x.getF()) == 0 &&
                Objects.equals(data, x.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, f);
    }

    // Compare two employee objects by F
    @Override
    public int compareTo(Path P) {
        if(this.getF() > P.getF()) {
            return 1;
        } else if (this.getF() < P.getF()) {
            return -1;
        } else {
            return 0;
        }
    }
 }