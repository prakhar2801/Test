package prob;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
interface cal{
	void calhex(String s);
}
class Calci  {

void hexCalculate(String data){

	cal x=(String s)->{
		int t=0;
    for(int i=0;i<data.length();i++) {
    	if(Character.isDigit(data.charAt(i)))
    	{
    		t=t*10+(data.charAt(i)-'0');
    	}
    }
    System.out.println(t+" "+Integer.toHexString(t));

try{

File file = new File("C:\\Users\\prakhar.shukla\\Downloads\\solution.txt");
FileWriter fr = new FileWriter(file, true);
BufferedWriter br = new BufferedWriter(fr);
br.write(t+" -> "+Integer.toHexString(t));
br.newLine();
br.close();
fr.close();

}
	
catch (Exception e){
System.out.println(e);
}

};
	x.calhex(data);
}
}
class B extends Calci implements Runnable {

String s;
B(String s1){
s=s1;
}

@Override
public void run(){
hexCalculate(s);
}

}

public class Prob{

public static void main(String[] args) throws IOException  {

File file= new File("C:\\Users\\prakhar.shukla\\Downloads\\prob1.txt");
System.out.println(file);
BufferedReader br = new BufferedReader(new FileReader(file));
 

ExecutorService pool = Executors.newFixedThreadPool(5);
 
String st;
 while ((st = br.readLine()) != null) {
   Runnable r=new B(st);
   pool.execute(r);
 
}


br.close();
pool.shutdown();
}


}