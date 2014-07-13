/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convert.informal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Faezeh
 */
public class Tokenizer {
    
 static  public Vector<String> ToSeperate(String name) throws FileNotFoundException, IOException{
        ArrayList<String> Tokens = new ArrayList<String>();
        Vector<String> ConvertedWord=new Vector<String>();
        //set Tokenz
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\tokens.txt"));
        while (reader.ready()) {
	  		String line=reader.readLine();
                        Tokens.add(line);
        }             
        
        Vector<String> UsedT=new Vector<String>();
        int cnt=0;
           
        for(int i=0;i<Tokens.size();i++){
        //     if(name.matches("["+Tokens.get(i)+"].*"))//has more than one of than alfabet
          //     System.out.println("ssss");
            if(name.contains(Tokens.get(i))){
                int SInx=name.indexOf(Tokens.get(i));
                UsedT.add(Tokens.get(i));     
                name=name.subSequence(0,SInx)+Integer.toString(cnt)+name.subSequence(Tokens.get(i).length()+SInx,name.length());     
               // System.out.println(name); 
                cnt++;
            }
        }   
             for(int j=0;j<name.length();j++){
 //System.out.println("...............................  "+name.charAt(j));     
     if(Character.isDigit(name.charAt(j)))
         ConvertedWord.add(UsedT.get( Character.getNumericValue(name.charAt(j))));
     else
         ConvertedWord.add(Character.toString(name.charAt(j)));
     }            
        return ConvertedWord;
    }
    
}
