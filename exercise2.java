package lab4;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.Random;
import java.util.ArrayList;
public class exercise2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File directory = new File("Ex2LuckyNumber");
		String name;
		System.out.println("How many files do you want? ");
		int n = sc.nextInt();
		if(directory.mkdir())
		{
			System.out.println("The directory is created and every files will store here");
		}
		else
		{
			System.out.println("The directory is already created and the files will store here \n");
		}
		Random r = new Random();
		for(int i = 1; i<=n; i++)
		{
			name = "file" + i + ".csv";
			File f = new File(directory, name);
			try(FileWriter fw = new FileWriter(f))
			{
				for(int k =0; k<10; k++)
				{
					int rand = r.nextInt(100) + 1;
					fw.write(rand + "\n");
				}
			}catch(IOException e)
			{
				e.printStackTrace();
			}

		}
		System.out.println("...Success fully write 100 numbers to files and store in folder");
		ArrayList<Integer> luckyNumLists = new ArrayList<>();
		for(int i = 1; i<= n; i++)
		{
			name = "file" + i + ".csv";
			File f = new File(directory, name);
			if(f.exists())
			{
				try(Scanner fs = new Scanner(f))
				{
					while(fs.hasNextInt())
					{
					   luckyNumLists.add(fs.nextInt());
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
		System.out.println("\n" + luckyNumLists);
		
		if(!luckyNumLists.isEmpty())
		{
			int max = luckyNumLists.get(0);
			int min = luckyNumLists.get(0);
			for(int num: luckyNumLists)
			{
				if(num > max)
				{
					max = num;
				}
				if(num < min)
				{
					min = num;
				}
			}
			System.out.println("The maximum number is " + max);
			System.out.println("The minimum number is " + min);

		}
				
		
		sc.close();
		
	}

}
 