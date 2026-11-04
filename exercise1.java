package lab4;
import java.io.File;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
public class exercise1 {

	public static void main(String[] args) {
		
		File f = new File("LuckyNumber.csv");
		Random r = new Random();
		try 
		{
			if(f.createNewFile())
			{
				System.out.println("The file is created\n");
			}
			else
			{
				System.out.println("File already exist");
			}
			FileWriter fw = new FileWriter(f);
			fw.write("List of 500 random numbers\n");
			
			for(int i =0 ; i<500; i++)
			{
				int random = r.nextInt(500);
				
				fw.write(random + "\n");
			}
			fw.close();
			FileReader fr = new FileReader(f);
			Scanner sc = new Scanner(fr);
			sc.useDelimiter("\n");
			while(sc.hasNext())
			{
				System.out.println(sc.next());
			}
			sc.close();
		    
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}

}
