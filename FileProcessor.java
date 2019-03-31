//package MazeSolver;

/**Prototype FileProcessor
 * T. Antra Oksidian Tafly / 13517020
 * Timothy / 13517044
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileProcessor {

	public static void main(String[] args) {

        File filename = new File(args[0]);

        Scanner scan = null;

        ///Buffers
        String sbuffer = new String();
        String buffers = new String();

        try {
            scan = new Scanner(filename);

            while(scan.hasNextLine()){
                sbuffer=scan.nextLine();
                for (int x=0; x<sbuffer.length(); x++){
                    buffers += sbuffer.charAt(x);
                    buffers += " ";
                }
                buffers += "\n";
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(args[0]);
			bw = new BufferedWriter(fw);
			bw.write(buffers);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

    }
    
    public static void main(String args) {

        File filename = new File(args);

        Scanner scan = null;

        ///Buffers
        String sbuffer = new String();
        String buffers = new String();

        try {
            scan = new Scanner(filename);

            while(scan.hasNextLine()){
                sbuffer=scan.nextLine();
                for (int x=0; x<sbuffer.length(); x++){
                    buffers += sbuffer.charAt(x);
                    buffers += " ";
                }
                buffers += "\n";
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {

			fw = new FileWriter(args);
			bw = new BufferedWriter(fw);
			bw.write(buffers);

			System.out.println("Done");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}

		}

	}

}