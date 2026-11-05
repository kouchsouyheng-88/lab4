package lab4;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



public class exercise3 {

	public static void main(String[] args) {
		File f = new File("Ex3StudentData.csv");
		Scanner sc = new Scanner(System.in);
		try {
			if(f.createNewFile())
			{
				System.out.println("The file name StudentData is created");
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		try
		{
			FileWriter fw = new FileWriter(f, true);
			fw.write("Name,ID,Gender\n");
			System.out.println("Enter Your Team Info\n");
			for(int i =0 ; i<3; i++)
			{
				System.out.print("Name: ");
				String name = sc.nextLine();
				
				System.out.print("ID: ");
				String id = sc.nextLine();
				
				System.out.print("Gender: ");
				String gen = sc.nextLine();
				fw.write(name + "," + id +"," + gen + "\n");
				
			}
			fw.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		sc.close();
		

	}

}
