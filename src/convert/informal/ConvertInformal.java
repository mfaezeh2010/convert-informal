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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Faezeh
 */

public class ConvertInformal {

    /**
     * @param args the command line arguments
     * 
     * R1+R1+R2=> path=R1 , cs=null - path=R1 , cs=R1 -path=R2  ,cs=R1
     * 
     */
    //wrd,j,xpth,FRate1,FRate2,FRate3,f1,f2,f3
    static boolean PathNotExists(String xpth,Vector<String>AcceptedPath){
        
        
    for(int g=0;g<AcceptedPath.size();g++){
      System.out.println("%%%%%%%%%%%%%%%%%%%%%% xpath:"+xpth+"  elem:"+AcceptedPath.get(g)+"size "+AcceptedPath.size());   
    if(AcceptedPath.get(g).equals(xpth)){
      
    return false;
        }
    }
    return true;
    }
    static boolean CheckAndUpdateRate(Vector<String> AcceptedPath,String w,String xpth,Vector<Integer> FR1,Vector<Integer>FR2,Vector<Integer>FR3,String f1,String f2,String f3,String nowRule) throws IOException{
        //return true/false if this path is assepeted or not
        
        
           FR1=Features.FindFeature(f1,w,1);
         FR2=Features.FindFeature(f2,w,2);
         FR3=Features.FindFeature(f3,w,3);
        
         for(int h=1;h<4;h++){
         System.out.println("ffffffffffff1111111111111111111111111 R"+h+" "+FR1.get(h-1));
         System.out.println("ffffffffffff2222222222222222222222222 R"+h+" "+FR2.get(h-1));
         System.out.println("ffffffffffff3333333333333333333333333 R"+h+" "+FR3.get(h-1));
         }
            
        int count=0; 
        FileWriter fout = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\AllPath.txt",true);
            PrintWriter fileout = new PrintWriter(fout,true);
            //to add updated rates
            FileWriter fout1 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature1.txt",true);
            PrintWriter fileout1 = new PrintWriter(fout1,true);
            
            FileWriter fout2= new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature2.txt",true);
            PrintWriter fileout2 = new PrintWriter(fout2,true);
                            
            FileWriter fout3 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\feature3.txt",true);
            PrintWriter fileout3 = new PrintWriter(fout3,true);
            
        
        String f="";
        Vector<Integer>FR=new Vector<Integer>();
        
        Vector<String> wordx=new Vector<String>();
       // System.out.print(nowRule);
        BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+nowRule.charAt(1)+".txt"));
                while (reader1.ready()) {
	  		String line=reader1.readLine();
                        wordx.add(line);
                        //System.out.println(wordx.size());
                }
        for(int g=0;g<wordx.size();g++)        
        if(wordx.get(g).equals("ABREA")){
            
            System.out.println("matcheeeeeeeeeeeeed  "+xpth);
            System.out.println(wordx.get(g));
                 
            //System.out.println("+++++"+xpth);
                //chang the Rate and write throught feature file
            if(PathNotExists(xpth,AcceptedPath))
            for(int v=1;v<4;v++){//chang feature files for all files   code shpuld be cleaned <tekrari>
                    //set eature and rates
//System.out.println("ACCCCCCCCCCCCCCCCCEPTED  "+xpth);
        if(v==1){
            f=f1;   
        FR.add(FR1.get(0));
        FR.add(FR1.get(1));
        FR.add(FR1.get(2));
        }
        else if(v==2){
            f=f2;
        FR.add(FR2.get(0));
        FR.add(FR2.get(1));
        FR.add(FR2.get(2));
        }
        else{
            f=f3;
        FR.add(FR3.get(0));
        FR.add(FR3.get(1));
        FR.add(FR3.get(2));
        }
        
                for(int h=0;h<xpth.length()-1;h=h+2){
               if(xpth.subSequence(h, h+2).equals("R1")){
                   int tmp=FR.get(0);
                   FR.set(0,tmp+1);}
               if(xpth.subSequence(h, h+2).equals("R2")){
                   int tmp=FR.get(1);
                   FR.set(1,tmp+1);}
               if(xpth.subSequence(h, h+2).equals("R3")){
                   int tmp=FR.get(2);
                   FR.set(2,tmp+1);}
            }
        System.out.println("["+f+"]");
        System.out.println("["+FR.get(0)+"]"+FR.get(1)+"]"+FR.get(2));
            if (v==1){
            fileout1.append(f+"\n");
            fileout1.append("R1 "+FR.get(0)+"\n");
            fileout1.append("R2 "+FR.get(1)+"\n");
            fileout1.append("R3 "+FR.get(2)+"\n");
            }
            if(v==2){
                
            fileout2.append(f+"\n");
            fileout2.append("R1 "+FR.get(0)+"\n");
            fileout2.append("R2 "+FR.get(1)+"\n");
            fileout2.append("R3 "+FR.get(2)+"\n");
            }
            if(v==3){
            
            fileout3.append(f+"\n");
            fileout3.append("R1 "+FR.get(0)+"\n");
            fileout3.append("R2 "+FR.get(1)+"\n");
            fileout3.append("R3 "+FR.get(2)+"\n");
            }
            FR.clear();
           // f="";
        //write this pathe as accepted path throw the file AllPath
            fileout.append(f+"\n");
            fileout.append(xpth+"\n");
            
            
            }
 // break;
//return AcceptedPath;
                
            fileout.close();
            fileout1.close();
            fileout2.close();
            fileout3.close();
            System.out.println("***************************************************************FINSH UP***********************************");
            return true;
                
        }
      
        else {//for else we have to write the past record just into the file
           count++;
           if(count==wordx.size()-1 || !PathNotExists(xpth,AcceptedPath)){
            System.out.print("]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
         for(int v=1;v<4;v++){
             if(v==1){
            f=f1;   
        FR.add(FR1.get(0));
        FR.add(FR1.get(1));
        FR.add(FR1.get(2));
        }
        else if(v==2){
            f=f2;
        FR.add(FR2.get(0));
        FR.add(FR2.get(1));
        FR.add(FR2.get(2));
        }
        else{
            f=f3;
        FR.add(FR3.get(0));
        FR.add(FR3.get(1));
        FR.add(FR3.get(2));
        }
        
                for(int h=0;h<xpth.length()-1;h=h+2){
               if(xpth.subSequence(h, h+2).equals("R1")){
                   int tmp=FR.get(0);
                   FR.set(0,tmp);}
               if(xpth.subSequence(h, h+2).equals("R2")){
                   int tmp=FR.get(1);
                   FR.set(1,tmp);}
               if(xpth.subSequence(h, h+2).equals("R3")){
                   int tmp=FR.get(2);
                   FR.set(2,tmp);}
            }
        System.out.println("["+f+"]");
        System.out.println("["+FR.get(0)+"]"+FR.get(1)+"]"+FR.get(2));
            if (v==1){
            fileout1.append(f+"\n");
            fileout1.append("R1 "+FR.get(0)+"\n");
            fileout1.append("R2 "+FR.get(1)+"\n");
            fileout1.append("R3 "+FR.get(2)+"\n");
            }
            if(v==2){
                
            fileout2.append(f+"\n");
            fileout2.append("R1 "+FR.get(0)+"\n");
            fileout2.append("R2 "+FR.get(1)+"\n");
            fileout2.append("R3 "+FR.get(2)+"\n");
            }
            if(v==3){
            
            fileout3.append(f+"\n");
            fileout3.append("R1 "+FR.get(0)+"\n");
            fileout3.append("R2 "+FR.get(1)+"\n");
            fileout3.append("R3 "+FR.get(2)+"\n");
            }
            FR.clear();
            
            }
        
        }
        
        }
        //else
          //  System.out.println("nooooooooooooot matcheddddddddd");
        //what if the word dident match
        
    
            fileout.close();
            fileout1.close();
            fileout2.close();
            fileout3.close();
            System.out.println("***************************************************************FINSH UP***********************************");
        return false; 
    }
    static public void Implement(String path,Vector<String> word,String cs) throws FileNotFoundException, IOException{
      
        
        if(cs.equals("")){
        Ruls.chooseRule(path,word) ;
        System.out.println("iiiiiiiiiiiiiiiiif       "+word.size());
        }
    //write checker function if reached result??!!   
        else{
            System.out.println("elseeeeee");
             //file name depends on cs
             Vector<String> wordx=new Vector<String>();
             BufferedReader reader1 = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+cs.charAt(1)+".txt"));
             
             
             //file name depends on path
             String g=cs.concat(path);
                while (reader1.ready()) {
	  		String line=reader1.readLine();
                       wordx.add(line);
                     if(g.equals("R2R1"))   
                           System.out.println(line);
                }
                
                  FileWriter fstream1 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+path.charAt(1)+".txt");
             BufferedWriter out1 = new BufferedWriter(fstream1);
             out1.write("");
             out1.close();
             
                    
            System.out.println("********************gggggggggggggggggg************    "+wordx.size()+"   "+wordx.get(wordx.size()-1));
                
    for(int o=0;o<wordx.size();o++){
               //System.out.println("-------------------------------------------------------    "+wordx.get(o)+"  "+o);

      word=Tokenizer.ToSeperate(wordx.get(o));      // word.a
      Ruls.chooseRule(path,word) ;
                
        }
                
           
                
            }
        
      System.out.println("***************************************************************FINSH IMMMP***********************************");
    
    }
    static void clearFiles() throws IOException{
        System.out.print("cleeeeeeeeeeaaaaaaaaaaredddd");
            FileWriter fout = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"1"+".txt");
            PrintWriter fileout = new PrintWriter(fout);
            //PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"1"+".txt"););
            fout.write("");
            fout.close();
    
            FileWriter fout1 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"2"+".txt");
            PrintWriter fileout1 = new PrintWriter(fout1);
            //PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"1"+".txt"););
            fout1.write("");
            fout1.close();
            
            FileWriter fout2 = new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"3"+".txt");
            PrintWriter fileout2 = new PrintWriter(fout2);
            //PrintWriter writer = new PrintWriter(new FileWriter("C:\\Users\\Faezeh\\Desktop\\webIR\\Results\\res"+"1"+".txt"););
            fout2.write("");
            fout2.close();
    
    
    }
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        
        ArrayList<String> paths = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Faezeh\\Desktop\\webIR\\RulePaths.txt"));
        while (reader.ready()) {
	  		String line=reader.readLine();
                        paths.add(line);             
        }
        
         //creat the tpe of the feature that it has general form : num-A-B-B'-C-C'
         //f1=first letter - f2=middle letter - f3=last letter
   
        String wrd="ABRA";//we should read word from dfile  do it
        String f1="1-",f2="2-",f3="3-"; 
        
         Vector<String> word=new Vector<String>();
         Vector<Integer> FRate1=new Vector<Integer>();
         Vector<Integer> FRate2=new Vector<Integer>();
         Vector<Integer> FRate3=new Vector<Integer>();
         
         word=Tokenizer.ToSeperate(wrd); 
         
         
         f1+=word.get(0)+"-null-null-"+word.get(1)+"-"+word.get(2);
         if(word.size()==4)//4 harfi problem O 3 harfi
         f2+=word.get(word.size()/2)+"-"+word.get(word.size()/2)+"-"+word.get(word.size()/2-1)+"-"+word.get(word.size()/2+1)+"-null";
         else if(word.size()==3)//4 harfi problem O 3 harfi
         f2+=word.get(word.size()/2)+"-"+word.get(word.size()/2)+"-null"+"-"+word.get(word.size()/2+1)+"-null";
         else
         f2+=word.get(word.size()/2)+"-"+word.get(word.size()/2-1)+"-"+word.get(word.size()/2-2)+"-"+word.get(word.size()/2+1)+"-"+word.get(word.size()/2+2);
         f3+=word.get(word.size()-1)+"-"+word.get(word.size()-2)+"-"+word.get(word.size()-3)+"-null-null" ;
         //obtain the rate:
         FRate1=Features.FindFeature(f1,wrd,1);
         FRate2=Features.FindFeature(f2,wrd,2);
         FRate3=Features.FindFeature(f3,wrd,3);
        
         

        //Implement(paths,word,FRate1,FRate2,FRate3,f1,f2,f3,cs);
         String cs="",xpth="";
         Vector<String>AcceptedPath=new Vector<String>();
        //results are same for each feature just we have to assign the results
        for(int i=0;i<paths.size();i++){//for all pasible paths  (R1+R1+R2+R3)          --->can be limited
         
            clearFiles();
            xpth="";
         cs="";
            System.out.println("------------------------------>"+paths.get(i)+"uuuuuuuuuuu  "+word.size());
        
         
            for(int k=0;k<paths.get(i).length()-1;k=k+2){
                
                
           String nowRule=paths.get(i).substring(k, k+2) ;
           System.out.println(">>>>>>"+paths.get(i).substring(k, k+2)+"uuuuuuuuuuu  "+word.size());
        // System.out.println("cs "+cs);   
         //System.out.println("nowrule "+nowRule);
         if(paths.get(i).charAt(k)=='R' && paths.get(i).charAt(k+1)=='1'){
             System.out.println("############"+paths.get(i).substring(k, k+2)+"pppppppp"+word.size());
             Implement("R1",word,cs);
             xpth+="R1";
                           cs="R1";//doros kon 
         }
         
         //if its true we have to  update our rates and adds selected path to file (j shows whitch feature is applying)(cs in the argoman shows witch file should be checked
         if(paths.get(i).charAt(k)=='R' && paths.get(i).charAt(k+1)=='2'){
          Implement("R2",word,cs);
          xpth+="R2";
                           cs="R2";
         }
         
          if(paths.get(i).charAt(k)=='R' && paths.get(i).charAt(k+1)=='3'){
          Implement("R3",word,cs);
          xpth+="R3";
                           cs="R3";
          }
         
         if(CheckAndUpdateRate(AcceptedPath,wrd,xpth,FRate1,FRate2,FRate3,f1,f2,f3,nowRule)){
           System.out.println("))))))))))))))))))))))  "+xpth);
             AcceptedPath.add(xpth);    
         }
        //add the end of each path res files should be cleared
         
        } 
         
      }
        
        
         
         
         
         
         
         
         ///PAK KON VECTOR FEATURE RO VASE KALAME BAAAADIII
      
    
    }
    
}
