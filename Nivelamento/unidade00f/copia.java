package unidade00f;

import  java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class copia {

    public static void main(String[] args) {
        try 
        {
            File origem = new File("exemplo.txt");
            File destino = new File("copia.txt");

            Scanner myReader = new Scanner(origem);

                try
                 {
                    FileWriter escrevedor = new FileWriter(destino);

                    while (myReader.hasNextLine())
                    {
                        String data = myReader.nextLine();
                        escrevedor.write(data + "\n");
                    }

                    escrevedor.close();
                } 
                catch (IOException e) 
                {
                    e.printStackTrace();
                }
                
            
            myReader.close();
        } 
        catch (FileNotFoundException e)
         {
            System.out.println("An error occurred.");
         

        
        }
}
}
