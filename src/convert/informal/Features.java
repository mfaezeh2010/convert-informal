

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convert.informal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Vector;

/**
 *
 * @author Faezeh
 */
public class Features {

     static public Vector<Integer> FindFeature(String f,String wrd,int fnumber) throws IOException{
        Vector<Integer>Rate=new Vector<Integer>();  
        for(int i=0;i<3;i++)//#numbers of Rules
        Rate.add(0);
        File fn=new File("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature"+fnumber+".txt");
        //check if we have this feature to update it or we have to create it     
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature"+fnumber+".txt"));
        //need replace file for deleting line
        File fout = new File("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature.txt");
        PrintWriter fileout = new PrintWriter(new FileWriter(fout));
      
    System.out.println("<<<"+f+">>>");
     while(reader1.ready()) {
        String line=reader1.readLine();
            if(f.equals(line)){ //if exits to update feature save path values and delet past records
                //System.out.println("!@#$%^&*()_+!@#$%_)(*&^%$#@#$%^&*()(*&^%$#@  "+line);
                    for(int i=0;i<3;i++)//#numbers of Rules
                        {
                               String s=reader1.readLine();
                               String[] ss=s.split(" ");
                               Rate.set(i,Integer.parseInt(ss[1]));
                        }
            }
            else              
               fileout.println(line);
     }
     
     reader1.close();
     
     if (!fn.delete()) 
                System.out.println("Could not delete file");
     
     fileout.flush();
     fileout.close();   
     
     if(! fout.renameTo(fn))
          System.out.println("Could not rename file");
      
         return Rate;
    }
        
}
/*


TO APPEND IN EXISTING FILE:
  
     FileWriter fout = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature1.txt",true);
            PrintWriter fileout = new PrintWriter(fout,true);
            fileout.println();
            fileout.append(f1);   
            fileout.flush();//
            fileout.close();
   
S:



       //   BufferedWriter out1 = new BufferedWriter(new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature1.txt"));
         // BufferedWriter out2 = new BufferedWriter( new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature2.txt"));          
          //BufferedWriter out3 = new BufferedWriter(new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature3.txt"));            


     //   out1.close();
        // out2.close();
        // out3.close();
*/