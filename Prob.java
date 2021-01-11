package prob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
interface cal{ 						//Interface which is used to implement Lambda function calhex
	void calhex(String s);
}
class Calci  {

void hexCalculate(String data){			// Function will accept String and convert to Integer's hex code

	cal x=(String s)->{
		int t=0;
    for(int i=0;i<data.length();i++) {
    	if(Character.isDigit(data.charAt(i)))		//Only accepting Digits not WhiteSpaces
    	{
    		t=t*10+(data.charAt(i)-'0');		//Converting String to Integer
    	}
    }
    System.out.println(t+" "+Integer.toHexString(t));	//Printing Integer along with Hex code

try{

File file = new File("C:\\Users\\prakhar.shukla\\Downloads\\solution.txt"); //Creating a new file to write values(INteger and it's hex code)
FileWriter fr = new FileWriter(file, true);
BufferedWriter br = new BufferedWriter(fr);
br.write(t+" -> "+Integer.toHexString(t));	//Writing in a Specific format Integer -> Hex Code
br.newLine();
br.close();
fr.close();

}
	
catch (Exception e){
System.out.println(e);				//Printing if Exception occurs
}

};
	x.calhex(data);
}
}
class B extends Calci implements Runnable {

String s;
B(String s1){			//Parametarized constructor initialization
s=s1;
}

@Override
public void run(){
hexCalculate(s);
}

}

public class Prob{

public static void main(String[] args) throws IOException  {

File file= new File("C:\\Users\\prakhar.shukla\\Downloads\\prob1.txt");		//Reading from the File prob1.txt

BufferedReader br = new BufferedReader(new FileReader(file));
 

ExecutorService pool = Executors.newFixedThreadPool(5);				//Implementing Executor Framework for 5 threads
 
String st;
 while ((st = br.readLine()) != null) {
   Runnable r=new B(st);
   pool.execute(r);								//Executing Threads
 
}


br.close();
pool.shutdown();								//Shutting Down Executor Framework Pool
}


}
