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
import java.util.Vector;

/**
 *
 * @author Faezeh
 */
public class Ruls {
    static void chooseRule(String path,Vector<String> word) throws IOException{
              

 if(path.equals("R1")){
         Rule1(word);   
        // word.clear();
        }
      
        if(path.equals("R2")){
         Rule2(word);   
         //word.clear();
        }
        
        if(path.equals("R3")){
         Rule3(word);   
        // word.clear();
        }
    

    }
    //Rules are applied on each word.
    static public void Rule1(Vector<String> words) throws FileNotFoundException, IOException{
         File log = new File("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res1.txt");
    PrintWriter out  =new PrintWriter(new FileWriter(log, true));
    Vector<String> Letters=new Vector<String>();
   // words.add(0,null);
   // words.add(words.size(),"");
    String CompleteWord = "";
    BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\letters-1.txt"));
        while (reader.ready()) {
	  		String line=reader.readLine();
                        Letters.add(line);
        }             
   //fileWriter fstream = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res1.txt");
   //ufferedWriter out = new BufferedWriter(fstream);	    
    for(int i=0;i<Letters.size();i++){
        for(int j=0;j<words.size()+1;j++){
           
        if(j==words.size()){
        words.add(Letters.get(i));
        //j=words.size()-1;
        }
        else
        words.add(j,Letters.get(i));
        
        for(int l=0;l<words.size();l++)
           CompleteWord+=words.get(l);
      // System.out.println(CompleteWord);
      //  out.println();
        
       //  if(Letters.get(i).equals("E"))
               // System.out.println("__________________________________ "+CompleteWord);
        
        out.append(CompleteWord+"\n");
        words.removeElementAt(j);
        CompleteWord=""; 
        // System.out.println("(((((((((((((((((((((((((((((((((  ");
        }
    }    
    out.close();
    
    }

static public void Rule2(Vector<String> words) throws IOException {
    
    File log = new File("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res2.txt");
    PrintWriter out1 = new PrintWriter(new FileWriter(log, true));
   // FileWriter fstream1 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res2.txt");
    //BufferedWriter out1 = new BufferedWriter(fstream1); 
    Vector<String>wrd=new Vector<String>();
    String CompleteWord="";
    
  int s =words.size();
  for(int g=0;g<s;g++)
  System.out.println("RULEEEEEEEEEEEEEEE2  "+words.size()+"      ["+words.get(g)+"]");
    for(int g=0;g<words.size();g++){
    String rmvedLttr=words.get(g);
    words.removeElementAt(g);
    
    for(int l=0;l<words.size();l++)
    CompleteWord+=words.get(l);
    
          System.out.println("RULEEEEEEEEEEEEEEE2 "+ CompleteWord+"     " +rmvedLttr +"     "+g+"      "+words.size());
    //  System.out.println(CompleteWord);
    out1.append(CompleteWord+"\n");
    words.add(g,rmvedLttr);
    CompleteWord=""; 
    rmvedLttr="";
    }
   
    out1.close();
   
}

 static public void Rule3(Vector<String> words) throws IOException{
    File log = new File("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res3.txt");
    PrintWriter out1 = new PrintWriter(new FileWriter(log, true));
    Vector<String>Letters =new Vector<String> ();
    
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\letters-1.txt"));
        while (reader.ready()) { 
	  		String line=reader.readLine();
                        Letters.add(line);
        }
     String CompleteWord ="";
    for(int e=0;e<Letters.size();e++)
     for(int g=0;g<words.size();g++){
        String rmvedLttr=words.get(g);
        words.set(g,Letters.get(e));
    for(int l=0;l<words.size();l++)
    CompleteWord+=words.get(l);
    //  System.out.println(CompleteWord);
    out1.append(CompleteWord+"\n");
    words.set(g,rmvedLttr);
    CompleteWord=""; 
    }
     out1.close();
     
 }


}
