package problem;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
interface convhex{
	int conv(int t);
}
public class problem extends Thread{
	
	String data;
	public static ArrayList<String> b=new ArrayList<String>();
	public static ArrayList<String> c=new ArrayList<String>();

	public problem(String data) {
		this.data=data;
	}
	
	public void run()
	{
		
		int t=0;
        for(int i=0;i<data.length();i++) {
        	if(Character.isDigit(data.charAt(i)))
        	{
        		t=t*10+(data.charAt(i)-'0');
        	}
        }
        System.out.println(c+" "+b);
        c.add(Integer.toString(t));
        b.add(Integer.toHexString(t));
	}

	public static void main(String[] args)throws IOException {
		ArrayList<String> a=new ArrayList<String>();
	    try {
	      File myObj = new File("C:\\Users\\prakhar.shukla\\Downloads\\prob1.txt");
	      Scanner sc = new Scanner(myObj);
	      while (sc.hasNextLine()) {
	    	  String data = sc.nextLine();
	    	  a.add(data);
	      }	        
	        for(int i=0;i<5;i++) {
	        problem t1=new problem(a.get(5*i+0));
	        problem t2=new problem(a.get(5*i+1));
	        problem t3=new problem(a.get(5*i+2));
	        problem t4=new problem(a.get(5*i+3));
	        problem t5=new problem(a.get(5*i+4));
	        
	        t1.start();
	        t2.start();
	        t3.start();
	        t4.start();
	        t5.start();
	        
	        }
	        
	        //convhex c=(p)->{ };
	       // b.add(Integer.toString(t));
	        // a.add(Integer.toHexString(t));
	      // System.out.println(t+" "+Integer.toHexString(t));
	      

	      
	      try {
	        	
	        	File fout = new File("C:\\Users\\prakhar.shukla\\Downloads\\filename.txt");
	        	FileOutputStream fos = new FileOutputStream(fout);	         
	        	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
	         
	        	for (int i = 0; i < b.size(); i++) {
	        		bw.write(c.get(i)+" -> "+b.get(i));
	        		bw.newLine();
	        	}
	         
	        	bw.close();
	        	
	            /*FileWriter myWriter = new FileWriter("C:\\Users\\prakhar.shukla\\Downloads\\filename.txt");
	          // String f=Integer.toString(t)+" -> "+Integer.toHexString(t);
	           // for (int i = 0; i < data.length(); i++)
	            for (int i = 0; i < a.size(); i++) {
	            myWriter.write();	
	            System.out.println();
	            }
	            myWriter.close();
	           // System.out.println("Successfully wrote to the file.");*/
	          
	        }catch (IOException e) {
	            System.out.println("An error occurred.");
	            
	          }
	    
	        
	      
	      sc.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	  }
	    }



	
