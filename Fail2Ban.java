import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class Fail2Ban 
{
	public static void main(String[] args) throws FileNotFoundException 
	{
		File f = new File(args[0]);
		PrintWriter output = new PrintWriter(new File(args[1]));
		Scanner input = new Scanner(f);
       //first, check how many invalid ip addresses are in the file given by using an invalidLine number counter
        ArrayList<String> invalidAddresses = new ArrayList<>();
		while(input.hasNextLine()) 
		{
			String line = input.nextLine();
			if (line.contains("Invalid")) 
			{
				int startIndex = line.indexOf("from ");
				String ipAddress=line.substring(startIndex+5);
				invalidAddresses.add(ipAddress);
			}
		}
		ArrayList<String> outputAddresses = new ArrayList<>();
		int outputCount=0;
		for (int i=0; i<invalidAddresses.size();i++) 
		{
			if (isTriple(i,invalidAddresses)==true&&isAlreadyPresent(i,outputAddresses,invalidAddresses,outputCount)==false)
			{
				System.out.println("triple found!");
				outputAddresses.add(outputCount, invalidAddresses.get(i));
				output.println(invalidAddresses.get(i));
				outputCount++;
			}
		}
		output.close();
		input.close();
	}
	public static boolean isTriple(int potentialtripleIndex, ArrayList<String> invalidAddresses)
	{
		boolean isTriple=false;
		int tripleCount=0;
		for (int i=0;i<invalidAddresses.size();i++) 
		{
			if (invalidAddresses.get(i).equals(invalidAddresses.get(potentialtripleIndex)))
			{
				tripleCount++;
			}
			if (tripleCount==3) 
			{
				isTriple=true;
				break;
			}
		}
		return isTriple;
		
	}
	public static boolean isAlreadyPresent (int index, ArrayList <String> outputAddresses, ArrayList<String> invalidAddresses,int outputCount)
	{
		boolean isAlreadyPresent=false;
		if (outputAddresses.size()>1) 
		{
			for (int i=0;i<outputCount;i++) 
			{
				if (outputAddresses.get(i).equals(invalidAddresses.get(index))&&i!=index) 
				{
					isAlreadyPresent=true;
					break;
				}
			}
		}
		return isAlreadyPresent;
	}
}